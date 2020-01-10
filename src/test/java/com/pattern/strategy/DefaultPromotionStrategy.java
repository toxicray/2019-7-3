package com.pattern.strategy;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:52
 **/
public class DefaultPromotionStrategy implements  PromotionStrategy {
	@Override
	public void doPromotion() {
		System.out.println("无促销");
	}
}
