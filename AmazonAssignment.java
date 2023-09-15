package week4.day2.learnalert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String price= driver.findElement(By.xpath("//span[text()='61,999']")).getText();
		String replace1 = price.replace(",", "");
		System.out.println(replace1+"00");
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]")).click();
		String rating= driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']")).getText();
		System.out.println(rating);
		driver.findElement(By.xpath("//span[contains(text(),'OnePlus 11 5G')]")).click();
		Set<String> currentWindow = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<>(currentWindow);
		driver.switchTo().window(newWindow.get(1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String cartTotal= driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']")).getText();
		String replace2 = cartTotal.replaceAll("[^0-9]", "").replaceAll(",","");
		System.out.println(replace2);
	

		if (price.equals(cartTotal)) {
			
			System.out.println("amount verified successfully");
		}
			
		else
		{
			System.err.println("Amount not matched");	
		}
				
			}
			
		
		

}
