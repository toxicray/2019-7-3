package com.pattern.strategy;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:42
 **/
public class Test {
	public static void main(String[] args) {
		String key= "LIJIAN";
		PromotionActivity promotionActivity=new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(key));
		promotionActivity.executePromotionStrategy();
	}
}
