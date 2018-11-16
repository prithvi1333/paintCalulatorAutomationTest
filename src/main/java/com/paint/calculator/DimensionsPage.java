package com.paint.calculator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DimensionsPage extends BasePage {

	 
 
    public DimensionsPage(WebDriver driver) {
        super(driver);
    }

    By submitButtonBy = By.xpath("/html/body/div/form/input");
    
 
 
    public DimensionsPage validateNumberOfRows(String noOfRooms)
    {
    	 WebElement table = driver.findElement(By.className("table")); 
 	    List<WebElement> allRows = table.findElements(By.tagName("tr")); 
       Assert.assertEquals(allRows.size()-1,Integer.parseInt(noOfRooms));
       return this;
    }
    
    public DimensionsPage validateRowHeaders()
    {
    	 WebElement table = driver.findElement(By.className("table")); 
  	    List<WebElement> allRows = table.findElements(By.tagName("tr"));
  	    List<WebElement> firstRowCells = allRows.get(0).findElements(By.tagName("th")); 		
  	    Assert.assertEquals(firstRowCells.get(0).getText(),"Room Number");
  	    Assert.assertEquals(firstRowCells.get(1).getText(),"Length");
  	    Assert.assertEquals(firstRowCells.get(2).getText(),"Width");
  	    Assert.assertEquals(firstRowCells.get(3).getText(),"Height");
        return this;
    }
    
    public ResultsPage paintSingleRoom(String[] roomDimensions)
    {
    	    
	    		  writeText(By.xpath("/html/body/div/form/table/tbody/tr[2]/td[2]/input"), roomDimensions[0]);
	    		  writeText(By.xpath("/html/body/div/form/table/tbody/tr[2]/td[3]/input"), roomDimensions[1]);
	    		  writeText(By.xpath("/html/body/div/form/table/tbody/tr[2]/td[4]/input"), roomDimensions[2]);

       click(submitButtonBy);
       return  new ResultsPage(driver);
    }
    
    public ResultsPage paintMultiRoom(String noOfRooms,List<String[]> roomDimensions)
    {
    	
    	 WebElement table = driver.findElement(By.className("table")); 
 	    List<WebElement> allRows = table.findElements(By.tagName("tr")); 
       Assert.assertEquals(allRows.size()-1,Integer.parseInt(noOfRooms));
       for(int i=1; i<allRows.size();i++)
	    {
	    	
    	    String lenghtXpath = String.format("/html/body/div/form/table/tbody/tr[%s]/td[2]/input", i+1);
    	    String widthXpath = String.format("/html/body/div/form/table/tbody/tr[%s]/td[3]/input", i+1);
    	    String heightXpath = String.format("/html/body/div/form/table/tbody/tr[%s]/td[4]/input", i+1);
    	    
	    		  writeText(By.xpath(lenghtXpath), roomDimensions.get(i-1)[0]);
	    		  writeText(By.xpath(widthXpath), roomDimensions.get(i-1)[1]);
	    		  writeText(By.xpath(heightXpath), roomDimensions.get(i-1)[2]);
 	  
	    }
       click(submitButtonBy);
       return  new ResultsPage(driver);
    }
 


}
