package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Laboratorio6_E1 {
	
	WebDriver driver;


	String driverPath="..\\EducacionIT_03\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php";
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",driverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		options.addArguments("incognito");
		driver= new ChromeDriver(options);
		driver.get(url);

	}
	

	@Test
	public void verNavegadorIncognito() {
		WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}


}
