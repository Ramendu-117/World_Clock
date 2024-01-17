package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObject.BasePage;

public class takeScreenShot extends BasePage 
{


	public takeScreenShot(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void takeScreenshot(String name) throws Exception
	{
		String nameOfSS = name;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + nameOfSS);
		FileUtils.copyFile(file, target);	
	}
}