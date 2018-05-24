package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InitDriver {
	
	// 浏览器驱动名称，配置文件
	private WebDriver driver;
	private Properties properties = new Properties();
	
	
	private static final InitDriver init = new InitDriver();
	public static InitDriver getInstance() {
		return init;
	}

	
	private InitDriver() {
		super();
		// TODO Auto-generated constructor stub
		Iterator<String> it = initEnv();
		while (it.hasNext()) {
			String key = it.next();
			String value = properties.getProperty(key);
			if ("firefox".equalsIgnoreCase(key)) {
				System.setProperty("webdriver.gecko.driver", value);
				//FirefoxOptions options = new FirefoxOptions();
				//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed
		 
				//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				//capabilities.setCapability("moz:firefoxOptions", options);
				//set more capabilities as per your requirements
		 
				//driver = new FirefoxDriver(options);
				//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				//capabilities.setCapability("firefox_binary","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				driver = new FirefoxDriver();
			} else if ("ie".equalsIgnoreCase(key)) {
				System.setProperty("webdriver.ie.driver", value);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				driver = new InternetExplorerDriver(capabilities);
			} else if ("chrome".equalsIgnoreCase(key)) {
				System.setProperty("webdriver.chrome.driver", value);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--test-type");
				driver = new ChromeDriver(options);
			}
		}

	}


	// 加载配置文件
	private Iterator<String> initEnv() {
		InputStream in = null;
		Iterator<String> it = null;
		try {
			in = new BufferedInputStream(new FileInputStream("config/env.properties"));
			properties.load(in);
			it = properties.stringPropertyNames().iterator();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return it;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
