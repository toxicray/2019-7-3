package com.example.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.example.disruptor
 * *Author:ray
 * *version:...
 * *Created in 2019/7/24  23:29
 **/
public class LongEventMain {
	public static void main(String[] args) {
		//创建缓冲线程池
		ExecutorService executor = Executors.newCachedThreadPool();
		//创建工厂
		LongEventFactory factory = new LongEventFactory();
		//创建bufferSize,也就是buffer的大小,必须是2的n次方
		int ringBufferSize = 1024 * 1024;

		////是最低效的策略,对cpu的消耗最小,在不同的部署环境下能提供更加一致的性能表现
		//BlockingWaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();
		////和上面的歌方面表现差不多,但是对生产者的线程影响最小,适用于日志等
		//SleepingWaitStrategy sleepingWaitStrategy = new SleepingWaitStrategy();
		////性能表现是最好的,适合用于低延迟的系统,在要求极高性能且事件处理线程数小于CPU的逻辑处理核心数的场景中
		//YieldingWaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();

		//创建disruptor
		//1,第一个参数为工厂类对象,用于创建一个个的LongEvent,LongEvent是实际的消费对象
		//2,第二个参数是缓冲区的大小
		//3,第三个参数,进行disruptor内部的数据的处理调度
		//4,第4个参数  表明生产者的数量是单个还是多个
		//5,第五个参数,是一种策略,关于生产和消费的处理策略(生产者和消费者的速度不同步,name我们需要去处理他的调度策略)
		Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(factory,ringBufferSize,executor, ProducerType.SINGLE,new YieldingWaitStrategy());


		//连接消费事件方法,可以连接多个
		disruptor.handleEventsWith(new LongEventHandler());

		//启动disruptor
		disruptor.start();

		//发布事件,ringbuffer是生成一个装数据的容器
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

		//创建一个生产者
		LongEventProducer eventProducer=new LongEventProducer(ringBuffer);

		ByteBuffer byteBuffer=ByteBuffer.allocate(8);
		for (long i = 0; i < 100; i++) {
			byteBuffer.putLong(0,i );
			eventProducer.onData(byteBuffer);
		}

		//数据是装进容器
		disruptor.shutdown();
		executor.shutdown();
	}
}
