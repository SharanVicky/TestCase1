package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
	public LoginPojo() {
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup
	@FindBy(name="email")
	private WebElement txtUser;
	
	@FindAll({
		
		@FindBy(id="pass"),
		@FindBy(xpath="//input[@type='pass']")
	})
	private WebElement txtPass;
	
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnClick;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}
	
	
	
}
