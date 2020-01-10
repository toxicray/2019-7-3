package com.example.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Package:com.example.disruptor
 * *Author:ray
 * *version:...
 * *Created in 2019/7/25  23:10
 **/
public class LongEventProducer {


	private final RingBuffer<LongEvent> ringBuffer;


	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}


	public void onData(ByteBuffer byteBuffer){
		//将ringbuffer看做是一个事件队列,那么next就是得到下面一个事件槽
		long seq = ringBuffer.next();
		try {

			//使用上面的索引来获取一个空的事件用于装数据
			LongEvent event = ringBuffer.get(seq);
			//获得要通过事件传输的业务数据
			event.setValue((long) byteBuffer.get(0));
		} finally {
			//发布事件,该发布方法必须要在finally里面去执行
			ringBuffer.publish(seq);
		}
	}
}
