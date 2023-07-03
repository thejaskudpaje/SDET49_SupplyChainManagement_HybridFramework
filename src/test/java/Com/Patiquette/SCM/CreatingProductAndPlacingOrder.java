package Com.Patiquette.SCM;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.scm.POM.LoginPage;
import com.scm.genericUtility.ExcelUtility;
import com.scm.genericUtility.FileUtility;
import com.scm.genericUtility.javautility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingProductAndPlacingOrder {
	@Test
	public void creatingProductAndPlacingOrderTest() throws Throwable{

		//creating the objects of the utility classes
		ExcelUtility ex=new ExcelUtility();
		FileUtility fu=new FileUtility();
		javautility ju=new javautility();
		


		//WebActionUtility wa=new WebActionUtility();
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();

		 
		 //entering url
		
		 String envFilePath = fu.getFilepathFromPropertyFile("EnvirnmentalData");
		 String url= fu.getValueOfEnvirmentalData(envFilePath, "url");
		 driver.get(url);
		 
		 

		  
		 //login credentials for admin	
		String adminUN = fu.getValueOfEnvirmentalData(envFilePath, "adminUN");
		String PW=fu.getValueOfEnvirmentalData(envFilePath, "PW");
		String excelFilePath = fu.getFilepathFromPropertyFile("TestScriptdataSCM");
		String loginType=ex.getExceldDataByTestIDAndColName(excelFilePath, "Retailer", "TC_01", "Login_Type_01");
		
		 
			//creating objects of POM classes
		LoginPage lp=new LoginPage(driver);
		
		
		//login as admin
		lp.loginOperation("admin", "admin123", "admin");
		 	 
		 
		 //clicking on add product
		 driver.findElement(By.linkText("Add Products")).click();
		 
		 //Code for creading random name
		 Random ran=new Random();
		 int randNum=ran.nextInt(999);
		 
		//entering text fields
		 String prdName="Patato Chips"+randNum;
		// String prodPrice=p.getProperty("prodPrice");
		 driver.findElement(By.id("product:name")).sendKeys(prdName);
//		 driver.findElement(By.id("product:price")).sendKeys(prodPrice);
		 WebElement UnitTypeDD = driver.findElement(By.id("product:unit"));
		 Select s2=new Select(UnitTypeDD);
		 s2.selectByVisibleText(" KG ");
		 Select s3=new Select(driver.findElement(By.id("product:category")));
		 s3.selectByVisibleText(" snacks ");
		 driver.findElement(By.xpath("//input[@name='rdbStock' and@value=1]")).click();
		 driver.findElement(By.xpath("//input[@value='Add Product']")).submit();
		 
		 //handleling Alert popup
		 Alert a=driver.switchTo().alert();
		 a.accept();
		 System.out.println("Product has been added successfully");
		
		 //clicking on products
		 driver.findElement(By.xpath("//a[text()='Products']")).click();
		 
		 //validating the product
		 String nwName=driver.findElement(By.xpath("//form/table/tbody/tr[last()]/td[3]")).getText();
		 String nwPrice=driver.findElement(By.xpath("//form/table/tbody/tr[last()]/td[4]")).getText();
		 String code = driver.findElement(By.xpath("//form/table/tbody/tr[last()]/td[2]")).getText();
		 
		 System.out.println(nwName);
		 if(nwName.equals(prdName) ) {
			 System.out.println("product name is displaying");
		 }
		 else
			 System.out.println("Product name is not displaying");
		 
		 //logout as admin
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();
		 System.out.println("Logout as admin");
		 
		 //login as manufacturer
		 WebElement listbx2 = driver.findElement(By.id("login:type"));
		 Select s5=new Select(listbx2);
		 s5.selectByVisibleText("Manufacturer");
		 driver.findElement(By.id("login:username")).sendKeys("admin12",Keys.TAB,"admin123",Keys.ENTER);
		 System.out.println("login as manufacturer");

		 
		 //click on manage stock
		 driver.findElement(By.xpath("//a[text()='Manage Stock']")).click();
		 
		 //Update the stock
		 List<WebElement> prodNames = driver.findElements(By.xpath("//table[@class='table_displayData']/tbody/tr/td[2]"));
		// System.out.println(prodNames.size());
		 
		 for(WebElement i:prodNames) {
			 String name=i.getText();
			// System.out.println(name);
			 if(prdName.equals(name)) {
				 String prodName=driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr/td[2][text()='"+name+"']")).getText();
				 System.out.println(prodName);
			driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr/td[2][text()='"+name+"']/following-sibling::td[2]")).sendKeys("10");
			System.out.println("Quantity successfully updated");
			driver.findElement(By.id("btnSubmit")).submit();
			
			 }
			 else {
				 System.out.println("Product is not displaying");
			 }
				 
		 }
		 
		 //logout as manufacturer
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();
		 
		 //login as retailer
//		 driver.findElement(By.id("login:username")).sendKeys(p.getProperty("retailerUN"));
		 driver.findElement(By.id("login:password")).sendKeys("retailerUN");
		 WebElement listbx4 = driver.findElement(By.id("login:type"));
//		 Select s4=new Select(listbx);
		// s4.deselectByValue("retailer");
		 driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		 
		 //click on new order module
		 driver.findElement(By.xpath("//a[text()='New Order']")).click();
		 
		 
		 
		 
		 
		 
		
		 
		 
		 

		
	}
}
