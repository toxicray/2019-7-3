package com.example.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Package:com.example.disruptor
 * *Author:ray
 * *version:...
 * *Created in 2019/7/24  23:28
 **/
public class LongEventFactory implements EventFactory {
	@Override
	public Object newInstance() {
		return new LongEvent();
	}
}
