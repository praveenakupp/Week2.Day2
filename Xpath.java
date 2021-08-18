package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver path=new ChromeDriver();
		path.get("http://leaftaps.com/opentaps/control/main");
		path.manage().window().maximize();
		path.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		path.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		path.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		path.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		path.findElement(By.xpath("//a[contains(text(),'/SFA')]")).click();
		path.findElement(By.xpath("//a[contains(text()'/Leads')]")).click();
	}

}
