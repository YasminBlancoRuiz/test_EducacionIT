package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Laboratorio6_E2Test {
	
	WebDriver driver;

	
	String driverPath="..\\EducacionIT_03\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php";
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",driverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		//lo usamos en un servidor - un modo los corre rapidisimo
		options.addArguments("headless");
		driver= new ChromeDriver(options);
		driver.get(url);
	
	}
	

	@Test
	public void NavegadorHeadless() throws IOException {
		WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt_Test\\Evidencias\\pantalla.png"));
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}

}
