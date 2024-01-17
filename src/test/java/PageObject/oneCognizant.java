package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class oneCognizant extends BasePage {
	
	public oneCognizant(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 
	
	List<WebElement> enabledAlphabets = new ArrayList<WebElement>();
	
	int alphabets=0;
	Boolean pass = true;
	
	
	//locators
	@FindBy(xpath = "//div[@class = 'viewAllHotAppsBtn']") WebElement viewApps;
	@FindBy(xpath = "//div[@class='aZHolder']//child::div") List<WebElement> atoZ;
	@FindBy(xpath = "//div[@class='oneCExtSocialEleHolder']") WebElement socialBar;
	
	
	//Actions 
	public void clickGetApps() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",viewApps);
		js.executeScript("arguments[0].click();", viewApps);
	}
	
	public void switchToChildWindow()
	{
		Set<String> windowIds= driver.getWindowHandles();
		for(String winId : windowIds)
		{
			String title = driver.switchTo().window(winId).getTitle();
			if(title.equalsIgnoreCase("OneCognizant"))
			{
				driver.switchTo().window(winId);
				break;
			}
		}
		
	}
	
	public void isVisible() throws Exception
	{	String xfile=System.getProperty("user.dir")+"\\TestData\\CascProject.xlsx";

		Thread.sleep(2000);
		
		for(int i =0;i<atoZ.size();i++)
		{
			alphabets++;
			
		}
		
		ExcelUtils.setCellData(xfile, "Sheet1", 1, 16, "alphabets");
		
		System.out.println("Total no of alphabets visible are : "+ alphabets);
	}
	
	public void isDisabled() throws InterruptedException, IOException
	{
		String xfile=System.getProperty("user.dir")+"\\TestData\\CascProject.xlsx";
		for(WebElement ele : atoZ)
		{
			try 
				{
					String btn = ele.getAttribute("role");
					if(btn.equalsIgnoreCase("button"))
					{
						enabledAlphabets.add(ele);
					}
				}
				catch(Exception e)
				{
						System.out.println("Alphabet "+ ele.getText()+" is disabled");
						
						ExcelUtils.setCellData(xfile, "Sheet1", 1, 17, ele.getText());
				}
		
		}
	}
	
	
	public void selectAlphabet() throws Exception
	{
		String xfile=System.getProperty("user.dir")+"\\TestData\\CascProject.xlsx";
		String randomAlphabet = "";
		while(true)
		{
			Random random = new Random();
			char randomChar = (char) ('A' + random.nextInt(26));
			randomAlphabet = String.valueOf(randomChar);
			if(!randomAlphabet.equalsIgnoreCase("X"))
			{
				break;
			}
		}
		for (WebElement element : atoZ)
		{
			
				String actualAlphabet = element.getText();
				
				if(randomAlphabet.equalsIgnoreCase(actualAlphabet))
				{ 
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(2000);
					
					List<WebElement> allApps = driver.findElements(By.xpath("//div[@class='appStoreAppName']"));
					
					for(int i =0;i<allApps.size();i++)
					{
						System.out.println(allApps.get(i).getText());
						int index = i+1;
						ExcelUtils.setCellData(xfile, "Sheet1", index, 18, allApps.get(i).getText());
						Thread.sleep(2000);
						
					}
//					for(WebElement ele : allApps)
//					{
//						i= i+1;
//						System.out.println(ele.getText());
//						ExcelUtils.setCellData(xfile, "Sheet1", i, 18, ele.getText());
//						Thread.sleep(2000);
//						
//					}
				}
			}
		}
	}

