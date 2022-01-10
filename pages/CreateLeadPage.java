package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {
	public CreateLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}
	public CreateLeadPage enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		return this;
	}
	public CreateLeadPage enterFirstname() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pradeepkumar");
		return this;
	}
	public CreateLeadPage enterLastname() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Namachivayam");
		return this;
	}
	public ViewLeadPage clickCreateLeadButton() {
        driver.findElement(By.className("smallSubmit")).click();
        return new ViewLeadPage(driver);
	}

}
