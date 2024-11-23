package com.baseclass;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.collections4.FactoryUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class baseclass {
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING BROWSER LAUNCH");

		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchurl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING URL LAUNCH");
		}
		return driver;
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING BROWSER CLOSE");
		}

	}

	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING BROWSER QUIT");
		}
	}

	protected static void pass(WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING VALUE PASS");
		}
	}

	protected static void navigation(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING NAVIGATE");
		}
	}

	protected static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING ELEMENT CLICK");
		}
	}

	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByVisibletext(WebElement element, String text) {
		try {
			dropDownObject(element).selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SELECT TEXT");
		}
	}

	protected static void selectByIndex(WebElement element, int num) {
		try {
			dropDownObject(element).selectByIndex(num);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SELECT BY INDEX");
		}
	}

	protected static void windowHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING WINDOW HANDLES");
		}
	}

	protected static void forward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING NAVIGATE FORWARD");
		}
	}

	protected static void backward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING NAVIGATE BACKWARD");
		}
	}

	protected static void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING REFRESH");
		}
	}

	protected static void alert() {
		try {
			driver.switchTo().alert();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING ALERT");
		}
	}

	protected static Actions aactions() {
		try {
			Actions action = new Actions(driver);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING ACTIONS");
		}
		return null;
	}

	protected static void Draganddrop(WebElement element, WebElement elementn) {
		try {
			aactions().dragAndDrop(element, elementn);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING DRAG AND DROP");
		}
	}

	protected static void contextclick(WebElement element) {
		try {
			aactions().contextClick().build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING RIGHT CLICK");
		}
	}

	protected static void moveto(WebElement element) {
		try {
			aactions().moveToElement(element).build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING MOVING  ELEMENT");
		}
	}

	protected static void doubleclick() {
		try {
			aactions().doubleClick().build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING DOUBLE CLICK");
		}
	}

	protected static void Switchframebyindex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SWITCHING FRAME BY INDEX");
		}
	}

	protected static void switchframebyidorname(String idorname) {
		try {
			driver.switchTo().frame(idorname);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SWITCH FRAME BY ID OR NAME");
		}
	}

	protected static void switchframebyelement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SWITCH FRAME BY ELEMENT");
		}
	}

	protected static void displayed(WebElement element) {
		try {
			boolean display = element.isDisplayed();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING ISDISPLAYED");
		}
	}

	protected static void enable(WebElement element) {
		try {
			boolean enable = element.isEnabled();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING ISENABLED");
		}
	}

	protected static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING CLEAR");
		}
	}

	protected static void implicitwait(int sec) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING IMPLICITWAIT");

		}
	}

	protected static void explicitwait(WebElement element, int sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING EXPLICITWAIT");

		}
	}

	protected static void takesscreenshot(String filepath) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(filepath);
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCURS DURING TAKING SCREENSHOT");
		}
	}

	protected static void softassert(String actual, String expect) {
		try {
			// softassert soft =new softassert();
			// soft.softassert(actual, expect);

		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING SOFTASSERT");
		}
	}

	protected static void hardassert(String actual, String expected) {
		try {
			// Assert.assertequals(actual,expected);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING HARDASSERT");
		}
	}

	protected static void validation(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING HARDASSERT");
		}
	}

	protected static void robot(String file) throws Exception {

		Robot r = new Robot();
		r.delay(1000);
		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);

	}

	protected static void javascriptexecutor(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguements[0].click();", element);
			js.executeScript("window.scrollBy(0,3000)");
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING JAVASCRIPTEXECUTOR");
		}
	}

	public static void extentreportstart(String location) {
		try {

			extentreports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
			extentreports.attachReporter(sparkreporter);
			extentreports.setSystemInfo("OS", System.getProperty("java.version"));

		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING EXTENTREPORTS");
		}
	}

	public static void extentreportteardown(String location) {
		try {
			extentreports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
		} catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING REPORTTEARDOWN");
		}
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
}
