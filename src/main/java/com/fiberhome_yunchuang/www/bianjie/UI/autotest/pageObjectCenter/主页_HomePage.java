package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.Constants;

public class 主页_HomePage extends BasePage{

	private WebElement userCenter;
	private WebElement userManage;
	private WebElement tanChuangOKBtn; // 点击记录的【删除】按钮，弹窗的【确定】按钮


	public 主页_HomePage() {
		super();
		Sheet sheet;
		try {
			sheet = getSheet();
//			driver.get(Constants.HOMEPAGE_URL);
			userCenter = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 2).get(7)));
			userManage = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 3).get(7)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private Sheet getSheet() throws Exception {
		for (Sheet sheet : sheetList_webElement) {
			if (sheet.getSheetName().equalsIgnoreCase(this.getClass().getSimpleName())) {
				return sheet;
			}
		}
		throw new Exception("sheet不存在！");
	}
	
	
	/*
	 * 点击用户管理，进入用户管理页
	 * */
	public 用户管理页_UserManagePage clickUserManage() throws InterruptedException{
		userManage.click();
		Thread.sleep(10000);
		return new 用户管理页_UserManagePage();
	}
	
	// 点击【删除】之后，点击弹窗内的【确定】按钮
	public void clickTanChuangOKBtn() throws InterruptedException {
//		Actions actions = new Actions(driver);
//		Thread.sleep(6000);
//		actions.doubleClick(driver.findElement(By.xpath("//body/div[4]/div[3]/a[1]"))).perform();
//		tanChuangOKBtn = driver.findElement(By.xpath("//body/div[4]")).findElement(By.xpath("/div[3]/a[1]"));
		tanChuangOKBtn = driver.findElement(By.xpath("//body/div[4]/div[3]/a[1]"));
		tanChuangOKBtn.click();
	}
	

	public WebElement getUserCenter() {
		return userCenter;
	}


	public void setUserCenter(WebElement userCenter) {
		this.userCenter = userCenter;
	}
	
}
