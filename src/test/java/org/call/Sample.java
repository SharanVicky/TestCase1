package org.call;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.BaseClass;
import org.test.LoginPojo;
import org.testing.SampleData;

public class Sample extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		launchBrowser();
		launchUrl("https://www.facebook.com/");
		pageMax();
		LoginPojo l = new LoginPojo();
		fill(l.getTxtUser(), getData(1, 1));
		fill(l.getTxtPass(), getData(1, 2));
		Thread.sleep(2000);
		btnClick(l.getBtnClick());
		
		
	}

}
