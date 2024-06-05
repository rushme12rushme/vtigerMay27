package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonPricexpath {
	
	public static void main(String []args) {
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Vivo");
	driver.findElement(By.id("nav-search-submit-button")).click();
	String ele = driver.findElement(By.xpath("//span[contains(text(),'Vivo')]//ancestor::div[@data-cy='title-recipe']/following-sibling::div//span[@class='a-price-whole']")).getText();
	
	System.out.println(ele);
	}
}
