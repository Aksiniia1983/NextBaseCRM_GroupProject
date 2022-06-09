package com.nextBaseCRM.test.us02_send_message;

import com.nextBaseCRM.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_01_SendMessage extends TestBase {


    @Test
    public void testSendMessage() {
        driver.get("https://login2.nextbasecrm.com/auth/");

        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("hr40@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();


        WebElement homeBtn = driver.findElement(By.xpath("//span[.='CRM']"));
        homeBtn.click();

        WebElement messageBtn = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageBtn.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));

        driver.switchTo().frame(iframe);

        WebElement messageBody = driver.findElement(By.xpath("//body[@style='min-height: 117px;']"));
        messageBody.sendKeys("Java is fun");

        driver.switchTo().defaultContent();

        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

    }

}
