package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public WebDriver driver;
	public Properties  p;
	int option ;
	
	
	
	@BeforeTest
	public void setUp() throws IOException
	{
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
//		@SuppressWarnings("resource")
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Browser :");
		System.out.println("Press 1 for Chrome.");
		System.out.println("Press 2 for Edge.");
		option = sc.nextInt();
		switch(option)
		{
			case 1 :
				 driver = new ChromeDriver();
//				 return driver;
				 break;
				
			default : 
				 driver = new EdgeDriver();
//				 return driver;
				 break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
		sc.close();
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
