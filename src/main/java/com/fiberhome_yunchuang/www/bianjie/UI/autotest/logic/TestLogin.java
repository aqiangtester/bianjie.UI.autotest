package com.fiberhome_yunchuang.www.bianjie.UI.autotest.logic;

import org.testng.annotations.Test;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.DashboardPage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.主页_HomePage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLogin extends LogicAdapter{
	
	private Logger logger = Logger.getLogger(TestLogin.class);
	DashboardPage dashboardPage = new DashboardPage();
	String userName = null;
	String password = null;
	
	/*
	 * 加载测试数据
	 * */
	@BeforeClass
	public void beforeClass(){
		logger.info("----------【测试类开始前执行操作】----------");
		for (Sheet sheet : sheetList_testData) {
			if (sheet.getSheetName().equalsIgnoreCase(this.getClass().getSimpleName())) {
				userName = testData.getRowCell(sheet, 1).get(1);
				logger.info(">>>>>>>>>>【用户名】： " + userName);
				password = testData.getRowCell(sheet, 2).get(1);
				logger.info(">>>>>>>>>>【密码】： " + password);
			}
		}
	}
	
	//@Test(dependsOnMethods={"testLogin"})
	public void login() throws InterruptedException {
		
		
		
		logger.info("----------【开始执行测试步骤】----------");
		logger.info(">>>>>>>>>>【输入用户名】： " + userName);
		dashboardPage.inputUserName(userName);
		Thread.sleep(3000);
		
		logger.info(">>>>>>>>>>【输入密码】： " + password);
		dashboardPage.inputPassword(password);
		Thread.sleep(3000);
		
		logger.info(">>>>>>>>>>【点击登录按钮】" );
		主页_HomePage homePage = dashboardPage.clickLoginBtn();
		String actual = homePage.getUserCenter().getText();
		
		logger.info(">>>>>>>>>>【验证点】【验证登录之后，用户中心显示该账号，表明登录成功】： " + actual);
		Assert.assertEquals(actual, userName);
		logger.info(">>>>>>>>>>【验证通过，登录成功】" );
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		logger.info("----------【测试类结束后执行操作】----------");
		dashboardPage.close();
		logger.info("----------【关闭浏览器】----------");
	}
}