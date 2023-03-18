package EducacionIT_03;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Laboratorio2 {
	
	@Test
	public void lab2_E1() {
		
		String url="http://automationpractice.pl/index.php?controller=authentication&back=my-account";
		
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIT_03\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		
		WebDriver driver= new ChromeDriver(options);	
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		WebElement txtEmail=driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo"+Math.random()+"@correo.com");
		
		WebElement btnCreate=driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.name("customer_firstname")).sendKeys("Juan Carlos");
		driver.findElement(By.name("passwd")).sendKeys("12345");
		
		Select months=new Select(driver.findElement(By.name("months")));
		
	     months.selectByValue("4");
		
		
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		
	
		 
	
		 Assert.assertEquals("http://automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());

		
		  driver.close();
		
	}

}
