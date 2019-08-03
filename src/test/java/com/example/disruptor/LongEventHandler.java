package com.example.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Package:com.example.disruptor
 * *Author:ray
 * *version:...
 * *Created in 2019/7/24  23:29
 **/
public class LongEventHandler implements EventHandler<LongEvent> {


	/**
	 *@Description 
			* @Param 用于写消费逻辑
			* @return 
			**/
	@Override
	public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
		System.out.println(longEvent.getValue());
	}
}
