package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginLogout extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName() {
		excelFilename = "CreateLead";

	}
	@Test(dataProvider="fetchData")
	public void runLogin(String Username,String Password,String company,String Firstname,String Lastname) {
		LoginPage lp = new LoginPage(driver,pro);
		lp.enterUsername(pro.getProperty("username"))
		.enterPassword(pro.getProperty("password"))
		.clickLoginButton()
		.verifyHomepage()
		.clickCrmsfaLink()
		.clickLeadsButton()
		.clickCreateLeads()
		.enterCompanyName(company)
		.enterFirstname(Firstname)
		.enterLastname(Lastname)
		.clickCreateLeadButton()
		.verifyFirstname(Firstname);
		

	}

}
