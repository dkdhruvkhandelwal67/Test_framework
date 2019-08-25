package Page_Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Functions_common;
import Page_Java.Home_page;
import Page_Java.Login_page;

public class Home_Test extends Login_Test{
	
	public  WebDriver driver;	
	String date;
	String current;
	String fileWithPath;
	
	public Home_Test()
	{
		this.driver=Login_Test.driver;
	}
	
	@Test
	public void click_to_create()
	{
		Home_page hm = new Home_page(Login_Test.driver);
		hm.create_account();
	}

	@Test
	public void click_to_sign()
	{
		Home_page hm = new Home_page(Login_Test.driver);
		String firstname = Functions_common.fetch_data("firstname");
		String Lastname = Functions_common.fetch_data("lastname");
		String email_id = Functions_common.fetch_data("emailid");
        hm.enter_firstname(firstname);
        hm.enter_secondname(Lastname);
	}


	@AfterMethod // its will execute after each method 
	public void tested()
	{
		try {
			date =Functions_common.Fetch_data();
			current = System.getProperty("user.dir");// give path of base directory
			fileWithPath = current + "\\Screenshot\\test_" +date +".png";
			Functions_common.takeSnapShot(Login_Test.driver, fileWithPath);
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void brower_close()
	{
		Login_Test.driver.quit();
	}

}
