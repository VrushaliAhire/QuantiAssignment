package QuantiAssignment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		Actions mousehover = new Actions(driver);
		 WebElement element = driver.findElement(By.xpath("//*[@id='right-navigation']/ul/div[1]/li[5]/span/a"));
		 mousehover.moveToElement(element).build().perform();
		 driver.findElement(By.linkText("Browse Courses")).click();
	     driver.findElement(By.partialLinkText("Sentiment Analysis ")).click();
		
	   
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
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div[2]/div/div[2]/div[2]/button")));
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath("//div[@class='coupon-btn-unit']/button")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@class='modal-body']")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@class='coupon-form__unit']")).click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='coupon-form__unit']")).sendKeys("ABC");
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='coupon-form__button']")).click();
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
