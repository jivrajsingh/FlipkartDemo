package com.flipkart.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.flipkart.utills.BasicUtill;

public class HomePage extends BasicUtill {
	String ssPath = "flipkart/screenshot.png";

	public void logout() {

	}

	public void chooseRam() throws InterruptedException {
		Thread.sleep(2000);
		WebElement search_Box = driver.findElement(By.xpath("//input[@type='text']"));
		search_Box.sendKeys("Mobiles");
		search_Box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement checkBox = driver.findElement(By.xpath("//div[@title='4 GB']"));
		checkBox.click();
	}

	public void chooseBrand() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search_Brand = driver.findElement(By.xpath("//input[@class='_3vKPvR']"));
		search_Brand.sendKeys("Moto");
		Thread.sleep(3000);
		WebElement checkbox_Brand = driver.findElement(By.xpath("//div[text()='Motorola']"));
		Thread.sleep(2000);
		checkbox_Brand.click();
	}

	public void verifyFilteredlist() throws InterruptedException {
		Thread.sleep(2000);
		WebElement title1 = driver.findElement(By.xpath("(//div[@class='_3wU53n'])[1]"));
		Thread.sleep(1000);
		String titleText1 = title1.getText();
		titleText1.contains("Moto");
		Thread.sleep(2000);
		WebElement title2 = driver.findElement(By.xpath("(//div[@class='_3wU53n'])[2]"));
		String titleText2 = title2.getText();
		Thread.sleep(1000);
		titleText2.contains("Moto");
		Thread.sleep(2000);
		WebElement clear_All = driver.findElement(By.xpath("(//span[text()='Clear all'])[1]"));
		clear_All.click();
		Thread.sleep(2000);
		WebElement otherTitle1 = driver.findElement(By.xpath("(//div[@class='_3wU53n'])[1]"));
		String OtherText1 = otherTitle1.getText();
		OtherText1.contains("Redmi");
	}

	public void chooseMobile() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search_Box = driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(1000);
		search_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		search_Box.sendKeys("MotoG5");
		search_Box.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement title_motoG5 = driver.findElement(By.xpath("(//div[@class='_3wU53n'])[1]"));
		title_motoG5.click();

	}

	public void addToCart() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();

		for (String handle1 : handles) {
			driver.switchTo().window(handle1);
		}
		Thread.sleep(3000);
		WebElement addtoCart_Btn = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		if (addtoCart_Btn.isDisplayed()) {
			addtoCart_Btn.click();
		} else {
			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			addtoCart_Btn.click();
			System.err.println("Add To cart button not availale..");
		}
		try {
			BasicUtill.takeSnapShot(driver, ssPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeFromCart() throws InterruptedException {
		WebElement removeFromCart = driver.findElement(By.xpath("(//span[text()='Remove'])[1]"));
		removeFromCart.click();
	}

}
