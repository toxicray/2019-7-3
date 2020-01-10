package com.pattern.strategy;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:35
 **/
public class FanxianPromotionStrategy implements  PromotionStrategy{
	@Override
	public void doPromotion() {
		System.out.println("返现");
	}
}
