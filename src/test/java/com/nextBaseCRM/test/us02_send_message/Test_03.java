package com.nextBaseCRM.test.us02_send_message;

import com.nextBaseCRM.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_03 extends TestBase {

    @BeforeMethod
    public void setUp(){

        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys("helpdesk25@cybertekschool.com");
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("UserUser");
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();
        String  actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "(39) Portal","User is not logged in");
    }

    @Test
    public void ac_003(){

        WebElement messageButton = driver.findElement(By.id("feed-add-post-form-tab-message"));
        messageButton.click();

        WebElement linkButton = driver.findElement(By.xpath("//span[@title='Link']"));
        linkButton.click();
        WebElement linkPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Link URL']"));

        linkPlaceholder.sendKeys("https://www.google.com/");
        WebElement sameButton = driver.findElement(By.id("undefined"));
        sameButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        String actualText1 = messageBody.getText();
        String expectedText1 = "https://www.google.com/";
        Assert.assertEquals(actualText1,expectedText1,"Link is successfully attached to message");

    }

}
