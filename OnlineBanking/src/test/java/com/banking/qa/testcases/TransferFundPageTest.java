package com.banking.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.TransferFundPage;

public class TransferFundPageTest extends TestBase{
	
	TransferFundPage transferFundPage;
	
	public TransferFundPageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		init_driver();
		transferFundPage = new TransferFundPage();
	}
	
	@Test(priority=1)
	public void transferFundspage_Validation() {
		
		String PageHeading =transferFundPage.trnsfrPage(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(PageHeading,"Transfer Funds");
		System.out.println("Transfer Funds page is Displayed");
	}
	
	@Test(priority=2)
	public void transferAmount() {
		
		transferFundPage.moneyTransfer();
		System.out.println("Selected From Account: "+prop.getProperty("Bank_Account"));
		System.out.println("Selected To Account: "+prop.getProperty("Bank_Account1"));
		System.out.println("Amount Tranferred: "+prop.getProperty("Transfer_Amt"));
		
	}
	
	@Test(priority=3)
	public void amountValidation() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='_ctl0__ctl0_Content_Main_postResp']")));
		String Amount= transferFundPage.TrnsfrAmtVal();
		Assert.assertEquals(Amount,prop.getProperty("Transfer_Amt"));
		System.out.println("Amount Validation passed");
		
	}
	
	@Test(priority=4)
	public void fromAcctValidation() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='_ctl0__ctl0_Content_Main_postResp']")));
		String Message = transferFundPage.acctVal();
		Assert.assertTrue(Message.contains("from Account "+prop.getProperty("Bank_Account")));
		System.out.println("Transfer message is displayed with correct from account details");
	}
	
	@Test(priority=4)
	public void toAcctValidation() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='_ctl0__ctl0_Content_Main_postResp']")));
		String Message = transferFundPage.acctVal();
		Assert.assertTrue(Message.contains("into Account "+prop.getProperty("Bank_Account1")));
		System.out.println("Transfer message is displayed with correct to account details");
	}
	
	@AfterClass
	   public void tearDown() {
		   driver.quit();
	   }
	
}
