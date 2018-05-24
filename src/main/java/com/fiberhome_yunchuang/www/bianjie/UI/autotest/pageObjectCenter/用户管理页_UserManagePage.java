package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.Constants;

public class 用户管理页_UserManagePage extends BasePage {

	private WebElement addBtn; // 【新增】按钮
	private WebElement listFirstUserName; // 列表第一条记录的用户姓名
	private WebElement userNameInquire; // 用户姓名查询条件
	private WebElement inquireBtn; // 【查询】按钮
	private WebElement modifyBtn; // 列表第一条记录的【修改】按钮
	private WebElement deleteBtn; // 列表第一条记录的【删除】按钮
	private List<WebElement> listAllData; // 列表全部记录


	Sheet sheet;
	public 用户管理页_UserManagePage() {
		super();
		try {
			sheet = getSheet();
			// driver.get(Constants.HOMEPAGE_URL);

			driver.switchTo().frame("003_001");
			// WebDriverWait wait = new WebDriverWait(driver, 50);
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElementData.getRowCell(sheet,
			// 2).get(7))));

			addBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 2).get(7)));
			listFirstUserName = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 3).get(7)));
			userNameInquire = driver.findElement(By.id(webElementData.getRowCell(sheet, 4).get(1)));
			inquireBtn = driver.findElement(By.id(webElementData.getRowCell(sheet, 5).get(1)));
			modifyBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 6).get(7)));
			deleteBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 7).get(7)));
			
			
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
	 * 点击【新增】按钮
	 */
	public 新增用户页_AddUserPage clickAddBtn() throws InterruptedException {
		addBtn.click();
		Thread.sleep(20000);
		switchIframe();
		return new 新增用户页_AddUserPage();
	}

	private void switchIframe() {
		driver.switchTo().defaultContent();
	}

	// 获取用户列表第一行数据的用户姓名字段值
	public String getListFirstUserName() {
		return listFirstUserName.getText();
	}

	// 输入查询条件：用户姓名
	public void inputUserNameInquire(String userName) {
		userNameInquire.clear();
		userNameInquire.sendKeys(userName);
	}

	// 点击【查询】按钮
	public 用户管理页_UserManagePage clickInquireBtn() {
		inquireBtn.click();
		switchIframe();
		return new 用户管理页_UserManagePage();
	}

	// 点击用户列表第一行数据的【修改】按钮
	public 修改用户页_ModifyUserPage clickModifyBtn() throws InterruptedException {
		modifyBtn.click();
		Thread.sleep(10000);
		switchIframe();
		return new 修改用户页_ModifyUserPage();
	}

	// 点击用户列表第一行数据的【删除】按钮
	public void clickDeleteBtn() throws InterruptedException {
		deleteBtn.click();
		switchIframe();
		Thread.sleep(8000);
//		return new 主页_HomePage();
	}

	//获取用户列表所有记录
	public List<WebElement> getListAllData(){
		
		return listAllData = driver.findElements(By.xpath(webElementData.getRowCell(sheet, 12).get(7)));
		
	}
	
	
	
	

	public WebElement getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(WebElement addBtn) {
		this.addBtn = addBtn;
	}

	public WebElement getUserNameInquire() {
		return userNameInquire;
	}

	public void setUserNameInquire(WebElement userNameInquire) {
		this.userNameInquire = userNameInquire;
	}

	public WebElement getInquireBtn() {
		return inquireBtn;
	}

	public void setInquireBtn(WebElement inquireBtn) {
		this.inquireBtn = inquireBtn;
	}

	public WebElement getModifyBtn() {
		return modifyBtn;
	}

	public void setModifyBtn(WebElement modifyBtn) {
		this.modifyBtn = modifyBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(WebElement deleteBtn) {
		this.deleteBtn = deleteBtn;
	}


	public void setListFirstUserName(WebElement listFirstUserName) {
		this.listFirstUserName = listFirstUserName;
	}

	
	
	
}
