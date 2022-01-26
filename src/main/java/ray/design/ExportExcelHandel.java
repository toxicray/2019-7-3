///*
// * Copyright  2017 北京易酒批电子商务有限公司. All rights reserved.
// */
//package ray.design;
//
//import com.yijiupi.himalaya.base.search.PagerCondition;
//import com.yijiupi.himalaya.base.utils.AssertUtils;
//import com.yijiupi.himalaya.thirdapi.lock.AvoidDupRedisLock;
//import com.yijiupi.himalaya.thirdapi.requestparam.BaseQuery;
//import org.apache.commons.collections.CollectionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
///**
// * Created by 魏百川 on 2017/11/1.
// */
//@Component
//public class ExportExcelHandel {
//
//    @Autowired
//    private ThreadPoolTaskExecutor excelTreadPoolExecutor;
//
//    @Autowired
//    private AvoidDupRedisLock avoidDupRedisLock;
//
//    private static final Logger LOG = LoggerFactory.getLogger(ExportExcelHandel.class);
//
//    private String dupOperateLock(String methodName) {
//        AssertUtils.hasText(methodName, "methodName为空");
//        Long lockTimeOutSecond = 30L;
//        String lockKey = methodName;
//        String lockValue = UUID.randomUUID().toString();
//        if (!avoidDupRedisLock.lock(lockKey, lockValue, lockTimeOutSecond)) {
//            AssertUtils.fail("导出正在进行中，请勿【连续重复】【点击】按钮，请在30秒后在重试！");
//        }
//        return lockValue;
//    }
//
//    private void dupOperateUnLock(String methodName, String lockValue) {
//        avoidDupRedisLock.unlock(methodName, lockValue);
//    }
//
//    /**
//     * @return void
//     * @Description:Excel导出handle(单线程方式)
//     * @Author: weibaichuan
//     * @param:object 调用类名
//     * @param:methodName 被调用方法名
//     * @param:paramTypes 被调用参数类型集合
//     * @param:params 参数集合
//     * @param:classs 导出的VO类
//     * @param:totalRecord 总记录数
//     * @param:pageSize 每页记录数
//     * @param:fileName 导出的文件名
//     * @param:response Http响应
//     */
//    public void produceExcel(Object object, String methodName, Class[] paramTypes, Object[] params, Class<?> classs,
//                             Integer totalRecord, Integer pageSize, String fileName, HttpServletResponse response) {
//        String lockValue = dupOperateLock(methodName);
//        final long beginTime = System.currentTimeMillis();
//        try {
//            ArrayList<Object> list = new ArrayList<>(totalRecord);
//            Integer totalPage = totalRecord / pageSize + (totalRecord % pageSize == 0 ? 0 : 1);
//            for (int i = 1; i <= totalPage; i++) {
//                params[1] = new PagerCondition(i, pageSize);
//                Method method = object.getClass().getMethod(methodName, paramTypes);
//                List<Object> tmpList = (List<Object>) method.invoke(object, params);
//                if (CollectionUtils.isNotEmpty(tmpList)) {
//                    list.addAll(tmpList);
//                }
//            }
//
//            System.err.println("导出耗时（s）:" + (System.currentTimeMillis() - beginTime) / 1000);
//            ExcelUtils.getReflectInfo(classs, list, fileName, response);
//        } catch (Exception ex) {
//            LOG.warn("Excel导出异常：{}", ex);
//            throw new RuntimeException("导出Excel失败，服务器错误!", ex);
//        } finally {
//            dupOperateUnLock(methodName, lockValue);
//        }
//    }
//
//    /**
//     * @return void
//     * @Description:Excel导出handle(多线程方式)
//     * @Author: weibaichuan
//     * @param:object 调用类名
//     * @param:methodName 被调用方法名
//     * @param:paramTypes 被调用参数类型集合
//     * @param:params 参数集合
//     * @param:classs 导出的VO类
//     * @param:totalRecord 总记录数
//     * @param:pageSize 每页记录数
//     * @param:fileName 导出的文件名
//     * @param:response Http响应
//     */
//    public void produceExcelMultiThread(Object object, String methodName, Class[] paramTypes, Object[] params, Class<?> classs,
//                                        Integer totalRecord, Integer pageSize, String fileName, HttpServletResponse response) {
//        String lockValue = dupOperateLock(methodName);
//        final long beginTime = System.currentTimeMillis();
//        List<Future<?>> submits = new ArrayList<>();
//        try {
//            ArrayList<Object> list = new ArrayList<>(totalRecord);
//            Integer totalPage = totalRecord / pageSize + (totalRecord % pageSize == 0 ? 0 : 1);
//
//            ArrayList<listPage> listPages = new ArrayList<>();
//            excelTreadPoolExecutor.setCorePoolSize(4);
//            excelTreadPoolExecutor.setMaxPoolSize(8);
//            excelTreadPoolExecutor.setQueueCapacity(100);
//
//            for (int i = 1; i <= totalPage; i++) {
//                Object[] newArr = params.clone();
//                newArr[1] = i;
//                BaseQuery o = (BaseQuery)newArr[0];
//                newArr[0] = o.clone();
//                listPage task = new listPage(object, newArr, i, pageSize, methodName, paramTypes);
//                listPages.add(task);
//            }
//
//            if (CollectionUtils.isNotEmpty(listPages)) {
//                listPages.forEach(page -> {
//                    Future<List<Object>> submit = excelTreadPoolExecutor.submit(page);
//                    submits.add(submit);
//                });
//            }
//            for (Future<?> submit : submits) {
//                List<Object> tmpList = (List<Object>) submit.get();
//                if (CollectionUtils.isNotEmpty(tmpList)) {
//                    list.addAll(tmpList);
//                }
//            }
//            System.err.println("导出耗时（s）:" + (System.currentTimeMillis() - beginTime) / 1000);
//            ExcelUtils.getReflectInfo(classs, list, fileName, response);
//        } catch (Exception ex) {
//            LOG.warn("Excel导出异常：{}", ex);
//            throw new RuntimeException("导出Excel失败，服务器错误!", ex);
//        } finally {
//            dupOperateUnLock(methodName, lockValue);
//        }
//    }
//
//
//    private class listPage implements Callable<List<Object>> {
//
//        private Integer pageSize;
//
//        private Integer currentPage;
//
//        private Object object;
//
//        private Object[] params;
//
//        private String methodName;
//
//        private Class[] paramTypes;
//
//        /**
//         * @return
//         * @Description:多线程分页取数(Excel导出)
//         * @Author: weibaichuan
//         * @param: classs 服务实例
//         * @param:methodName服务方法名
//         * @param:paramTypes 参数类型
//         * @param:params 服务参数
//         * @param:currentPage 当前页
//         * @param:pageSize 每页记录数
//         * @param:list 返回集合
//         */
//        public listPage(Object object, Object[] params, Integer currentPage, Integer pageSize,
//                        String methodName, Class[] paramTypes) {
//            this.object = object;
//            this.params = params;
//            this.currentPage = currentPage;
//            this.pageSize = pageSize;
//            this.methodName = methodName;
//            this.paramTypes = paramTypes;
//        }
//
//        @Override
//        public List<Object> call() {
//            try {
//                this.params[1] = new PagerCondition(this.currentPage, this.pageSize);
//                Method method = object.getClass().getMethod(this.methodName, this.paramTypes);
//                List<Object> list = (List<Object>) method.invoke(this.object, this.params);
//                System.out.println(Thread.currentThread().getName()+"--"+this.currentPage+"--"+this.pageSize);
//                return list;
//            } catch (Exception ex) {
//                LOG.error("error:导出Excel异常:{}", ex);
//                return null;
//            }
//        }
//    }
//}