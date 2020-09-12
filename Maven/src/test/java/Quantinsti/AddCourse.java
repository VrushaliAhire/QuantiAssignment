package Quantinsti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCourse extends Login{
	
	@Test (priority=3)
	public void NavigatetoCourse()
	{
		String url = "https://quantra.quantinsti.com/dashboard";
		String CurrentURL = driver.getCurrentUrl();
		try
		{
		if(CurrentURL.equals(url)) 
		{
			
			String Text = driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[9]/a/span")).getText();
			int n = Integer.parseInt(Text);
			System.out.println("cart count is:"+ n);
			if(n>0)
			{
			driver.findElement((By.xpath("//*[@id='right-navigation']/ul/div[1]/li[9]/a"))).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cart-item']")));
			List<WebElement> element =  driver.findElements(By.xpath("//div[@class='cart-item']"));
			int count = element.size();
			System.out.println("courses in cart:" + count);
			for(int i=0; i<=count; i++)
			{
				
				if(driver.findElement(By.xpath("//div[@class='cart-item']/div/div/div[2]/div/a[2]")).isDisplayed())
				driver.findElement(By.xpath("//div[@class='cart-item']/div/div/div[2]/div/a[2]")).click();
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
			
		}
		}
		catch(NoSuchElementException e)
		{
			
		}
		
		try
		{
			Actions mousehover = new Actions(driver);
			 WebElement element = driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[3]/span/a"));
			 mousehover.moveToElement(element).build().perform();
			 WebDriverWait wait = new WebDriverWait(driver,10);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='subnav']/div[2]/ul/li[7]/a")));
		}
		
		catch(NoSuchElementException e)
		{
			
		}
		try
		{
			Actions mousehover = new Actions(driver);
			 WebElement element = driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[5]/span/a"));
			 mousehover.moveToElement(element).build().perform();
			 WebDriverWait wait = new WebDriverWait(driver,10);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='subnav']/div[2]/ul/li[7]/a")));
		}
		
		catch(NoSuchElementException e)
		{
			
		}
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='subnav']/div[2]/ul/li[7]/a")));
		driver.findElement(By.xpath("//div[@class='subnav']/div[2]/ul/li[7]/a")).click();
		
	   
	}
	@Test (priority=4)
	public void verifyNameAndPrice()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='course-detail__buttons']/button")));
		
		String ExpectedName = "Learning Track: Sentiment Analysis in Trading";
	     String ActualName =  driver.findElement(By.xpath("//div[@class='course-detail__left-view']/h1")).getText();
	     Assert.assertEquals(ActualName, ExpectedName);
	     
	     String ExpectedPrice = "35192";
	     String numonly3 =ExpectedPrice.replaceAll("[^0-9]", "");
		 int Eprice = Integer.parseInt(numonly3);
		 System.out.println("Expectedprice"+Eprice);
		
		 
	     String ActualPrice = driver.findElement(By.xpath("//div[@class='cd__data-unit__info']/span[2]/span")).getText();
	     String numonly4 =ActualPrice.replaceAll("[^0-9]", "");
		 int Aprice = Integer.parseInt(numonly4);
		 System.out.println("Actualprice"+Aprice);
		 
		 
	     Assert.assertEquals(Aprice, Eprice);
	     
	}
	@Test (priority=5)
	public void enrollAndVerifyCount()
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='course-detail__buttons']/button")));
		driver.findElement(By.xpath("//div[@class='course-detail__buttons']/button")).click();
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[5]/a")));
		String Text = driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[5]/a/span")).getText();
		int n = Integer.parseInt(Text);
		System.out.println(n);
		int count = driver.findElements(By.xpath("//div[@class = 'cart-item']")).size();
		System.out.println(count);
		Assert.assertEquals(count, n);
		
		
	}
	
	@Test (priority=6)
	public void Amount()
	{
		int ExpBAmount = 35192;
		String BaseAmount = driver.findElement(By.xpath("//div[@class = 'cart-summary-item']/div[2]")).getText();
		String numonly1 =BaseAmount.replaceAll("[^0-9]", "");
		int bAmount = Integer.parseInt(numonly1);
		System.out.println("BaseAmount"+bAmount);
		//Assert.assertEquals(bAmount, ExpBAmount);
		
		int ExpPAmount = 37378;
		String PayableAmount = driver.findElement(By.xpath("//div[@class = 'cart-summary-item amt-payable-wrap']/div[2]/h5/span")).getText();
		String numonly2 =BaseAmount.replaceAll("[^0-9]", "");
		int pAmount = Integer.parseInt(numonly2);
		System.out.println("PayAmount"+pAmount);
		//Assert.assertEquals(pAmount, ExpPAmount);

	}
	
	@Test (priority=7)
	public void veiwDetails()
	{
		
		driver.findElement(By.xpath("//div[@class='cart-item']/div/div/div[2]/div/a[1]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
			    
		
	}
	
	@Test (priority=8)
	public void RemoveCourseAndApplyCoupon()
	{
		driver.findElement(By.xpath("//div[@class='cart-item']/div/div/div[2]/div/a[2]")).click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try
		{
		if(driver.findElement(By.xpath("//div[@class='toasted-container top-center']/div")).isDisplayed())
		{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errormsg = driver.findElement(By.xpath("//div[@class='toasted-container top-center']/div")).getText();
			System.out.println(errormsg);
		}
		}
		catch(NoSuchElementException e)
		{
			
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='coupon-btn-unit']/button")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@class='modal-content']")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@class='coupon-form__unit']/input")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='coupon-form__unit']/input")).sendKeys("ABC");
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 try
		 {
			 if(driver.findElement(By.xpath("//div[@class='coupon-alert-box']/div/span")).isDisplayed())
			 {
				String coupnmsg = driver.findElement(By.xpath("//div[@class='coupon-alert-box']/div/span")).getText();
				System.out.println(coupnmsg);
			 }
		 }
		 catch(NoSuchElementException e)
		 {
			 
		 }
		driver.findElement(By.xpath("//div[@class='coupon-form__button']/button")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//div[@class='modal-body']/button")).click();
		
		
	}
	@Test (priority=9)
	public void signout()
	{
		driver.findElement(By.xpath(" //div[@class='profile-pic-initials']")).click();
		driver.findElement(By.xpath("//ul[@class='avatar-menu']/li[5]/a")).click();
	}
}
