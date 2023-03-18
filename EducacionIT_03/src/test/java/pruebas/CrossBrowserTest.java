package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
	WebDriver driver;
	String url="http://automationpractice.pl/index.php";
	String driverPath="..\\EducacionIT_03\\Drivers\\chromedriver.exe";
	String driverPathF="..\\EducacionIT_03\\Drivers\\geckodriver.exe";

	@BeforeMethod
    @Parameters("navegador")
	public void setUp(String navegador) {	
		if (navegador.equalsIgnoreCase("chrome")) {		
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver(options);	
			
		}
		else {
			
			System.setProperty("webdriver.gecko.driver", driverPathF);
	    	driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	
	 }
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("Blouse");
	    txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void cierraNavegador() {
		
		driver.quit();
	}
}

