package project1;

import org.testng.annotations.Test;

import com.project.objectRepo.ValidatePrice;

public class PriceValidationTest {
	@Test
	public void iphonePriceValidation() {
		ValidatePrice price = new ValidatePrice();
		price.validatePrice();
	}
}
