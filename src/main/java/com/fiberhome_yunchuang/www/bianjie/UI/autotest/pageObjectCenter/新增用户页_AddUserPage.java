package com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter;


import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class 新增用户页_AddUserPage extends BasePage {

	
//	private WebElement addBtn;
	private WebElement userNameInputText;
	private WebElement mobileInputText;
	private WebElement emailInputText;
	
	//各角色名
	private WebElement agencyManager;
	private WebElement windowRefund;
	private WebElement officeApproval;
	private WebElement financialApproval;
	private WebElement operator;
	
	
	private WebElement okBtn;
	
	
	
	
	public 新增用户页_AddUserPage() {
		super();
		Sheet sheet;
		try {
			sheet = getSheet();
			
			
			driver.switchTo().frame("003_001");
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			addBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 2).get(7)));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(webElementData.getRowCell(sheet, 3).get(1))));
			
			userNameInputText = driver.findElement(By.id(webElementData.getRowCell(sheet, 3).get(1)));
			mobileInputText = driver.findElement(By.id(webElementData.getRowCell(sheet, 4).get(1)));
			emailInputText = driver.findElement(By.id(webElementData.getRowCell(sheet, 5).get(1)));
			
			agencyManager = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 6).get(7)));
			windowRefund = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 7).get(7)));
			officeApproval = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 8).get(7)));
			financialApproval = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 9).get(7)));
			operator = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 10).get(7)));
			
			okBtn = driver.findElement(By.xpath(webElementData.getRowCell(sheet, 11).get(7)));
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
	
	
//	/*
//	 * 点击【新增】按钮
//	 * */
//	public void clickAddBtn(){
//		addBtn.click();
//	}
	
	
	/*
	 * 输入用户姓名
	 * */
	public void inputUserName(String userName) {
		// 清理用户姓名输入框
		userNameInputText.clear();
		userNameInputText.sendKeys(userName);
	}
	
	
	/*
	 * 输入联系电话
	 * */
	public void inputMobile(String mobile) {
		// 清理联系电话输入框
		mobileInputText.clear();
		mobileInputText.sendKeys(mobile);
	}
	
	/*
	 * 输入邮箱
	 * */
	public void inputEmail(String email) {
		// 清理邮箱输入框
		emailInputText.clear();
		emailInputText.sendKeys(email);
	}
	
	
	/*
	 * 勾选机构管理员
	 * */
	public void selectAgencyManager() {
		agencyManager.click();
	}
	
	/*
	 * 勾选窗口退费
	 * */
	public void selectWindowRefund() {
		windowRefund.click();
	}
	
	
	/*
	 * 勾选经办审批
	 * */
	public void selectOfficeApproval() {
		officeApproval.click();
	}
	
	/*
	 * 勾选财政审批
	 * */
	public void selectFinancialApproval() {
		financialApproval.click();
	}
	
	/*
	 * 勾选操作员
	 * */
	public void selectOperator() {
		operator.click();
	}
	
	/*
	 * 点击【确定】按钮
	 * */
	public 用户管理页_UserManagePage clickokBtn() throws InterruptedException{
		okBtn.click();
		Thread.sleep(8000);
		switchIframe();
		return new 用户管理页_UserManagePage();
	}
	
	private void switchIframe(){
		driver.switchTo().defaultContent();
	}
	
}
