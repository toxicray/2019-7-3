package com.pattern.strategy;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:39
 **/
public class PromotionActivity {

	private PromotionStrategy promotionStrategy;


	public PromotionActivity(PromotionStrategy promotionStrategy) {
		this.promotionStrategy = promotionStrategy;
	}

	public void executePromotionStrategy(){
		promotionStrategy.doPromotion();
	}
}
