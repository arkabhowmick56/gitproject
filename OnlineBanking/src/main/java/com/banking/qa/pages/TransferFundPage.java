package com.banking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.banking.qa.base.TestBase;

public class TransferFundPage extends TestBase {
	
	
	// 1. Page Factory - Object Repository :
	
	@FindBy(xpath="//a[@id='MenuHyperLink3']")
	private WebElement Trnsfrfndlink;
	
	@FindBy(xpath="//h1[text()='Transfer Funds']")
	private WebElement PageHeading;
	
	@FindBy(xpath="//select[@id='fromAccount']")
	private WebElement FromAcct;
	
	@FindBy(xpath="//select[@id='toAccount']")
	private WebElement ToAcct;
	
	@FindBy(xpath="//input[@id='transferAmount']")
	private WebElement AmtToTrnsfr;
	
	@FindBy(xpath="//input[@value='Transfer Money']")
	private WebElement TrnsfrMoneybtn;
	
	@FindBy(xpath="//*[@id='_ctl0__ctl0_Content_Main_postResp']")
	private WebElement TrnsfrMsg;
	
	
	// 2. Constructor of the page class:
		public TransferFundPage() {
					
			PageFactory.initElements(driver, this);
		
		}
			
	
  // 3. Actions
		//Transfer Funds Page Validation
		public String trnsfrPage(String un, String pw) {
			
			LoginPage loginPage = new LoginPage();
			loginPage.login(un, pw);
			Trnsfrfndlink.click();
			String Heading = PageHeading.getText();
			
			return Heading;
		}
	
	  //Money Transfer 
		public void moneyTransfer() {
			
			Select FrmAcct_dropdown = new Select(FromAcct);
			FrmAcct_dropdown.selectByValue(prop.getProperty("Bank_Account"));
			
			Select ToAcct_dropdown = new Select(ToAcct);
			ToAcct_dropdown.selectByValue(prop.getProperty("Bank_Account1"));
			
			AmtToTrnsfr.sendKeys(prop.getProperty("Transfer_Amt"));
			TrnsfrMoneybtn.click();
			 
		}
	
	//Transfer Message Validation
	 public String TrnsfrAmtVal() {
		
		 String Message= TrnsfrMsg.getText();
		 String amt= Message.substring(0, prop.getProperty("Transfer_Amt").length());
		 return amt;
	 }
	 
	 //From Account Validation
	 public String acctVal() {
		 
		 String Message= TrnsfrMsg.getText();
		 return Message;
	 }
	

}
