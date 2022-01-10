package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {
	public ViewLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public ViewLeadPage verifyFirstname() {
		String attribute = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		Assert.assertEquals("Pradeepkumar", attribute);
		return this;
	}

}
