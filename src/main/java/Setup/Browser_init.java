package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser_init {

	public static WebDriver driver;

	// This method will take name of browser as input and will open a browser and
	// return driver for that browser
	public static WebDriver open_browser(String Browser) {
		// enter browser you want to open
		String current = System.getProperty("user.dir");// give path of base directory
		System.out.println(current);
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", current + "\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.gecko.driver", current + "\\Lib\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.ie.driver", current + "\\Lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("No Browser found.....");
		}
		return driver;
	}

}
