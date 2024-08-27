import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;


public class OpenBrowsersTest {

	@Test
	public void openMozilla() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","E:\\DEVOPS\\SIGECAP\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		if (driver.getTitle().contains("Google")) {
            System.out.println("Título de la página es correcto.(Firefox)");
        } else {
            System.out.println("Título de la página es incorrecto.(Firefox)");
        }
		
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("devops");
		e.sendKeys(Keys.ENTER);
		
        if (driver.getPageSource().contains("devops")) {
            System.out.println("Resultados de búsqueda están presentes.(Firefox)");
        } else {
            System.out.println("Resultados de búsqueda no están presentes.(Firefox)");
        }		
		
		Thread.sleep(10000);
		driver.quit();
	}
	
	
	  @Test public void openChrome() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver","E:\\DEVOPS\\SIGECAP\\drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver(); 
	  driver.get("https://www.google.com");
	  
		if (driver.getTitle().contains("Google")) {
            System.out.println("Título de la página es correcto. (Chrome)");
        } else {
            System.out.println("Título de la página es incorrecto.(Chrome)");
        }
		
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("Selenium");
		e.sendKeys(Keys.ENTER);
		
        if (driver.getPageSource().contains("Selenium")) {
            System.out.println("Resultados de búsqueda están presentes.(Chrome)");
        } else {
            System.out.println("Resultados de búsqueda no están presentes.(Chrome)");
        }
	  
	  Thread.sleep(10000);
	  driver.quit();
	  }
	 
}
