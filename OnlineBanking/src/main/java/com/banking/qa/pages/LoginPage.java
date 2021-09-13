package com.banking.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	// 1. Page Factory - Object Repository :
	
	@FindBy(xpath="//input[@id='uid']")
	private WebElement username;
	@FindBy(xpath="//input[@id='passw']")
	private WebElement Passwd;
	@FindBy(xpath="//input[@name='btnSubmit']")
	private WebElement loginBtn;
	@FindBy(xpath="//img[@src='/images/logo.gif']")
	private WebElement Logo;
	@FindBy(xpath="//a[@id='AccountLink']")
	private WebElement OnlineBankingLogin;
	@FindBy(xpath="//a[@id='LinkHeader2']")
	private WebElement Personal;
	@FindBy(xpath="//a[@id='LinkHeader3']")
	private WebElement SmallBusiness;
	@FindBy(xpath="//a[@id='LinkHeader4']")
	private WebElement InsideAltoroMutual;
	@FindBy(xpath="//span[@id='_ctl0__ctl0_Content_Main_message']")
	private WebElement LoginFailedMsg;
	
	
	
	
	
	// 2. Constructor of the page class:
		public LoginPage() {
			
			PageFactory.initElements(driver, this);
			
		}
		
   // 3. Actions :
		
	//This Method to confirm Title of the page(Optional)
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	//Validate AltoroMutual logo
	public boolean ValidateLogo() {
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Logo);
		return isImageLoaded;
	
	}
	
	//Validate ONLINE BANKING LOGIN
	public String Verify_FirstTab() {
		
		String  OnlineBankingLogin_Tab = OnlineBankingLogin.getText();
		return OnlineBankingLogin_Tab;
	
	}
	
    //Validate PERSONAL
	public String Verify_SecondTab() {
		
		String  Personal_Tab = Personal.getText();
		return Personal_Tab;
	
	}
	
	//Validate SMALL BUSINESS
	public String Verify_ThirdTab() {
		
		String  SmallBusiness_Tab = SmallBusiness.getText();
		return SmallBusiness_Tab;
	
	}
	
	//Validate INSIDE ALTORO MUTUAL
	public String Verify_ForthTab() {
		
		String  InsideAltoroMutual_Tab = InsideAltoroMutual.getText();
		return InsideAltoroMutual_Tab;
	
	}
	
	//Validate Login with incorrect username and password
		public String LoginFailedMsg(String inval_un, String Inval_pw) {
		    
			username.sendKeys(inval_un);
			Passwd.sendKeys(Inval_pw);
			loginBtn.click();
			String Login_Failed_Message = LoginFailedMsg.getText();
			return Login_Failed_Message;
	}
	
    //Login with valid username and password and user lands to Home Page	
	public HomePage login(String un, String pw)	{

		username.sendKeys(un);
		Passwd.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
		
	}
		

}
