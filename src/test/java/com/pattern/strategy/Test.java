package com.pattern.strategy;

/**
 * Package:com.pattern.strategy
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:42
 **/
public class Test {
	//public static void main(String[] args) {
	//	PromotionActivity promotionActivity618 = new PromotionActivity(new LijianPromotionStrategy());
	//	PromotionActivity promotionActivity1111 = new PromotionActivity(new ManjianPromotionStrategy());
	//
	//	promotionActivity618.executePromotionStrategy();
	//	promotionActivity1111.executePromotionStrategy();
	//}

	public static void main(String[] args) {
		PromotionActivity promotionActivity=null;
		String promotionKey="LIJIAN";
		promotionActivity.executePromotionStrategy();
	}
}
