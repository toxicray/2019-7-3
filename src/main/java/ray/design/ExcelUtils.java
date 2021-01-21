

package ray.design;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 */
public class ExcelUtils {

	/**
	 * 每个sheet的记录数
	 */
	private static final int SHEET_SIZE = 50000;

	private static final Logger LOG = LoggerFactory.getLogger(ExcelUtils.class);

	@SuppressWarnings("unused")
	public static void getReflectInfo(Class<?> c, List<?> voList, String filename, HttpServletResponse response)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		int voSize = voList.size();
		final int sheetTotal = (voSize / SHEET_SIZE) + (voSize % SHEET_SIZE == 0 ? 0 : 1);
		SXSSFWorkbook wb = new SXSSFWorkbook();
		for (int i = 0; i < sheetTotal; i++) {
			formationExcel(c, voList, filename + (i + 1), wb, i * SHEET_SIZE, i * SHEET_SIZE + SHEET_SIZE);
		}
		// 如果没有数据，导出空模板
		if (sheetTotal == 0) {
			formationExcel(c, voList, filename, wb, 0, 0);
		}		
		try {
			// 设置文件名
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			wb.write(out);
			out.flush();
			wb.dispose();
			out.close();
		} catch (Exception ex) {
			LOG.warn("Excel导出异常:", ex);
			throw new RuntimeException("导出Excel失败，服务器错误!");
		}
	}

	private static void formationExcel(Class<?> c, List<?> voList, String filename, SXSSFWorkbook wb, int startIndex,
									   int endIndex) {
		int voSize = voList.size();
		// 设置多个Sheet的表头
		Sheet sheet = wb.createSheet(filename);
		Row row = sheet.createRow((int) 0); // 表头
		CellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		CellStyle cellStyle = wb.createCellStyle(); // 创建一个样式
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index); // 设置颜色为红色
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 11);// 设置字体大小
		style.setFont(font);
		cellStyle.setFont(font);
		// 循环设置表头
		Map<Field, ExcelColumn> fieldAnnos = new HashMap<>(32);
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			ExcelColumn excelColumns = field.getAnnotation(ExcelColumn.class);
			if (excelColumns != null) {
				Cell cell = row.createCell(excelColumns.sort());
				sheet.setColumnWidth(i, excelColumns.columnWidth());
				cell.setCellValue(excelColumns.name());
				cell.setCellStyle(cellStyle);
				fieldAnnos.put(field, excelColumns);
			}
		}
		try {
			if (endIndex > voSize) {
				endIndex = voSize;
			}
			// 设置内容
			for (int i = startIndex; i < endIndex; i++) {
				row = sheet.createRow(i - startIndex + 1);
				row.setRowStyle(style);
				Object vo = voList.get(i);
				Set<Entry<Field, ExcelColumn>> fieldEntry = fieldAnnos.entrySet();
				for (Entry<Field, ExcelColumn> entry : fieldEntry) {
					Object result = PropertyUtils.getProperty(vo, entry.getKey().getName());
					ExcelColumn col = entry.getValue();
					if (result == null) {
						row.createCell(col.sort()).setCellValue("");
					} else if (result instanceof Date) {
						row.createCell(entry.getValue().sort())
								.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result));
					}   else if (result instanceof BigDecimal){
						Cell cell = row.createCell(entry.getValue().sort());
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(((BigDecimal)result).doubleValue());
					} else if (result instanceof Integer) {
						Cell cell = row.createCell(entry.getValue().sort());
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(((Integer)result).doubleValue());
					} else if (result instanceof Double) {
						Cell cell = row.createCell(entry.getValue().sort());
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue((Double)result);
					}  else if (result instanceof Float) {
						Cell cell = row.createCell(entry.getValue().sort());
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(((Float) result).doubleValue());
					}
					else {
						row.createCell(entry.getValue().sort()).setCellValue(String.valueOf(result));
					}
				}
			}
		} catch (Exception ex) {
			LOG.warn("Excel导出异常:", ex);
			throw new RuntimeException("导出Excel失败，服务器错误!");
		}
	}
}
