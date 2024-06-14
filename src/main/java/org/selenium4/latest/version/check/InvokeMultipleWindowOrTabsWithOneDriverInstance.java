package org.selenium4.latest.version.check;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindowOrTabsWithOneDriverInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	     driver.findElement(By.cssSelector("[name='name']")).sendKeys(coursename);
	     //driver.quit();
	     

	}

}
