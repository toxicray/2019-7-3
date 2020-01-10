package com.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:47
 **/
public class PromotionStrategyFactory {

	private static Map<String,PromotionStrategy> strategyMap=new HashMap<>();


	static{
		strategyMap.put(promotionKey.LIJIAN,new LijianPromotionStrategy() );
		strategyMap.put(promotionKey.MANJIAN,new ManjianPromotionStrategy() );
		strategyMap.put(promotionKey.FANXIAN,new FanxianPromotionStrategy() );
		strategyMap.put("",new LijianPromotionStrategy() );
	}

	private PromotionStrategyFactory(){

	}
	public static PromotionStrategy getPromotionStrategy(String key){
		PromotionStrategy promotionStrategy = strategyMap.get(key);
		return promotionStrategy==null?new DefaultPromotionStrategy():promotionStrategy;
	}

	private interface promotionKey{
		final String LIJIAN="LIJIAN";
		final String MANJIAN="MANJIAN";
		final String FANXIAN="FANXIAN";
	}
}
