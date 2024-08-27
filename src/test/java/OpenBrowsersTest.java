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
		WebElement e = driver.findElement(By.name("q"));
		e.sendKeys("devops");
		e.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.quit();
	}
	
	
	  @Test public void openChrome() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver",
	  "E:\\DEVOPS\\SIGECAP\\drivers\\chromedriver.exe"); WebDriver driver = new
	  ChromeDriver(); driver.get("https://www.google.com"); Thread.sleep(10000);
	  driver.quit(); }
	 
}
