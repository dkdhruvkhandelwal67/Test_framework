package Page_Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	WebDriver driver;

	// object of Login page
	@FindBy(xpath = "//*[@id='uh-signin']")
	WebElement signin;

	@FindBy(xpath = "//*[@id='login-username']")
	WebElement enter_emailid;

	@FindBy(xpath = "//*[@id='createacc']")
	WebElement click_createaccount;

	public Login_page(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void click_signin() {
		signin.click();
	}

	public void enter_email(String id) {
		enter_emailid.sendKeys(id);
	}

}
