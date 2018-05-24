package com.fiberhome_yunchuang.www.bianjie.UI.autotest.logic;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fiberhome_yunchuang.www.bianjie.UI.autotest.interf.Driver;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.DashboardPage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.主页_HomePage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.修改用户页_ModifyUserPage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.新增用户页_AddUserPage;
import com.fiberhome_yunchuang.www.bianjie.UI.autotest.pageObjectCenter.用户管理页_UserManagePage;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class TestAddUser extends LogicAdapter {

	private Logger logger = Logger.getLogger(TestAddUser.class);
	
	主页_HomePage homePage = null;
	用户管理页_UserManagePage userManagePage = null;
	新增用户页_AddUserPage addUserPage = null;
	修改用户页_ModifyUserPage modifyUserPage = null;
	
	String clientName = null;
	String mobile = null;
	String email = null;
	String timeStamp = Long.toString(System.currentTimeMillis()); 
	
	/*
	 * 加载测试数据
	 */
	@BeforeClass
	public void beforeClass() {
		logger.info("----------【测试类开始前执行操作】----------");
		for (Sheet sheet : sheetList_testData) {
			if (sheet.getSheetName().equalsIgnoreCase(this.getClass().getSimpleName())) {
				clientName = testData.getRowCell(sheet, 1).get(1);
				logger.info(">>>>>>>>>>【用户姓名】： " + clientName);
				mobile = testData.getRowCell(sheet, 2).get(1);
				logger.info(">>>>>>>>>>【联系电话】： " + mobile);
				email = testData.getRowCell(sheet, 3).get(1);
				logger.info(">>>>>>>>>>【邮箱】： " + email);
			}
		}
		
	}
	
	@Test(priority = 1)
	public void testLogin() throws InterruptedException {
	
		DashboardPage dashboardPage = new DashboardPage();
		String userName = null;
		String password = null;
		for (Sheet sheet : sheetList_testData) {
			if (sheet.getSheetName().equalsIgnoreCase(Thread.currentThread().getStackTrace()[1].getMethodName())) {
				userName = testData.getRowCell(sheet, 1).get(1);
				logger.info(">>>>>>>>>>【用户名】： " + userName);
				password = testData.getRowCell(sheet, 2).get(1);
				logger.info(">>>>>>>>>>【密码】： " + password);
			}
		}
		
		logger.info("----------【开始执行验证登录成功测试步骤】----------");
		logger.info(">>>>>>>>>>【输入用户名】： " + userName);
		dashboardPage.inputUserName(userName);
		
		logger.info(">>>>>>>>>>【输入密码】： " + password);
		dashboardPage.inputPassword(password);
		
		logger.info(">>>>>>>>>>【点击登录按钮】" );
		主页_HomePage homePage = dashboardPage.clickLoginBtn();
		String actual = homePage.getUserCenter().getText();
		
		logger.info(">>>>>>>>>>【验证点】【验证登录之后，用户中心显示该账号，表明登录成功】： " + actual);
		Assert.assertEquals(actual, userName);
		logger.info(">>>>>>>>>>【验证通过，登录成功】" );
		Thread.sleep(3000);
	}

	
	@Test(dependsOnMethods={"testLogin"}, priority = 2)
	public void addUser() throws InterruptedException {
		
		homePage = new 主页_HomePage();
		
		logger.info("----------【开始执行验证新增用户成功测试步骤】----------");
		logger.info(">>>>>>>>>>【点击左侧菜单—用户管理】" );
		userManagePage = homePage.clickUserManage();
		
		logger.info(">>>>>>>>>>【点击新增按钮】" );
		addUserPage = userManagePage.clickAddBtn();
		
		String expectUserName = clientName + timeStamp;
		logger.info(">>>>>>>>>>【输入用户姓名】： "+ expectUserName );
		addUserPage.inputUserName(expectUserName);
		
		logger.info(">>>>>>>>>>【输入电话号码】： "+ mobile );
		addUserPage.inputMobile(mobile);
		
		logger.info(">>>>>>>>>>【输入邮箱】： "+ email );
		addUserPage.inputEmail(email);
		
		logger.info(">>>>>>>>>>【选择操作员】" );
		addUserPage.selectOperator();
		
		logger.info(">>>>>>>>>>【点击确定按钮】" );
		userManagePage = addUserPage.clickokBtn();
		
		String actualUserName = userManagePage.getListFirstUserName();
		logger.info(">>>>>>>>>>【验证点】【验证列表中第一条记录即为新增的用户】： "+ actualUserName );
		Assert.assertEquals(actualUserName, expectUserName);
		logger.info(">>>>>>>>>>【验证通过，新增用户成功】" );
	}
	
	@Test(dependsOnMethods={"modifyUser"}, enabled = true, priority=4)
	public void inquireUser() throws InterruptedException{
		String expectUserName = "modifyUser" + timeStamp;
		userManagePage.inputUserNameInquire(expectUserName);
		userManagePage = userManagePage.clickInquireBtn();
		Thread.sleep(8000);
		
//		List<WebElement> list = userManagePage.getListAllData();
//		
//		for (WebElement webElement : list) {
//			if (webElement == null) {
//				Assert.assertTrue(false, "如果查询列表为空，验证失败");
//			}else {
//				
//			}
//		}
		String actualUserName = userManagePage.getListFirstUserName();
		logger.info(">>>>>>>>>>【验证点】【验证查询出的列表中用户用户姓名与查询条件一致】： "+ actualUserName );
		Assert.assertEquals(actualUserName, expectUserName);
		logger.info(">>>>>>>>>>【验证通过，查询用户成功】" );
		
		
	}
	
	@Test(dependsOnMethods={"addUser"}, priority = 3, enabled = true)
	public void modifyUser() throws InterruptedException{
		
		logger.info("----------【开始执行验证修改用户成功测试步骤】----------");
		logger.info(">>>>>>>>>>【选择列表第一条用户记录，点击修改按钮】" );
		modifyUserPage = userManagePage.clickModifyBtn();
		
		String modifyUserName = Thread.currentThread().getStackTrace()[1].getMethodName() + timeStamp;
		logger.info(">>>>>>>>>>【修改用户姓名】" );
		modifyUserPage.inputUserName(modifyUserName);
		
		logger.info(">>>>>>>>>>【点击确定按钮】" );
		userManagePage = modifyUserPage.clickokBtn();
		Thread.sleep(5000);
		String actualUserName = userManagePage.getListFirstUserName();
		logger.info(">>>>>>>>>>【验证点】【验证列表中第一条用户记录修改了用户姓名】： "+ actualUserName );
		Assert.assertEquals(actualUserName, modifyUserName);
		logger.info(">>>>>>>>>>【验证通过，修改用户成功】" );
	}
	
	@Test(dependsOnMethods={"modifyUser"}, priority = 4, enabled = false)
	public void deleteUser() throws InterruptedException{
		
		logger.info("----------【开始执行验证删除用户成功测试步骤】----------");
		logger.info(">>>>>>>>>>【选择列表第一条用户记录，点击删除按钮】" );
		userManagePage.clickDeleteBtn();
		
		logger.info(">>>>>>>>>>【弹窗提示，点击确定按钮】" );
		homePage.clickTanChuangOKBtn();
		Thread.sleep(8000);

//		String actualUserName = userManagePage.getListFirstUserName();
//		logger.info(">>>>>>>>>>【验证点】【验证列表中第一条用户记录修改了用户姓名】： "+ actualUserName );
//		Assert.assertEquals(actualUserName, modifyUserName);
//		logger.info(">>>>>>>>>>【验证通过，修改用户成功】" );
	}
	

	@AfterTest
	public void afterClass() {
		userManagePage.close();
	}
}
