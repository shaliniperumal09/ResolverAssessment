package pomclass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class HomePOM extends BaseClass{
	
	@FindBy(id = "inputEmail") WebElement Email;
	@FindBy(id = "inputPassword") WebElement password;
	@FindBy(xpath="/html/body/div/div[1]/div/form/button") WebElement signinbtn;
	@FindBy(xpath="//ul[@class='list-group']/li") List<WebElement> itemList;
	@FindBy(id="dropdownMenuButton") WebElement dropdownbtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a") List<WebElement> dropdownList;
	@FindBy(xpath="/html/body/div/div[4]/div/button[1]") WebElement btn1;
	@FindBy(xpath="/html/body/div/div[4]/div/button[2]") WebElement btn2;
	@FindBy(id="test5-button") WebElement test5btn;
	@FindBy(id="test5-alert") WebElement alertmsg;
	
	
	
	public HomePOM() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean InputEmail()
	{
		return Email.isDisplayed();
	}
	
	public boolean password()
	{
		return password.isDisplayed();
	}
	public boolean signIn()
	{
		return signinbtn.isDisplayed();
	}
	
	public void signinfunction(String email,String pwd)
	{
		Email.sendKeys(email);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	
	public int itemListcount() {
		return itemList.size();
	}
	
	public List<WebElement> itemname() {
		return itemList;
	}
	
	public String getdropdownlist()
	{
		dropdownbtn.click();
		return dropdownbtn.getText();
	}
	
	public List<WebElement> getdropdowndetails()
	{
		return dropdownList;
	}
	
	public boolean checkbtn1()
	{
		return btn1.isEnabled();
	}
	
	public boolean checkbtn2()
	{
		return btn2.isEnabled();
	}
	public boolean checkbtnfunction()
	{
		return test5btn.isEnabled();
	}
	public void alertfunction()
	{
		test5btn.click();
		
	}
	public String alertmsg()
	{
		return alertmsg.getText();
	}}
