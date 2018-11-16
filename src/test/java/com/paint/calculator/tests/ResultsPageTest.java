package com.paint.calculator.tests;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paint.calculator.HomePage;
import com.paint.calculator.ResultsPage;

public class ResultsPageTest extends BaseTest {
	
	
	@Test
    public void validateResultsPageHeaders() {
 
     
        HomePage homePage = new HomePage(driver);
        String noOfRooms = "1";
        String[] room1 = {"20","20","20"};
     
        ResultsPage resultpage = homePage.launchPaintCalculator()
                .goToDimensionsPage(noOfRooms).paintSingleRoom(room1);
        
        resultpage.validateRowHeaders();
        
              
    }
	
	@Test
    public void validateAmountOfFeetForSingleRoom() {
 
     
        HomePage homePage = new HomePage(driver);
        String noOfRooms = "1";
        String[] room1 = {"20","20","20"};
        String expectedAmountOfFeet = "8000"; 
     
        ResultsPage resultpage = homePage.launchPaintCalculator()
                .goToDimensionsPage(noOfRooms).paintSingleRoom(room1);
        
        Assert.assertEquals(resultpage.getAmountOfFeetForSingleRoom(),expectedAmountOfFeet);
        
        
              
    }
	
	
	@Test
    public void validateGallonsRequiredForSingleRoom() {
 
     
        HomePage homePage = new HomePage(driver);
        String noOfRooms = "1";
        String[] room1 = {"20","20","20"};
        String expectedGallonsRequired = "22"; 
     
        ResultsPage resultpage = homePage.launchPaintCalculator()
                .goToDimensionsPage(noOfRooms).paintSingleRoom(room1);
        
        Assert.assertEquals(resultpage.getAmountOfGallonRequiredForSingleRoom(),expectedGallonsRequired);
        
        
              
    }
	
	@Test
	public void validateAmountOfFeetForMultiRoom() {

		HomePage homePage = new HomePage(driver);
		String noOfRooms = "2";
		String[] room1 = { "10", "20", "30" };
		String[] room2 = { "12", "24", "36" };
		String expectedSizeForRoom1 = "6000";
		String expectedSizeForRoom2 = "10368";

		ArrayList<String[]> roomsList = new ArrayList<String[]>();
		roomsList.add(room1);
		roomsList.add(room2);

		ResultsPage resultpage = homePage.launchPaintCalculator().goToDimensionsPage(noOfRooms)
				.paintMultiRoom(noOfRooms, roomsList);

		Map<Integer, String> roomSizes = resultpage.getAmountOfFeetForMultiRoom();

		Assert.assertEquals(roomSizes.get(1), expectedSizeForRoom1);
		Assert.assertEquals(roomSizes.get(2), expectedSizeForRoom2);

	}
	
	@Test
	public void validateGallonsRequiredForMultiRoom() {

		HomePage homePage = new HomePage(driver);
		String noOfRooms = "2";
		String[] room1 = { "10", "20", "30" };
		String[] room2 = { "12", "24", "36" };
		String expectedGallonsForRoom1 = "17";
		String expectedGallonsForRoom2 = "29";

		ArrayList<String[]> roomsList = new ArrayList<String[]>();
		roomsList.add(room1);
		roomsList.add(room2);

		ResultsPage resultpage = homePage.launchPaintCalculator().goToDimensionsPage(noOfRooms)
				.paintMultiRoom(noOfRooms, roomsList);

		Map<Integer, String> roomSizes = resultpage.getRequiredGallonsMultiRoom();

		Assert.assertEquals(roomSizes.get(1), expectedGallonsForRoom1);
		Assert.assertEquals(roomSizes.get(2), expectedGallonsForRoom2);

	}
	
	

}
