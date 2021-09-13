package com.banking.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.banking.qa.base.TestBase;

public class AccountInformationpage extends TestBase {

    // 1. Page Factory - Object Repository :
    @FindBy(xpath = "//a [@id='MenuHyperLink1']")
    private WebElement accSummaryLink;

    @FindBy(xpath = "//select[@id='listAccounts']")
    private WebElement account_dropdown;

    @FindBy(xpath = "//input[@id='btnGetAccount']")
    private WebElement go_button;

    @FindBy(xpath = "//*[@id='btnGetAccount']")
    private WebElement sel_Acct;

    @FindBy(xpath = "//a[@id='LoginLink']//font[text()='Sign Off']")
    private WebElement signOffLink;


    // 2. Constructor of the page class:
    public AccountInformationpage() {

        PageFactory.initElements(driver, this);

    }


    // 3. Actions
    //Validate Debit Entry in Debits-Table
    public String debitEntry(String un, String pw) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(un, pw);
        accSummaryLink.click();
        Select VAD_dropdown = new Select(account_dropdown);
        VAD_dropdown.selectByValue(prop.getProperty("Bank_Account"));
        go_button.click();

        String beforeXpath = "//*[@id='debits']/table/tbody/tr[";
        String afterXpath = "]/td[4]";
        List < WebElement > rows = driver.findElements(By.xpath("//*[@id='debits']/table/tbody/tr"));
        int rowcount = rows.size();
        String actualXpath = beforeXpath + rowcount + afterXpath;
        WebElement Lastrow = driver.findElement(By.xpath(actualXpath));
        String LastrowValue = Lastrow.getText();

        return LastrowValue;
    }

    //Validate Credit Entry in Credits-Table
    public String creditEntry() {

        Select VAD_dropdown = new Select(account_dropdown);
        VAD_dropdown.selectByValue(prop.getProperty("Bank_Account1"));
        sel_Acct.click();

        String beforeXpath = "//*[@id=\"credits\"]/table/tbody/tr[";
        String afterXpath = "]/td[4]";
        List < WebElement > rows = driver.findElements(By.xpath("//*[@id=\"credits\"]/table/tbody/tr"));
        int rowcount = rows.size();
        String actualXpath = beforeXpath + rowcount + afterXpath;
        WebElement Lastrow = driver.findElement(By.xpath(actualXpath));
        String LastrowValue = Lastrow.getText();

        return LastrowValue;

    }

    //Clicking on Sign-Off Link
    public void signOff() {

        signOffLink.click();

    }


}