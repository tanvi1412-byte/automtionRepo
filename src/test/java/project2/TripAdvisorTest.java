package project2;

import org.testng.annotations.Test;

import com.project.commonLib.BaseClass;
import com.project.commonLib.GenericLib;
import com.project.commonLib.PropertyReader;
import com.project.objectRepo.TripAdvisorPage;



public class TripAdvisorTest extends BaseClass  {
	
	@Test
	public void submitReviewTest() throws Throwable
	{
		TripAdvisorPage tripAdvisor=new TripAdvisorPage(driver);
		tripAdvisor.submitReview();
		
	}

}
