package com.nextBaseCRM.test.us02_send_message;

import com.nextBaseCRM.test.base.TestBase;
import com.nextBaseCRM.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_01_SendMessage extends TestBase {

    @BeforeMethod
    public void setUpMethod(){
        CRM_Utilities.crm_login(driver);
    }

    @Test
    public void testSendMessage()  {

        //1.  Users click the MESSAGE tab
        WebElement messageBtn = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageBtn.click();

        //2.  Users write test message
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        WebElement messageBody = driver.findElement(By.cssSelector("body[style*='min-height']"));
        messageBody.sendKeys("Good morning");

        //3.  Users click the SEND button
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

        //4.  Verify the message is displayed on the feed
        WebElement messageInStream = driver.findElement(By.xpath("//div[@class='feed-post-text-block']"));
        //assertTrue(messageInStream.isDisplayed());
        assertEquals(messageInStream.getText(), "Good morning");

    }

}
