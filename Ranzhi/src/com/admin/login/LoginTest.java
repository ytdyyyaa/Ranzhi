package com.admin.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.loginModules.Login_PageObject;
import com.webtest.core.BaseTest;

public class LoginTest extends BaseTest {
	Login_PageObject login = null;

	@BeforeClass
	public void startUp() {
		login = new Login_PageObject(webtest);
	}

	@Test
	public void LoginSuccess() {
		login.loginByFront("admin", "123456");
		assertTrue(webtest.getHtmlSource().contains("ǩ��"));
	}

	@Test
	public void LoginFail() {
		// �ж�ҳ���ǲ������˳�
		boolean flag = webtest.isElementPresent("link=ǩ��");
		if (flag) {
			webtest.click("linkText=ǩ��");
		}
		login.loginByFront("admin", "1234560");
		assertTrue(webtest.getHtmlSource().contains("��¼ʧ��"));
		// assertTrue(webtest.getHtmlSource().contains("��¼�ɹ�"));

	}

}
