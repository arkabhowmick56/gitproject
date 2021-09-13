package com.banking.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.AccountInformationpage;


public class AccountInformationpageTest extends TestBase{

	
AccountInformationpage acctInfoPage;
	
	
	public AccountInformationpageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		init_driver();
		acctInfoPage = new AccountInformationpage();
	}
	
	@Test(priority=1)
	public void debitAmtValidation() {
		
		String LastUpdatedAmount = acctInfoPage.debitEntry(prop.getProperty("username"), prop.getProperty("password"));
		
		if (LastUpdatedAmount.equals(prop.getProperty("Transfer_Amt"))) {
			System.out.println("Amount avaialable in Debits Table same as transferred Amount");
		}
		else {
			System.out.println("Amount Mismatched, Amount Displayed in Debits Table: "+LastUpdatedAmount+", But Amount transferred was: "+prop.getProperty("Transfer_Amt"));
		}
	}
	
	@Test(priority=2)
	public void creditAmtValidation() {
		
		String LastUpdatedAmount = acctInfoPage.creditEntry();
		
		if (LastUpdatedAmount.equals(prop.getProperty("Transfer_Amt"))) {
			System.out.println("Amount avaialable in Credits Table same as transferred Amount");
		}
		else {
			System.out.println("Amount Mismatched, Amount Displayed in Credits Table: "+LastUpdatedAmount+", But Amount transferred was: "+prop.getProperty("Transfer_Amt"));
		}
	}
	
	@Test(priority=3)
	public void clickonSingoff() {
		
		acctInfoPage.signOff();
		WebDriverWait wait = new WebDriverWait(driver,5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='LoginLink']//font[text()='Sign In']")));
		
		 System.out.println("User is signed off");
	}
	
	@AfterClass
	   public void tearDown() {
		   driver.quit();
	   }
}
