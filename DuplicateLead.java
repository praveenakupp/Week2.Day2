package Week2.Day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws Exception {
	
		//*http://leaftaps.com/opentaps/control/main
		 
		//1	Launch the browser
		//2	Enter the username
		//3	Enter the password
		//4	Click Login
		//5	Click crm/sfa link
		//6	Click Leads link
		//7	Click Find leads
		//8	Click on Email
		//9	Enter Email
		//10 Click find leads button
		//11 Capture name of First Resulting lead
		//12 Click First Resulting lead
		//13 Click Duplicate Lead
		//14 Verify the title as 'Duplicate Lead'
		//15 Click Create Lead
		//16 Confirm the duplicated lead name is same as captured name
		//17 Close the browser (Do not log out)
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        driver.findElementById("username").sendKeys("demosalesmanager");
        driver.findElementById("password").sendKeys("crmsfa");
        driver.findElementByClassName("decorativeSubmit").click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElementByLinkText("Leads").click();
        driver.findElementByLinkText("Find Leads").click();
        driver.findElementByXPath("//span[text()='Email']").click();
        
        driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("pk@gmail.com");
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(2000);
        
        //leadname.click();
        String str1=driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)").getText();
        
        Thread.sleep(2000);
        //clicking the duplicate tab
        driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
        System.out.println("The title of the page is: "+driver.getTitle());
        Thread.sleep(2000);
        //click create lead to duplicate the lead
        driver.findElementByXPath("//input[@value='Create Lead']").click();
        String str2=driver.findElementById("viewLead_firstName_sp").getText();
        //compare the above the lead and str2
        if(str1.equals(str2))
        {
        	System.out.println("The lead is same");
        }
        else
        {
        	System.out.println("diffrent lead name");
        }
        
        Thread.sleep(2000);
        driver.close();
        }
}