package jan10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnToReadDataFromPropertiedFile {
	public static void main(String[] args) throws IOException {
		//step:1 Setup the path of the properties
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		//step2:create object for properties class
		Properties pro = new Properties();
		//step3:load  the properties file
		pro.load(fis);
		//step4:To read the property
		System.out.println(pro.getProperty("url"));
		System.out.println(pro.getProperty("username"));
		System.out.println(pro.getProperty("password"));
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(pro.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(pro.getProperty("password"));
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pradeepkumar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Namachivayam");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		String id = text.replaceAll("\\D", "");
		
		//To save  the data into the properties file
		FileOutputStream fos = new FileOutputStream("./src/main/resources/config.properties");
		pro.setProperty("leadid", id);
		pro.store(fos, null);
	
	
	
	
	
	
	}
	

}
