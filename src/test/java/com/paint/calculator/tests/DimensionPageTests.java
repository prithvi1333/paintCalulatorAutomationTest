package com.paint.calculator.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.paint.calculator.HomePage;
import com.paint.calculator.ResultsPage;

public class DimensionPageTests extends BaseTest {
	
    @Test
    public void validateNoOfGallonsForSingleRoom() {
 
     
        HomePage homePage = new HomePage(driver);
        String noOfRooms = "1";
        String[] room1 = {"10","20","30"};
        int expectedNoOfGallons = 17;
 
     
        ResultsPage resultpage = homePage.launchPaintCalculator()
                .goToDimensionsPage(noOfRooms).paintSingleRoom(room1);
        
        int actualNoOfGallons = Integer.parseInt(resultpage.getResultString().replaceAll("[^0-9]", ""));
        
        assertEquals(actualNoOfGallons, expectedNoOfGallons);
              
    }
    
    
    @Test
    public void validateNoOfGallonsForMultiRoom() {
 
        HomePage homePage = new HomePage(driver);
        String noOfRooms = "2";
        String[] room1 = {"10","20","30"};
        String[] room2 = {"12","24","36"};
        int expectedNoOfGallons = 46;
        
        
        ArrayList<String[]> roomsList = new ArrayList<String[]>();
        roomsList.add(room1);
        roomsList.add(room2);
 
      ResultsPage resultpage =    homePage.launchPaintCalculator()
                .goToDimensionsPage(noOfRooms).paintMultiRoom(noOfRooms,roomsList);
   
      int actualNoOfGallons = Integer.parseInt(resultpage.getResultString().replaceAll("[^0-9]", ""));
      
      assertEquals(actualNoOfGallons, expectedNoOfGallons);
              
    }
    
    @Test
	public void validateDimensionsPageHeader() {

		HomePage homePage = new HomePage(driver);
		String noOfRooms = "1";

		homePage.launchPaintCalculator().goToDimensionsPage(noOfRooms).validateRowHeaders();

	}

}
