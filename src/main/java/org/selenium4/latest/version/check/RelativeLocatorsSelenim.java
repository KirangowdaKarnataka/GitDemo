package org.selenium4.latest.version.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;



public class RelativeLocatorsSelenim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. above();
		// 2. below();
		// 3. toLeft();
		// 4. toRight();
		// Synetx:- driver.findElement(By.tagName("").above(WebElement))
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// How to get the label on particular field
		// by using the input box we are identifying the relative locator 'label'
		// sysout then enter ctrl+spacebar
		WebElement element =  driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(element)).getText());
        
        // Below example
        WebElement element1 = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        // becaue of flex ther is no output (it will not support flex elements so, it will go to next non-flex element), 
        //it will goto next immediate input tag i.e submit button
        driver.findElement(with(By.tagName("input")).below(element1)).click();
        
        //toLeft() - select the checkbox which is left to text
        WebElement checkboxLeftText = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLeftText)).click();
        
        WebElement element7 =  driver.findElement(By.cssSelector("[id='inlineRadio1']"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(element7)).getText());
        
		
		

	}

}
