package com.paint.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ResultsPage extends BasePage {
	
	 public ResultsPage(WebDriver driver) {
	        super(driver);
	    }
	 
	 By homeButton = By.xpath("/html/body/div/form/input[2]");
	 By result = By.xpath("/html/body/div/h5");
	 
	 public String getResultString()
	 {
		 return readText(result);
	 }
	 
	 public ResultsPage validateRowHeaders()
	    {
	    	 WebElement table = driver.findElement(By.className("table")); 
	  	    List<WebElement> allRows = table.findElements(By.tagName("tr"));
	  	    List<WebElement> firstRowCells = allRows.get(0).findElements(By.tagName("th")); 		
	  	    Assert.assertEquals(firstRowCells.get(0).getText(),"Room #");
	  	    Assert.assertEquals(firstRowCells.get(1).getText(),"Amount of Feet to Paint");
	  	    Assert.assertEquals(firstRowCells.get(2).getText(),"Gallons Required");
	        return this;
	    }
	 
	  	public String getAmountOfFeetForSingleRoom()
	    {
	    	    
		  return readText(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]"));
	    }
	  	
		public String getAmountOfGallonRequiredForSingleRoom()
	    {
	    	    
		  return readText(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]"));
		  
	    }
		
		
		public Map<Integer, String> getAmountOfFeetForMultiRoom()
	    {
	    	
	    	 WebElement table = driver.findElement(By.className("table")); 
	 	    List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	       Map<Integer, String> roomSize = new HashMap<Integer, String>();
	       for(int i=1; i<allRows.size();i++)
		    {
		    	
	    	    String amountOfFeet =  readText(By.xpath(String.format("/html/body/div/table/tbody/tr[%s]/td[2]", i+1)));
	    	    roomSize.put(i, amountOfFeet);
	    	
		    }
	       
	       return  roomSize;
	    }
		
		
		public Map<Integer, String> getRequiredGallonsMultiRoom()
	    {
	    	
	    	 WebElement table = driver.findElement(By.className("table")); 
	 	    List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	       Map<Integer, String> gallonsPerRoom = new HashMap<Integer, String>();
	       for(int i=1; i<allRows.size();i++)
		    {
		    	
	    	    String gallonsReqForRoom =  readText(By.xpath(String.format("/html/body/div/table/tbody/tr[%s]/td[3]", i+1)));
	    	    
	    	    gallonsPerRoom.put(i, gallonsReqForRoom);
	    	
		    }
	       
	       return  gallonsPerRoom;
	    }
}
