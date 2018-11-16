package com.paint.calculator.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.paint.calculator.HomePage;

public class HomePageTests extends BaseTest {
    
    
	@Test
	public void validateTitle() {

		HomePage homePage = new HomePage(driver);

		Assert.assertEquals("Calculating Paint Required", homePage.launchPaintCalculator().getHomePageTitle());
      
    }
	
    @Test
	public void validateNoOfRooms() {

		HomePage homePage = new HomePage(driver);
		String noOfRooms = "5";

		homePage.launchPaintCalculator().goToDimensionsPage(noOfRooms).validateNumberOfRows(noOfRooms);

	}
    
    


}
