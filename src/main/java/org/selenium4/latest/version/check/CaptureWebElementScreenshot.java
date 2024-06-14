package org.selenium4.latest.version.check;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureWebElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Get the partial screenshot of particular webelement
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// switch to new tab
	    // driver.switchTo().newWindow(WindowType.TAB);
	     // Switch to new window
	     driver.switchTo().newWindow(WindowType.WINDOW);
		// blank tab is ready(selenium opened new blank tab doesn't mean that control is shifted to new blank tab)
		// driver still doesn't have knowledge on new blank tab, driver only knows home tab only
	     
	     // First extract the parent window and child window using below command 
	     Set<String> handle = driver.getWindowHandles();
	     // to iterate parent to child 
	     Iterator<String> it = handle.iterator();
	     String parentWindowID = it.next(); // when we call this iterator will move to first index(index 0)
	     // index 0 : Parent window ID
	     // index 1 : child window id 
	     String childWindowID =  it.next(); 
	     
	     // after getting child window ID we need to pass that ID to  below command
	     driver.switchTo().window(childWindowID); // now selenium shift it's focus to child window
	     driver.get("https://rahulshettyacademy.com/"); // when type this command , url will be opened in child window
	     
		// get the first course in feature course 
	  // findElements because we are getting 24 links out of this regular expression
	     // we are going for index 1 not 0 because title is getting hightlighted on index 1
	     // next get the course text
	     String coursename = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText(); 
	     driver.switchTo().window(parentWindowID); // scope will shift back to parent window
	     // next step :- 
	      WebElement name = driver.findElement(By.cssSelector("[name='name']"));
	      name.sendKeys(coursename);
	      
	      // Task :-  get the screenshot of particular webeleemnt(in our case name of course we copied)
	      // Name web element screenshot 
	      File file = name.getScreenshotAs(OutputType.FILE); 
	      // above file is a object
	      // we need a physical file
	       FileUtils.copyFile(file, new File("logo.png"));
	       
	       
	       //get the height and width of particular web element
	       System.out.println(name.getRect().getDimension().getHeight());
	       // width 
	       System.out.println(name.getRect().getDimension().getWidth());
	       // using asseretiins we can compare it with real values.
	       
	     
	  
	      
	     
	 
	     

	}

}
