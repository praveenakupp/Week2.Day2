package Week2.Day2;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

	//*http://leaftaps.com/opentaps/control/main
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        	 
	//1	Launch the browser
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        
	//2	Enter the username
        driver.findElementById("username").sendKeys("demosalesmanager");
	//3	Enter the password
        driver.findElementById("password").sendKeys("crmsfa");
        
	//4	Click Login
        driver.findElementByClassName("decorativeSubmit").click();
	//5	Click crm/sfa link
        driver.findElement(By.linkText("CRM/SFA")).click();
	//6	Click Leads link
        driver.findElementByLinkText("Leads").click();
	//7	Click Find leads
        driver.findElementByLinkText("Find Leads").click();
	//8	Click on Phone
        driver.findElement(By.linkText("Phone")).click();
	//9	Enter phone number
        driver.findElement(By.name("phoneAreaCode")).sendKeys("934");
        driver.findElement(By.name("phoneNumber")).sendKeys("5678901992");
	//10 Click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
	//11 Capture lead ID of First Resulting lead
		String leadid = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td//div//a)[1]")).getText();
		System.out.println("Lead ID of first resulting lead is " + leadid);
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td//div//a)[1]")).click();		
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
	//12 Click First Resulting lead
		
	//13 Click Delete
	//14 Click Find leads
	//15 Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(leadid);
	//16 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	//17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text1 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		String text2 = "No records to display";
		if (text1.equals(text2)) {
			System.out.println("Data is deleted");
		}	
		else
			System.out.println("Data is not deleted");
	//18 Close the browser (Do not log out)
		driver.close();
	}
	}
