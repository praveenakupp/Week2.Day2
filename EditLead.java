package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
	    
		//*http://leaftaps.com/opentaps/control/main
		
		//* 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//* 2 Enter the username
		WebElement webUser = driver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");
		
		//* 3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//* 4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//* 5 Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//* 6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//* 7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
				
		//* 8 Enter first name
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Praveena");
						
		//* 9 Click Find leads button
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		
	//	Capture the Company name of first resulting lead [to compare whether the Company name has changed]
		String text1 = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td)[5]//a")).getText();
		
	//	Click on First resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td//a)[1]")).click();		
		
	// 	Verify Title of the page is correct
	// 	View Lead | opentaps CRM
		String title ="View Lead | opentaps CRM";
		String leadTitle = driver.getTitle();
		if (title.equals(leadTitle)) {
			System.out.println("In the View Lead page");
		}	
		else
			System.out.println("Not in the View Lead page");
		
		driver.findElement(By.linkText("Edit")).click();
		WebElement cmpnyName = driver.findElement(By.id("updateLeadForm_companyName"));
		cmpnyName.clear();
		cmpnyName.sendKeys("BBC");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text1.equals(text2)) {
			System.out.println("Company name is not changed");
		}	
		else
			System.out.println("Company name is changed");
	//	driver.close();
	}
}
