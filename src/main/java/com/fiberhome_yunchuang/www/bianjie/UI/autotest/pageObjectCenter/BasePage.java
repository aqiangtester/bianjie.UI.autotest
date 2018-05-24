package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Browser{

	public BasePage() {
		super();
		// TODO Auto-generated constructor stub
	}


	//获取页面句柄
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}


	//获取页面标题
	public String getTitle(){
		return driver.getTitle();
	}


	//获取页面的URL
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	Actions action = new Actions(driver);
	//鼠标左键双击
	public void doubleClick(WebElement webElement){
		action.doubleClick(webElement);
	}
	
	public void doubleClick(){
		action.doubleClick();
	}

	//鼠标左键点击并拖动
	public void clickAndHold(WebElement webElement){
		action.clickAndHold(webElement);
	}
	
	public void clickAndHold(){
		action.clickAndHold();
	}
	
	//鼠标移动到目标元素
	public void moveToElement(WebElement webElement){
		action.moveToElement(webElement);
	}

}
