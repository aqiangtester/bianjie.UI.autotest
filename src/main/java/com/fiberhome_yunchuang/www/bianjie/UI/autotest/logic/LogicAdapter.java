package com.fiberhome_yunchuang.www.bianjie.UI.autotest.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.interf.ExcelObj;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.DashboardPage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.主页_HomePage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils.InitTestDataProvider;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils.ReadExcel;

public class LogicAdapter implements ExcelObj{

	ReadExcel testData = null;
	List<Sheet> sheetList_testData = null;
	
	private Logger logger = Logger.getLogger(LogicAdapter.class);
	
	
	public LogicAdapter() {
		super();
		excelObj();
	}
	

	@Override
	public void excelObj() {
		// TODO Auto-generated method stub
		testData = InitTestDataProvider.getInstance().getTestData();
		sheetList_testData = testData.getSheetLists();
		
	}
	
	
	
//	@Test
//	public void testLogin() throws InterruptedException {
//		
//	
//		DashboardPage dashboardPage = new DashboardPage();
//		String userName = null;
//		String password = null;
//		logger.info("----------【测试类开始前执行操作】----------");
//		for (Sheet sheet : sheetList_testData) {
//			if (sheet.getSheetName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[1].getMethodName())) {
//				userName = testData.getRowCell(sheet, 1).get(1);
//				logger.info(">>>>>>>>>>【用户名】： " + userName);
//				password = testData.getRowCell(sheet, 2).get(1);
//				logger.info(">>>>>>>>>>【密码】： " + password);
//			}
//		}
//		
//		logger.info("----------【开始执行测试步骤】----------");
//		logger.info(">>>>>>>>>>【输入用户名】： " + userName);
//		dashboardPage.inputUserName(userName);
//		Thread.sleep(3000);
//		
//		logger.info(">>>>>>>>>>【输入密码】： " + password);
//		dashboardPage.inputPassword(password);
//		Thread.sleep(3000);
//		
//		logger.info(">>>>>>>>>>【点击登录按钮】" );
//		主页_HomePage homePage = dashboardPage.clickLoginBtn();
//		String actual = homePage.getUserCenter().getText();
//		
//		logger.info(">>>>>>>>>>【验证点】【验证登录之后，用户中心显示该账号，表明登录成功】： " + actual);
//		Assert.assertEquals(actual, userName);
//		logger.info(">>>>>>>>>>【验证通过，登录成功】" );
//		Thread.sleep(3000);
//	}
}
