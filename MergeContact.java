package week4.day2.learnalert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {
	public static void main(String[] args) {
	
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		
	ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact 
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		
		String pwindowHandle=driver.getWindowHandle();
		
		Set<String> currentWindow = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<>(currentWindow);
		driver.switchTo().window(newWindow.get(1));
		String title=driver.getTitle();
		System.out.println(title);
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(pwindowHandle);
		
		//click on widget of to contact
		//Thread.sleep(5000);
		  driver.findElement(By.xpath("(//tr//img)[2]")).click();
		//   Thread.sleep(5000);
		  Set<String> windowhandles2 = driver.getWindowHandles();
		  List<String> handles2 = new ArrayList<>(windowhandles2);
		  driver.switchTo().window(handles2.get(1));
		  driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x')]//a")).click();
		  
		  //switch back to parent window again
		  driver.switchTo().window(pwindowHandle);
		  driver.findElement(By.xpath("//a[text()='Merge']")).click();
		  
		  //Switching to Alert
		  
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  
		  //verify title of page
		  
		  String title1 = driver.getTitle();
		  System.out.println("Title of the current page is "+ title1);
		  
		  String text = driver.findElement(By.xpath("//li[contains(text(),'Cannot merge')]")).getText();
		  
		  if(text.contains("Cannot merge"))
		  {
			  System.out.println("The elements is Present");
		  }
		

	}
}


