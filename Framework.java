package Framework;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Amazon.Amazon;

public class Framework {
	
	/* --------------------------for loading the web page in the browser------------------------------*/

	public static boolean createBrowser(WebDriver driver,String Url)
			{
				try{
				driver.get(Url);//loads the page
				driver.manage().window().maximize();//maximazes the window
				Thread.sleep(3000);
				return true;
			}
				catch(Exception e)
				{
					return false;
					//System.out.println(e);
				}
			}
	
	
	
	/*-------------drop down selection--------------------------*/
	
	public static boolean dropdown(WebDriver driver,String Element)
	{
		
		
		
		try{
			
			String locator=Element.split("~")[0];//splits the element input as locator and identity
			String identifier=Element.split("~")[1];
			
					if(locator.equalsIgnoreCase("ID"))
					{
						Select book=new Select(driver.findElement(By.id(identifier)));
						book.selectByVisibleText("Books");//selects the book by visible text
					}
					else if(locator.equalsIgnoreCase("NAME"))
					{
						
						Select book=new Select(driver.findElement(By.className(identifier)));
						book.selectByVisibleText("Books");	
					}
					
					return true;
		}
			
			catch(Exception e)
			{
				return false;	
			}
			
	}
	
	
	/*---------------------------Input text and search--------------------*/
	
	public static boolean inputtext(WebDriver driver,String Element,String input)
	{
		
		
		
		try{
			
			String locator=Element.split("~")[0];
			String identifier=Element.split("~")[1];
			
					if(locator.equalsIgnoreCase("ID"))
					{
						driver.findElement(By.id(identifier)).click();
						driver.findElement(By.id(identifier)).sendKeys(input,Keys.ENTER);//textbox entry and enter is pressed
					}
					else if(locator.equalsIgnoreCase("NAME"))
					{
						
						driver.findElement(By.className(identifier)).click();
						driver.findElement(By.className(identifier)).sendKeys(input,Keys.ENTER);//textbox entry and enter is pressed
					}
					
					return true;
		}
			
			catch(Exception e)
			{
				return false;	
			}
			
			
		}
	
	/* window handling after selecting the first element of the list*/
	
	
	public static boolean window_handle(WebDriver driver)
			
			{
				
				driver.findElement(By.xpath("//li[@id='result_0']//img")).click();//clicks the first element from the list for description
				
				Set<String> s=driver.getWindowHandles();//gets the window handles
				
				//System.out.println(s);
				
				int window=1;
				String window1="";
				String window2="";
				
				for(String res:s)//assigning window ids
				{
					if(window==1)
						
					{
						window1=res;
					}
					else
					{
						window2=res;
					}
					window++;
					
				}
				
				
				driver.switchTo().window(window2);///switched to second window
				return true;
			}
			
		
	
	/*---------------Book details retrieval----------------------*/
	
	public static boolean getDetails(WebDriver driver)
	
	{
		String title=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();//gets the title
		
		System.out.println("TITLE :" +title);
		
		System.out.println("/n");
		
		System.out.println("PAPERBACK PRICE DETAIL");
		
		driver.findElement(By.xpath("//div[@id='formats']/a")).click();//clicks the "show all" link
		
		driver.findElement(By.xpath("//div[@id='twister']/div[2]/span/table/tbody/tr/td/a")).click();//expands the price detail further
		
		for(int i=1;i<=3;i++)// prints the version ,price, new price for paperback
		{
		String book1=driver.findElement(By.xpath("//*[@id='declarative_binding_landing']/table/tbody/tr/td["+i+"]")).getText();
		
		if(i==1)
		{
		System.out.println("Format and Edition " +book1);
		}
		else if(i==2)
		{
			System.out.println("Price" +book1);
		}
		else
		{
			System.out.println("Price" +book1);
		}
		
		}
		return true;
		
		
		
	}	
}

	
	
	
	
	
	
	

