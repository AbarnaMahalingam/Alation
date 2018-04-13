package Amazon;

import java.util.Set;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Framework.Framework;

public class Amazon {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABARNA\\Desktop\\chromedriver.exe");//path for the chrome driver
		WebDriver driver = new ChromeDriver();//Browser_Chrome
		
		String Url="https://www.amazon.in/";//homepage
		

		@BeforeTest//runs at the start of execution
		if(!Framework.createBrowser(driver, Url))
			
		/*checks true 
		 
		 Assert.assertTrue(createBrowser());
		 Assertions can also be used here 
		 
		 Only if the driver loads the homepage the automation can continue
		 
		 */
			
		{
			
			System.out.println("Defect in browser launch");
		}
		
		
		@Test(priority=1)//testcase with priority high
		if(!Framework.dropdown(driver, "id~searchDropdownBox"))//checks true
		{
			System.out.println("Defect in dropdown");
		}
		
		@Test
		if(!Framework.inputtext(driver, "id~twotabsearchtextbox", "data catalog"))//checks true
		{
			System.out.println("Defect in entering text");
		}
		
		@Test
		if(!Framework.window_handle(driver))//checks true
		{
			System.out.println("Defect in window handling");
		}
		
		
		@Test
		if(!Framework.getDetails(driver))//checks true
		{
			System.out.println("Defect in retrieving");
		}
		
		@AfterTest//executed at the end
		public void afterTest1(){
			driver.close();
		}
		
		
		
		
	}

}

