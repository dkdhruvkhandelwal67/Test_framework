package Page_Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {

	WebDriver driver;

	// object of Login page
	@FindBy(xpath = "//*[@id='createacc']")
	WebElement click_createaccount;

	@FindBy(xpath = "//*[@id='usernamereg-firstName']")
	WebElement first_name;

	@FindBy(xpath = "//*[@id='usernamereg-lastName']")
	WebElement second_name;

	@FindBy(xpath = "//*[@id=usernamereg-yid]")
	WebElement email;

	public Home_page(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void create_account() {
		click_createaccount.click();
	}

	public void enter_firstname(String firstname) {
		first_name.sendKeys(firstname);
	}

	public void enter_secondname(String Lastname) {
		second_name.sendKeys(Lastname);
	}

	public void enter_email(String email_id) {
		email.sendKeys(email_id);
	}
}
