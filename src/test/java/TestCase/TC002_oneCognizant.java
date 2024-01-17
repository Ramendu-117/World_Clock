package TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.oneCognizant;
import Utilities.takeScreenShot;

@Listeners(Utilities.ExtentReport.class)
public class TC002_oneCognizant extends TC001_beCognizant{
	
	@Test(priority = 6)
	public void test6() throws Exception
	{
		oneCognizant oc = new oneCognizant(driver);
		oc.switchToChildWindow();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//oneCognizant.png");
	}
	
	@Test(priority = 7)
	public void test7() throws Exception
	{
		oneCognizant onCog = new oneCognizant(driver);
		onCog.clickGetApps();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='col quickActionsHeader']")).isDisplayed(), true);
	}
	
	@Test(priority = 8)
	public void test8() throws Exception
	{
		oneCognizant onCog = new oneCognizant(driver);
		onCog.isVisible();
	}
	
	@Test (priority = 9)
	public void test9() throws Exception
	{
		
		oneCognizant onCog = new oneCognizant(driver);
		onCog.isDisabled();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//viewAllApps.png");
		
	
	}
	
	@Test(priority = 10)
	public void test10() throws Exception
	{
		oneCognizant onCog = new oneCognizant(driver);
		onCog.selectAlphabet();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//viewSelectedApps1.png");

	}

	
	
}
