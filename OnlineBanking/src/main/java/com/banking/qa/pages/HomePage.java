package com.banking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.banking.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	// 1. Page Factory - Object Repository :
	
	
	@FindBy(xpath="//input[@id='btnGetAccount']")
	private WebElement go_button;
	
	@FindBy(xpath="//select[@id='listAccounts']")
	private WebElement account_dropdown;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/div/h1")
	private WebElement Acct_details_heading;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[3]/td[1]")
	private WebElement EndBalText_in_BalDtl_Table;      	
	
	
	// 2. Constructor of the page class:
		public HomePage() {
				
			PageFactory.initElements(driver, this);
				
			}
			
	   // 3. Actions :
		
		//Selecting account and Moving to Account Information page
		public AccountInformationpage AccountSelection(String un, String pw) {
			
			LoginPage loginPage = new LoginPage();
			loginPage.login(un, pw);
			Select VAD_dropdown = new Select(account_dropdown);
			VAD_dropdown.selectByValue(prop.getProperty("Bank_Account"));
			go_button.click();
			
			return new AccountInformationpage();
			
		}
		
		public String acct_num_Validation() {
			
			String Account_Number = Acct_details_heading.getText().substring(18, 24);
			return Account_Number;
		}
		
		public String date_Validation() {
			
	          String Date_On_BalDtails_Table = EndBalText_in_BalDtl_Table.getText().substring(21, 28);
	          return Date_On_BalDtails_Table;
		
		}
		
		
		
}
