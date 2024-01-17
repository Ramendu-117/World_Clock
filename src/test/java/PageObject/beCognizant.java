package PageObject;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.takeScreenShot;

public class beCognizant extends BasePage {
	
public beCognizant(WebDriver driver) {
		super(driver);
	}

//	WebDriver driver = new ChromeDriver();
	String newActualTime = null;
	String newActualDate = null;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

	//locators
	@FindBy(xpath = "//div[contains(@id, 'MainLink_MePhoto')]") WebElement profile;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']") WebElement name;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_secondary']")WebElement email;
	@FindBy(xpath = "//div[@title='OneCognizant']") WebElement oneCog;
	@FindBy(xpath = "//span[@class='fontSizeMedium']//child::strong") WebElement seeAll;
	@FindBy(xpath = "//div[@data-automation-id='clock-card-location']") List<WebElement> City;
	@FindBy(xpath = "//div[@aria-posinset='1']//span") List<WebElement> localTime;
	@FindBy(xpath = "//div[@aria-posinset='2']//span") List<WebElement> londonTime;
	@FindBy(xpath = "//div[@aria-posinset='3']//span") List<WebElement> newYorkTime;
	@FindBy(xpath = "//div[contains(@title, 'day')  and contains(text(), '2024')]") List<WebElement> dayAndDate;
	@FindBy(xpath = "//div[@data-automation-id='clock-card-time-offset']") List<WebElement> timeDiff;

	
	
	//Actions
	public void vallidateTitle() throws Exception
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Be.Cognizant - Home");

	}
	public void clickProfile() throws Exception
	{
		
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();	
	}
	
	public	void  getName()
	{
		System.out.println(name.getText());
	
	}
	
	public void getEmail()
	{
		System.out.println(email.getText());
	}
	
	public void validateOneCog()
	{
		try
		{
			Boolean bol = oneCog.isDisplayed();
			Assert.assertEquals(true, bol);
			System.out.println("OneCognizant is Validated");
		}
		catch(Exception e)
		{
			System.out.println();
		}
		
	}
	
	public void clickOneCog()
	{
		oneCog.click();
	}
	public void switchToParentWindow() 
	{
		Set<String> windowIds= driver.getWindowHandles();
		for(String winId : windowIds)
		{
			String title = driver.switchTo().window(winId).getTitle();
			if(title.equalsIgnoreCase("Be.Cognizant - Home"))
			{
				driver.switchTo().window(winId);
				break;
			}
		}
	}
	
	public void goToBottom() throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",seeAll);
		

	}
	
	public void validateLocalTime() 
	{
		String localCity= City.get(0).getText();
		System.out.println("The name of the city is : "+ localCity );
		String locTime = localTime.get(0).getText();
		String am_pm =localTime.get(1).getText();
		String locdandD = dayAndDate.get(0).getText();
		String[] localDayAndDate = locdandD.split(", "); 
		String localExpectedDay = localDayAndDate[0];
		String localExpectedDate = localDayAndDate[1];
		String expectedTime = localExpectedDate +" "+ locTime + " " +am_pm.toLowerCase();
		LocalDateTime Time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		String actualTime = Time.format(formatter);
		String[] localActualDate = actualTime.split(" ");
		String localActualTime = localActualDate[1];
		String localDate = localActualDate[0];
		String localAmPm = localActualDate[2];
		if(localDate.charAt(0) == '0')
		{
			newActualDate = localDate.substring(1);
		}
		else
		{
			newActualDate = localDate;
		}
		if(localActualTime.charAt(0)=='0')
		{
			newActualTime = localActualTime.substring(1);
		}
		else {
			newActualTime = localActualTime;
		}
		String newLocalActualDateAndtime = newActualDate + " " + newActualTime + " " + localAmPm ;
		if(newLocalActualDateAndtime.equalsIgnoreCase(expectedTime)) 
		{
			System.out.println("The expectedDateAndTime and actualDateAndTime are the same.The current timeDateAndTime is : " + newLocalActualDateAndtime);
		
		}
		else 
		{
			System.out.println("The expectedDateAndTime and actualDateAndTime are not the same. The current timeDateAndTime is : " + newLocalActualDateAndtime);
		}
		LocalDate day = LocalDate.now();
		String actualDay = day.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
		if(actualDay.equalsIgnoreCase(localExpectedDay))
		{
			System.out.println("The Actual day and the expected day are same. The current day is : " + actualDay);
		}
		else
		{
			System.out.println("The Actual day and the expected day are not same. The current day is : " + actualDay);
		}
	}
	
	public void validateLondonTime() throws Exception
	{
		String cityName= City.get(1).getText();
		System.out.println("The name of the city is : "+ cityName);
		String londonExpectedHour = londonTime.get(0).getText();
		String am_pm =londonTime.get(1).getText().toLowerCase();
		String londonExpectedTime = londonExpectedHour + " " + am_pm;
		String[] londonExpectdDayAndDate = dayAndDate.get(1).getText().split(", "); 
		String londonExpectedDay = londonExpectdDayAndDate[0];
		String londonExpectedDate = londonExpectdDayAndDate[1];
		String expectedTimeBehind = timeDiff.get(1).getText();
		driver.get("https://www.google.com/");
		googleSearch gSearch = new googleSearch(driver);
		gSearch.enterInput("london current time and time diff difference from india");
		gSearch.search();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//LondonTimeFromGoogle.png");
		String londonActualTime = gSearch.getLondonTime();
		String newlondonActualTime ="";
		TimeZone lonodnTimeZone = TimeZone.getTimeZone("Europe/London");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setTimeZone(lonodnTimeZone);
		Date londonDate = new Date();
		String lonodnActualDate = dateFormat.format(londonDate);
		String newLonodnActualDate="";
		if(lonodnActualDate.charAt(0) == '0')
		{
			newLonodnActualDate = lonodnActualDate.substring(1);
		}
		else {
			newLonodnActualDate=lonodnActualDate;
		}
		if(newLonodnActualDate.equalsIgnoreCase(londonExpectedDate))
		{
			System.out.println("The expected date and the actual date are the same. The actual date is : " + newLonodnActualDate );
		}
		else 
		{
			System.out.println("The expected date and the actual date are not the same. The actual date is : " + newLonodnActualDate );
		}
		//int checkTime = londonActualTime.charAt(0) +  londonActualTime.charAt(1);
		String newYorkActualTime = gSearch.getNewYorkTime();
		String  checkTime =  (newYorkActualTime.charAt(0)+""+newYorkActualTime.charAt(1));
		if(checkTime.equals("10") || checkTime.equals("11") || checkTime.equals("12"))
			
		{
			newlondonActualTime = londonActualTime.substring(0, 5) +" "+londonActualTime.substring(6,londonActualTime.length());
		}
		else {
			newlondonActualTime = londonActualTime.substring(0, 4) +" "+londonActualTime.substring(5, londonActualTime.length());
		}
		
		if(newlondonActualTime.equalsIgnoreCase(londonExpectedTime))
		{
			System.out.println("The expected time and the actual time are the same. The actual time is : " + londonExpectedTime );
		}
		else
		{
			System.out.println("The expected time and the actual time are the same. The actual time is : " + londonExpectedTime);
		}
		String londonActualDay = gSearch.getLondonDay();
		String actualTimeDifference = gSearch.getTimeDifference();
		System.out.println(actualTimeDifference + " and "+ cityName +" is " +expectedTimeBehind);
		if(londonActualDay.equalsIgnoreCase(londonExpectedDay))
		{
			System.out.println("The expected day and the actual day are the same. The actual day is : " + londonActualDay );
		}
		else
		{
			System.out.println("The expected day and athe actual day are not same. The actual day is : " + londonActualDay);
		}
		driver.navigate().back();
		driver.navigate().back();
				
	}
	
	public void validateNewYorkTime() throws Exception
	{
		googleSearch gSearch = new googleSearch(driver);
		String cityName= City.get(2).getText();
		System.out.println("The name of the city is : "+ cityName);
		String newYorkExpectedHour = newYorkTime.get(0).getText();
		String am_pm = newYorkTime.get(1).getText();
		String newYorkExpectedTime = newYorkExpectedHour+ " " + am_pm;
		String[] newYorkExpectdDayAndDate = dayAndDate.get(2).getText().split(", "); 
		String newYorkExpectedDay = newYorkExpectdDayAndDate[0];
		String newYorkExpectedDate = newYorkExpectdDayAndDate[1];
		TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setTimeZone(newYorkTimeZone);
		Date newYorkDate = new Date();
		String newYorkActualDate = dateFormat.format(newYorkDate);
		String updatedNewYorkActualDate="";
		if(newYorkActualDate.charAt(0) == '0')
		{
			updatedNewYorkActualDate = newYorkActualDate.substring(1);
		}
		else {
			updatedNewYorkActualDate=newYorkActualDate;
		}
		if(updatedNewYorkActualDate.equalsIgnoreCase(newYorkExpectedDate))
		{
			System.out.println("The expected date and the actual date are the same. The actual date is : " + updatedNewYorkActualDate );
		}
		else 
		{
			System.out.println("The expected date and the actual date are not the same. The actual date is : " + updatedNewYorkActualDate );
		}
		String expectedTimeBehind = timeDiff.get(2).getText();
		driver.get("https://www.google.com/");
		gSearch.enterInput("new york current time and time diff difference from india");
		gSearch.search();
		Thread.sleep(5000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.takeScreenshot("//screenShots//NewYorkTimeFromGoogle.png");
		String updatedNewYorkActualTime ="";
		String newYorkActualTime = gSearch.getNewYorkTime();
		String  nYCheckTime =  (newYorkActualTime.charAt(0)+""+newYorkActualTime.charAt(1));
		if(nYCheckTime.equals("10") || nYCheckTime.equals("11") || nYCheckTime.equals("12"))
		{
			updatedNewYorkActualTime = newYorkActualTime.substring(0, 5) +" "+newYorkActualTime.substring(6, newYorkActualTime.length());
		}
		else {
			updatedNewYorkActualTime = newYorkActualTime.substring(0, 4) +" "+newYorkActualTime.substring(5, newYorkActualTime.length());
		}
		if(updatedNewYorkActualTime.equalsIgnoreCase(newYorkExpectedTime))
		{
			System.out.println("The expected time and the actual time are the same. The actual day is : " + updatedNewYorkActualTime );
		}
		else
		{
			System.out.println("The expected time and the actual time are the same. The actual day is : " + updatedNewYorkActualTime);
		}
		String newYorkActualDay = gSearch.getNewYorkDay();
		String actualTimeDifference = gSearch.getTimeDifference();
		System.out.println(actualTimeDifference + " and "+ cityName +" is " +expectedTimeBehind);
		if(newYorkActualDay.equalsIgnoreCase(newYorkExpectedDay))
		{
			System.out.println("The expected day and the actual day are the same. The actual day is : " + newYorkActualDay );
		}
		else
		{
			System.out.println("The expected day and athe actual day are not same. The actual day is : " + newYorkActualDay);
		}
	} 

}
