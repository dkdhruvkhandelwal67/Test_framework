package Page_Test;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.Functions_common;
import Page_Java.Login_page;
import Setup.Browser_init;

public class Login_Test {

	public static WebDriver driver;	
	String browser;
	String URL_test;
	String date;
	String current;
	String fileWithPath;

	@BeforeSuite
	public void brower_set()
	{
		browser =Functions_common.fetch_data("browser");
		URL_test =Functions_common.fetch_data("url");
		Login_Test.driver = Browser_init.open_browser(browser);
		driver.get(URL_test);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// implicit wait..........
	}

	@Test
	public void check_title()
	{
		String title;
		title = driver.getTitle();
		Assert.assertEquals(title, "Yahoo India","Title do now match: Failed!!!!!!!!!");
		System.out.println("In check_title==");
	}

	@Test
	public void click_to_sign()
	{
		Login_page lg = new Login_page(driver)	;
		lg.click_signin();
		System.out.println("In click_to_sign==");

	}

	@Test
	public void enter_email()
	{
		String email_id = Functions_common.fetch_data("email");
		Login_page lg = new Login_page(driver)	;
		lg.enter_email(email_id);
		System.out.println("In enter_email==");
	}

	@AfterMethod // its will execute after each method 
	public void tested()
	{
		try {
			date =Functions_common.Fetch_data();
			current = System.getProperty("user.dir");// give path of base directory
			fileWithPath = current + "\\Screenshot\\test_" +date +".png";
			Functions_common.takeSnapShot(driver, fileWithPath);
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
