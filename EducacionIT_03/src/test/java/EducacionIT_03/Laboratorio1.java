package EducacionIT_03;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Laboratorio1 {

@Test @Ignore
public void lab1_test() {
	
	System.out.print("Hola Mundo de Automatización!");
	
	
  }

@Test @Ignore
 public void lab1_1() {
	System.setProperty("webdriver.chrome.driver", "..\\EducacionIT_03\\Drivers\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("remote-allow-origins=*");
	WebDriver driver= new ChromeDriver(options);	
	
	driver.get("http://automationpractice.pl/index.php");
	
	driver.close();
	 
 }

@Test
public void lab1_3() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "..\\EducacionIT_03\\Drivers\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("remote-allow-origins=*");
	WebDriver driver= new ChromeDriver(options);	
	
	driver.get("http://automationpractice.pl/index.php");
	
	driver.manage().window().maximize();
	
    Thread.sleep(2000);
    
	WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
	
	txtBuscador.sendKeys("Blouse");
	
	txtBuscador.sendKeys(Keys.ENTER);
	
	driver.close();
	 
}



}
