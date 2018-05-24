package com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils;

public class InitWebElementData {

	private ReadExcel webElement = null;

	private static final InitWebElementData init = new InitWebElementData();

	public static InitWebElementData getInstance() {
		return init;
	}

	private InitWebElementData() {
		super();
		webElement = new ReadExcel("config//webElement.xlsx");
	}

	public ReadExcel getWebElement() {
		return webElement;
	}

	public void setWebElement(ReadExcel webElement) {
		this.webElement = webElement;
	}

}
