package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.beCognizant;
import TestBase.BaseClass;
import Utilities.takeScreenShot;

public class TC001_beCognizant extends BaseClass
{

	@Test(priority =1)
	public void test1() throws Exception
	{
		beCognizant bc = new beCognizant(driver);
		bc.clickProfile();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//Profile.png");
	}
	
	@Test(priority =2)
	public void test2() throws InterruptedException
	{
		beCognizant bc = new beCognizant(driver);
		bc.getName();
		Thread.sleep(2000);
	}
	
	@Test(priority =3)
	public void test3() throws InterruptedException
	{
		beCognizant bc = new beCognizant(driver);
		bc.getEmail();
		Thread.sleep(2000);
	}
	
	@Test(priority =4)
	public void test4() throws InterruptedException
	{
		beCognizant bc = new beCognizant(driver);
		bc.validateOneCog();
		Thread.sleep(2000);
	}
	
	@Test(priority =5)
	public void test5() throws InterruptedException
	{
		beCognizant bc = new beCognizant(driver);
		bc.clickOneCog();
		Thread.sleep(2000);
	}

	@Test(priority = 12)
	public void test12()
	{
		beCognizant oc = new beCognizant(driver);
		oc.switchToParentWindow();
		String title ="Be.Cognizant - Home";
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	
	@Test (priority =13)
	public void test13() throws Exception 
	{
		beCognizant bc = new beCognizant(driver);
		bc.vallidateTitle();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//beCognizantPage.png");

	}
	
	@Test (priority =14)
	public void test14() throws Exception 
	{
		beCognizant bc = new beCognizant(driver);
		bc.goToBottom();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//viewWorldClock.png");

		
	}
	
	@Test(priority =15)
	public void test15() 
	{
		beCognizant bc = new beCognizant(driver);
		bc.validateLocalTime();
	}
	
	@Test(priority = 16)
	public void test16() throws Exception
	{
		beCognizant bc = new beCognizant(driver);
		bc.validateLondonTime();
	}
	@Test (priority =17)
	public void test17() throws Exception 
	{
		beCognizant bc = new beCognizant(driver);
		bc.goToBottom();
		
	}
	
	@Test(priority = 18)
	public void test18() throws Exception
	{
		beCognizant bc = new beCognizant(driver);
		bc.validateNewYorkTime();
	}
}

