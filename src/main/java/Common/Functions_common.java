package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Functions_common {

	public static Properties prob;
	static String property;
	String current;

	// Fetch property from config file
	public static String fetch_data(String key_prop) {
		try {
			prob = new Properties();
			property = null;
			String current = System.getProperty("user.dir");// give path of base directory
			FileInputStream fs = new FileInputStream(current + "\\src\\main\\resource\\Config.properties");
			prob.load(fs);
			property = prob.getProperty(key_prop);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return property;
	}

	// Take screenshot on failure
	public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	// get current date and time stamp
	public static String Fetch_data() {
		String st;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		st = dtf.format(now).toString().replace(" ", "_"); // string operation to replace a character or a list of
															// character
		st = st.toString().replace(":", "_");
		st = st.toString().replace("/", "_");
		return st;
	}
}
