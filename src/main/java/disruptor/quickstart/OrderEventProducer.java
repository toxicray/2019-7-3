package disruptor.quickstart;

import com.lmax.disruptor.RingBuffer;
import org.aspectj.weaver.ast.Var;

import java.nio.ByteBuffer;

/**
 * Package:disruptor.quickstart
 * *Author:ray
 * *version:...
 * *Created in 2020/4/24  0:39
 **/
public class OrderEventProducer {
	private RingBuffer<OrderEvent> ringBuffer;

	public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * 	发送消息的代码逻辑
	 */
	public void sendData(ByteBuffer byteBuffer){
		long sequence = ringBuffer.next();//获取下一个可用的序号,我们叫sequence
		//发送消息的时候,从ringbuffer获取一个可用的序号

		try {
			//根据这个序号   找到我们所需要的orderEvent元素,此时获取的是没有填充的数据
			//也就是属性没有被赋值
			OrderEvent orderEvent = ringBuffer.get(sequence);
			orderEvent.setValue(byteBuffer.getLong(0));   //获取bytebUffer的的数据
		} finally {
			//提交发布数据
			ringBuffer.publish(sequence);
		}
	}
}
