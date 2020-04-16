package Default;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Firefox {
	
	static String driverChrome = "/home/suresh.gupta/Desktop/vishakha/AUTOMATION/chromedriver";
	static String drivergecko="/home/suresh.gupta/Desktop/vishakha/AUTOMATION/geckodriver";
    public String Loginurl = "https://services-sso.empirix.com/";
    public WebDriver driver;
    
     
    @Test
    public void session2() 
    {
    	System.setProperty("webdriver.gecko.driver", drivergecko);
    	driver=new FirefoxDriver();
        driver.get(Loginurl); 
        driver.manage().window().maximize();  
		driver.manage().deleteAllCookies();

    }
    @Test(testName="login",priority=1,enabled=true) //Login
    public void Login() throws InterruptedException
  {
  	WebDriverWait wait = new WebDriverWait(driver, 100);
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("callback_0")));
      driver.findElement(By.name("callback_0")).sendKeys("QA_traininguser25");
      driver.findElement(By.name("callback_1")).sendKeys("Empirix!");
      driver.findElement(By.name("callback_2")).click();
      System.out.println("Logged In");
      
  }
    
    @Test(testName="LangChange",priority=2,enabled=true)// Switch Language
    public void LangChange() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,100);
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.dropdown-toggle.ng-binding")));
      	driver.findElement(By.cssSelector("a.dropdown-toggle.ng-binding")).click();
      	Thread.sleep(3000);
    	WebElement Jap=driver.findElement(By.cssSelector("#wrapper > header > section.navbar.navbar-inverse.docs-navbar-primary.ng-scope > div > div > div > ul > li.dropdown.open > ul > div > div > a"));
    	WebElement Eng=driver.findElement(By.cssSelector("#wrapper > header > section.navbar.navbar-inverse.docs-navbar-primary.ng-scope > div > div > div > ul > li.dropdown.open > ul > div > div > div"));
    	if(Jap.isEnabled()){
    		Jap.click();
    		System.out.println("Running in Japnese");
    	}
    	else{
    		Eng.click();
    		System.out.println("Running in English");
    	}
    		Alert alert = driver.switchTo().alert();
        	alert.accept();
        	Thread.sleep(10000);
    	
    }
    
    	@Test(testName="Tabs", priority=3, enabled=true)
    	public void Tabs() 
    	{
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	    driver.findElement(By.cssSelector("#wrapper > header > section.sup-header > div > ul > li:nth-child(1) > a")).click();
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/section[2]/div/ul/li[4]/a")).click();
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/section[2]/div/ul/li[5]/a")).click();
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/section[2]/div/ul/li[6]/a")).click();
        	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/section[2]/div/ul/li[7]/a")).click();
    	}
    	
    	@Test(testName="Verify", priority=4, enabled=true)
    	public void VerifyText() throws InterruptedException {

    		driver.findElement(By.cssSelector("a.dropdown-toggle.ng-binding")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.cssSelector("#wrapper > header > section.navbar.navbar-inverse.docs-navbar-primary.ng-scope > div > div > div > ul > li.dropdown.open > ul > li:nth-child(1) > a")).click();
    		assertTrue(driver.getPageSource().contains("user25"));
    		System.out.println("user25 found in page source");
    		
    	}
    

}
