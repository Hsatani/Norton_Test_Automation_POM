package com.norton.qa.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	  
	
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	//public OptionsManager optionsManager;
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	
	public WebDriver initDriver(Properties prop) {
		
		String browesername = prop.getProperty("browser").trim();
		highlight = prop.getProperty("highlight");
//		optionsManager = new OptionsManager(prop);
		
		
		if(browesername.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			// driver = new ChromeDriver(); //launch chrome
		} 
		else if (browesername.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\geckodriver_win32\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			// driver = new FirefoxDriver(); //launch firefox
		}
		else {
			//System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\edgedriver_win32\\edgedriver.exe");
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			//driver = new EdgeDriver(); //launch edge
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
		
	}
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	
	
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(ip);
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}
		return prop;
		}
	
	
	
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return path;
	}
}
	
	
//	public Properties init_prop() {
//		prop = new Properties();
//		FileInputStream ip = null;
//		
//		String envName = prop.getProperty("env");
//		
//		
//		if(envName == null) {
//			System.out.println("Current Running Environment: " + envName);
//			try {
//				 ip = new FileInputStream("./src/test/resource/config/config.properties");
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//		}
//		else {
//			
//			System.out.println("Current Running Environment: " + envName);
//			
//			try {
//				switch(envName) {
//				case "qa":
//					ip = new FileInputStream("./src/test/resource/config/qa.config.properties");
//					break;
//				case "dev":
//					ip = new FileInputStream("./src/test/resource/config/dev.config.properties");
//					break;
//				case "stage":
//					ip = new FileInputStream("./src/test/resource/config/stage.config.properties");
//					break;
//					
//				default:
//					System.out.println("please pass the right environment....");
//					break;
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			 }
//
//				try {
//					prop.load(ip);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//	     }
//		return prop;
//   }
