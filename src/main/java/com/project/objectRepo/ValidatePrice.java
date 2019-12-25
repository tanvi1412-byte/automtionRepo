package com.project.objectRepo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ValidatePrice {
	double amazonProductPrice = AmazonPage.actAmazonProductPrice;
	double flipkartProductPrice = FlipkartPage.actFlipkartProductPrice;

	public void validatePrice() {
		if (amazonProductPrice > flipkartProductPrice) {
			Reporter.log("Flipkart has Lesser Price than Amazon", true);
			Reporter.log("Price:" + flipkartProductPrice, true);
		} else if (amazonProductPrice < flipkartProductPrice) {
			Reporter.log("Amazon has Lesser Price than flipkart", true);
			Reporter.log("Price:" + amazonProductPrice, true);
		} else {
			Reporter.log("Amazon and Flipkart Both have same price", true);
		}
	}
}
