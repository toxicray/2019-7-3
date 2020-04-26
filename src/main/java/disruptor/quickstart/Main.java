package disruptor.quickstart;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:disruptor.quickstart
 * *Author:ray
 * *version:...
 * *Created in 2020/4/24  0:21
 **/
public class Main {
	public static void main(String[] args) {
		//1 实例化一个disruptor对象
		OrderEventFactory eventFactory = new OrderEventFactory();
		int ringBufferSize = 1024*1024;
		ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
				eventFactory,   //创建对象
				ringBufferSize,  //容器的大小
				threadPool,  //线程池
				ProducerType.SINGLE,   //生产者的模式
				new BlockingWaitStrategy()  //等待策略
		);

		//添加消费者的监听,disruptor和消费者的关联关系
		disruptor.handleEventsWith(new OrderEventHandler());

		//启动disruptor
		disruptor.start();

		//获取实际存储数据的容器
		RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

		OrderEventProducer producer = new OrderEventProducer(ringBuffer);

		ByteBuffer byteBuffer = ByteBuffer.allocate(8);

		for (long i = 0; i < 100l; i++) {
			byteBuffer.putLong(0,i);//每次都把数据放到0这个位置
			producer.sendData(byteBuffer);
		}

		disruptor.shutdown();
		threadPool.shutdown();
	}
}
