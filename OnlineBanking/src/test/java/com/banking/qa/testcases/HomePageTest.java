package com.banking.qa.testcases;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.AccountInformationpage;
import com.banking.qa.pages.HomePage;


public class HomePageTest extends TestBase{
	
	HomePage homePage;
	AccountInformationpage acctInfoPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		init_driver();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void acctSelection() {
		
		acctInfoPage = homePage.AccountSelection(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void accountValidation() {
		String Account_Num = homePage.acct_num_Validation();
		Assert.assertEquals(Account_Num, prop.getProperty("Bank_Account"));
		System.out.println("Selected Bank Account is: "+prop.getProperty("Bank_Account"));
			
	}
	
	@Test(priority=3)
	public void dateValidation() {
		
		Date date = Date.from(ZonedDateTime.now(ZoneId.of( "America/Chicago" )).toInstant());
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yy");
		String formattedDate = sdf.format(date);
		String currentDate= homePage.date_Validation();
		Assert.assertEquals(formattedDate, currentDate);
		System.out.println("Date Displayed in Balance Detail table is: "+currentDate);
		
	}
	
	
	@AfterClass
	   public void tearDown() {
		   driver.quit();
	   }
	

}
