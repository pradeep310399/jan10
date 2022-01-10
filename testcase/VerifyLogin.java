package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VerifyLogin extends ProjectSpecificMethods {
	@Test
	public void runLogin() {
		LoginPage lp = new LoginPage(driver,pro);
		lp.enterUsername(pro.getProperty("username"))
		.enterPassword(pro.getProperty("password"))
		.clickLoginButton();
		
		/*.clickCrmsfaLink()
		.clickLeadsButton()
		.clickCreateLeads()
		.enterCompanyName()
		.enterFirstname()
		.enterLastname()
		.clickCreateLeadButton()
		.verifyFirstname();*/
		

	}

}
