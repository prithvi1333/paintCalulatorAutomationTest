package com.paint.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class HomePage extends BasePage {
 
    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }
 
    //*********Page Variables*********
    String baseURL = "http://127.0.0.1:5000/";
 
    //*********Web Elements*********
    By submitButton = By.xpath("/html/body/div/form/input[2]");
    By textBox =  By.xpath("/html/body/div/form/input[1]");
    By title =  By.xpath("/html/body/div/h1");
 
 
    //*********Page Methods*********
    //Go to Homepage
    
    public HomePage launchPaintCalculator(){
        driver.get(baseURL);
        return this;
    }
    
    public DimensionsPage goToDimensionsPage(String noOfRooms)
    {
      
        writeText(textBox, noOfRooms);
        click(submitButton);
        return  new DimensionsPage(driver);
    }
    
    public String getHomePageTitle()
    {
      
        return readText(title);
       
    }
 
    
}
