package com.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.flipkart.utills.ApplicationProperties;
import com.flipkart.utills.BasicUtill;

public class LoginPage extends BasicUtill {

	@FindBy(xpath = "//a[text()='Login & Signup']")
	private WebElement login_Lnk;
	@FindBy(xpath = "//input[@class='_2zrpKA']")
	static WebElement username_TxtBox;
	@FindBy(className = "_2zrpKA _3v41xv")
	static WebElement password_TxtBox;
	@FindBy(xpath = "//button[@class='vh79eN']")
	static WebElement Btn_submit;

	public void openApps() {
		openBrowser(ApplicationProperties.getProperty("browser"));
		getDriver().get(ApplicationProperties.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

	public void login() throws InterruptedException {
		String userName = ApplicationProperties.getProperty("Username");
		String password = ApplicationProperties.getProperty("Password");
		WebElement username_TxtBox = driver.findElement(By.xpath("//input[@class='_2zrpKA']"));
		username_TxtBox.sendKeys(userName);
		WebElement password_TxtBox = driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']"));
		password_TxtBox.sendKeys(password);
		WebElement submit = driver.findElement(By.xpath("//form/div[3]/button"));
		submit.click();
		Thread.sleep(3000);
		WebElement electronics_TopMenu = driver.findElement(By.xpath("(//span[@class='_1QZ6fC _3Lgyp8'])[1]"));
		String expectedValue = "Electronics";
		Assert.assertTrue(electronics_TopMenu.getText().equalsIgnoreCase(expectedValue),
				"Actual Top Menu : is : " + electronics_TopMenu.getText());
		System.out.println("To Menu : "+electronics_TopMenu.getText());
	}

}
