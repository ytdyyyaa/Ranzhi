package com.admin.team;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_Action;
import com.webtest.core.BaseTest;

import Data.Children;

public class SettingsBumen extends BaseTest {
	Login_Action login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_Action(webtest);
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("签退"));
	}

	@Test(priority = 0)
	public void clickteambutton() {
		// 点击团队，进入团队页面
		System.out.println("num1");
		webtest.click("xpath=.//*[@id='s-menu-6']/button");
		assertTrue(webtest.getHtmlSource().contains("最新帖子"));
	}

	@Test(priority = 1)
	public void clicksettingbutton() {
		// 点击设置按钮
		System.out.println("num2");
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		assertTrue(webtest.getHtmlSource().contains("论坛版块"));
		webtest.leaveFrame();
	}

	@Test(priority = 2)
	public void clickBumen() {
		// 点击维护部门，进入到编辑部门信息页面
		System.out.println("num3");
		webtest.enterFrame("iframe-6");
		webtest.click("link=维护部门");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[1]");
		webtest.leaveFrame();
	}

	@Test(priority = 3)
	public void BianjiBumen() {
		// 编辑销售部
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[9]");
		webtest.click("xpath=.//*[@id='moderators_chosen']/a/div");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[4]");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	 @Test(priority = 4)
	 public void BianjiBumen1() {
	 // 编辑销售部的描述
	 webtest.enterFrame("iframe-6");
	 webtest.tabPress();
	 webtest.type("xpath=html/body", "");
	 webtest.tabPress();
	 webtest.type("xpath=html/body", "销售部的部门描述");
	 webtest.leaveFrame();
	 }

	@Test(priority = 5, dataProvider = "children", dataProviderClass = Children.class)
	public void ZiBumen(String children1, String children2, String children3, String children4) {
		// 添加子部门
		webtest.enterFrame("iframe-6");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[2]/a[2]");
		webtest.type("name=children[1]", "children1");
		webtest.type("name=children[2]", "children2");
		webtest.type("name=children[3]", "children3");
		webtest.type("name=children[4]", "children4");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
	}

	 @Test(priority = 6)
	 public void DeleteBumen() {
	 // 删除技术部下第一个子部门
	 webtest.enterFrame("iframe-6");
	 webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/ul/li[1]/a[3]");
	 webtest.leaveFrame();
	 webtest.getAlert();
	 assertEquals(webtest.getAlertTest(),"您确定要执行删除操作吗？");
	 webtest.alertAccept();
	 webtest.leaveFrame();
	 }

}
