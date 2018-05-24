package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.Constants;

public class DashboardPage extends BasePage {

	private WebElement userNameInputText;			//用户名输入框
	private WebElement passwordInputText;			//密码输入框
	private WebElement loginBtn;					//登录按钮
	
	
	
	
	/**
	 * 构造方法，初始化DashboardPage页面，加载管理该页面元素的excel
	 */
	public DashboardPage() {
		super();
		Sheet sheet;
		try {
			sheet = getSheet();
			driver.get(Constants.DASHBOARD_URL);
			userNameInputText = driver.findElement(By.id(webElementData.getRowCell(sheet, 2).get(1)));
			passwordInputText = driver.findElement(By.id(webElementData.getRowCell(sheet, 3).get(1)));
			loginBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 4).get(7)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @date 2018年5月8日下午2:19:27
	 * @return
	 * @throws Exception
	 * @return_type Sheet
	 * @description 读取管理该页面元素的excel，通过该类类名与excel内sheet名称比对，获取对应的sheet
	 */
	private Sheet getSheet() throws Exception {
		for (Sheet sheet : sheetList_webElement) {
			if (sheet.getSheetName().equalsIgnoreCase(this.getClass().getSimpleName())) {
				return sheet;
			}
		}
		throw new Exception(this.getClass().getSimpleName() + "sheet不存在！");
	}

	/* 输入用户名 */
	public void inputUserName(String userName) {
		// 清理用户名输入框，因为有些输入框存在默认值
		userNameInputText.clear();
		userNameInputText.sendKeys(userName);
	}

	/* 输入密码 */
	public void inputPassword(String password) {
		// 清理密码输入框
		passwordInputText.clear();
		passwordInputText.sendKeys(password);
	}

	/* 点击【登录】按钮，登录成功，跳转首页 */
	public 主页_HomePage clickLoginBtn() {
		loginBtn.click();
		return new 主页_HomePage();
	}

	public WebElement getUserNameInputText() {
		return userNameInputText;
	}

	public void setUserNameInputText(WebElement userNameInputText) {
		this.userNameInputText = userNameInputText;
	}

	public WebElement getPasswordInputText() {
		return passwordInputText;
	}

	public void setPasswordInputText(WebElement passwordInputText) {
		this.passwordInputText = passwordInputText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
}
