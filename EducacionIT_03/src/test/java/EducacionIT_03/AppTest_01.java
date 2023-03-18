package EducacionIT_03;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.*;

public class AppTest_01 {
  
  protected WebDriver driver;
  @Test
  public void tutorialselenium() throws InterruptedException 
  {
	  
	  //Algo nuevo agregado
	//Buscar el web Driver
	  System.setProperty ("webdriver.chrome.driver","..\\EducacionIT_03\\Drivers\\chromedriver.exe");
	  
	
	  ChromeOptions options=new ChromeOptions();
	  
	 options.addArguments("remote-allow-origins=*");
	 
	//Crear una instancia del web driver
	 driver= new ChromeDriver(options);	
	 
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  String Titulo = "Google";
	  
	  String aTitulo = "" ;
	  
	  // Lanzar Chrome y redirecciona a la base URL
	  driver.get("http://www.google.com" );
	  
	  //Maximizar la ventana del navegador
	  driver.manage().window().maximize() ;
	  
	  //Obtiene el valor actual del titulo
	  aTitulo = driver.getTitle();
	  
	  //Compara el titulo actual con el titulo esperado
	  if (aTitulo.equals(Titulo)){
	  System.out.println( "La prueba ha pasado") ;
	  }
	  else{
	  System.out.println( "La prueba ha fallado" );
	  }
	  
	  //Cerrar el navegador
	  driver.close();
  }
}
