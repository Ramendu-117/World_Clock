package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleSearch extends BasePage {
	
	
	public googleSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locators
	@FindBy(xpath = "//textarea[@type='search']") WebElement searchBar;
	@FindBy(xpath = "//input[@value ='Google Search']") WebElement searchButton;
	@FindBy(xpath = "//div[@class='odXoZb']//child::b") WebElement londonTime;
	@FindBy(xpath = "//div[@class ='odXoZb']//child::b") WebElement newYorkTime;
	@FindBy(xpath = "//div[@class='DcFqyf']//child::span[1]") WebElement londonDay;
	@FindBy(xpath = "//div[@class='odXoZb']//child::span[1]") WebElement newYorkDay;
	@FindBy(xpath = "//div[@class='Mv3Zsd vk_bk dDoNo']") WebElement timeGap;
	
	
	
	
	//Actions 
	public void enterInput(String searchText)
	{
		String text = searchText;
		searchBar.sendKeys(text);
	}
	
	public void search()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",searchButton );
	}
	
	public String getLondonTime()
	{
		String time1 = londonTime.getText();
		return time1;
	}
	
	public String getNewYorkTime()
	{
		String time2 = newYorkTime.getText();
		return time2;
	}
	
	public String  getNewYorkDay()
	{
		String day = newYorkDay.getText();
		return day;
	}
	public String  getLondonDay()
	{
		String day = londonDay.getText();
		return day;
	}

	public String getTimeDifference()
	{
		String timeDifference = timeGap.getText();
		return timeDifference;
	}
	

}
