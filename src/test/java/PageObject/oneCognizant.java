package PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	{	

		Thread.sleep(2000);
		
		for(int i =0;i<atoZ.size();i++)
		{
			alphabets++;
			
		}
		System.out.println("Total no of alphabets visible are : "+ alphabets);
	}
	
	public void isDisabled() throws InterruptedException
	{
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
				}
		
		}
	}
	
	
	public void selectAlphabet() throws Exception
	{
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
					for(WebElement ele : allApps)
					{
						System.out.println(ele.getText());
						Thread.sleep(2000);
						
					}
				}
			}
		}
	}

