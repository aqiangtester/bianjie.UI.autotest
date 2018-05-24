package com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils;

public class InitTestDataProvider {

	// 配置文件
	private ReadExcel testData = null;

	private static final InitTestDataProvider init = new InitTestDataProvider();

	public static InitTestDataProvider getInstance() {
		return init;
	}

	private InitTestDataProvider() {
		super();
		testData = new ReadExcel("config//testDataProvider.xlsx");
	}

	public ReadExcel getTestData() {
		return testData;
	}

	public void setTestData(ReadExcel testData) {
		this.testData = testData;
	}

}
