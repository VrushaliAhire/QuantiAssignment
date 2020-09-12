package Quantinsti;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver = null;
	String path = System.getProperty("user.dir");	
	
	@Test (priority = 1)
	@Parameters("browser")
	public void openbrowser(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\Driver\\newchromedriver.exe");
	   	driver = new ChromeDriver();
	   	driver.manage().window().maximize();
	   	
		}
		else
			if(browser.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		
			else
				if(browser.equalsIgnoreCase("internetexplorer"))
				{
					System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\Driver\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
				
				
	}
	
	@Test(priority=2)
	@Parameters({"URL", "Username" , "Password"})
	public void Login(String URL, String Username, String Password)
	{
		driver.get(URL);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("right-navigation")));
		driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[4]/button/span/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		driver.findElement(By.name("email")).sendKeys(Username);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div/form/div[2]/div[3]/div[3]/div/button")));
		driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/form/div[2]/div[3]/div[3]/div/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[5]/span/a")));
		try
		{
		if(driver.findElement(By.xpath("//div[@class='web-push-container']")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='web-push-action-btns']/div[1]")).click();
		}
		}
		catch(NoSuchElementException e)
		{
			
		}
				
	}
	
		
	}
	
