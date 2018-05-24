package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.interf.Driver;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.interf.ExcelObj;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils.InitWebElementData;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils.ReadExcel;

public class Browser implements Driver, ExcelObj{

	WebDriver driver = null;
	ReadExcel webElementData = null;
	List<Sheet> sheetList_webElement = null;
	
	public Browser() {
		super();
		// TODO Auto-generated constructor stub
		driver();
		excelObj();
	}
	
	@Override
	public void driver() {
		// TODO Auto-generated method stub
		driver = InitDriver.getInstance().getDriver();
	}
	

	@Override
	public void excelObj() {
		// TODO Auto-generated method stub
		webElementData = InitWebElementData.getInstance().getWebElement();
		sheetList_webElement = webElementData.getSheetLists();
	}

	/* 访问 */
	public void get(String url) {
		driver.get(url);
	}

	/* 后退 */
	public void back() {
		driver.navigate().back();
	}

	/* 前进 */
	public void forward() {
		driver.navigate().forward();
	}

	/* 刷新 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/* 最大化 */
	public void maxWindow() {
		driver.manage().window().maximize();
	}

	/* 设置浏览器窗口大小 */
	public void setBrowserSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	/* 关闭浏览器 */
	public void quit() {
		driver.quit();
	}

	/* 关闭浏览器 */
	public void close() {
		driver.close();
	}

	/* 打开新标签 */
	void openNewLabel() {
		
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
	
//	Actions action = new Actions(driver);
//	//鼠标左键双击
//	public void doubleClick(WebElement webElement){
//		action.doubleClick(webElement);
//	}
//	
//	public void doubleClick(){
//		action.doubleClick();
//	}
//
//	//鼠标左键点击并拖动
//	public void clickAndHold(WebElement webElement){
//		action.clickAndHold(webElement);
//	}
//	
//	public void clickAndHold(){
//		action.clickAndHold();
//	}
//	
//	//鼠标移动到目标元素
//	public void moveToElement(WebElement webElement){
//		action.moveToElement(webElement);
//	}


}
