package com.banking.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.HomePage;
import com.banking.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init_driver();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void AltoroMutualLogoTest() {
		boolean Logo = loginPage.ValidateLogo();
			Assert.assertTrue(Logo);
		System.out.println("AltoroMutual Logo image is displaying");

	}
	
	@Test(priority=2)
	public void tabValidationTest() {
		//ONLINE BANKING LOGIN
		String Tab1 = loginPage.Verify_FirstTab();
		Assert.assertEquals(Tab1, "ONLINE BANKING LOGIN");
		System.out.println("ONLINE BANKING LOGIN Tab is displaying");
		//PERSONAL
		String Tab2 = loginPage.Verify_SecondTab();
		Assert.assertEquals(Tab2, "PERSONAL");
		System.out.println("PERSONAL Tab is displaying");
		//SMALL BUSINESS
		String Tab3 = loginPage.Verify_ThirdTab();
		Assert.assertEquals(Tab3, "SMALL BUSINESS");
		System.out.println("SMALL BUSINESS Tab is displaying");
		//INSIDE ALTORO MUTUAL
		String Tab4 = loginPage.Verify_ForthTab();
		Assert.assertEquals(Tab4, "INSIDE ALTORO MUTUAL");
		System.out.println("INSIDE ALTORO MUTUAL Tab is displaying");
		
	}
	
	@Test(priority=3)
	public void login_Failed_Msg_Test() {
		
		String Failed_Message = loginPage.LoginFailedMsg(prop.getProperty("InvalidaUsername"), prop.getProperty("Invalidpassword"));
		Assert.assertEquals(Failed_Message, "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.");
		System.out.println("Login Failed!!");
	}
	
	@Test(priority=4)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@AfterMethod
   public void tearDown() {
	   driver.quit();
   }

}
