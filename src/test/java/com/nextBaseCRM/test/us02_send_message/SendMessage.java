package com.nextBaseCRM.test.us02_send_message;

import com.nextBaseCRM.test.base.TestBase;
import com.nextBaseCRM.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SendMessage extends TestBase {


    @Test
    public void sendMessageTest()  {
        CRM_Utilities.crm_login(driver);

        //1.  Users click the MESSAGE tab
        WebElement messageBtn = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageBtn.click();

        //2.  Users write test message
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        WebElement messageBody = driver.findElement(By.cssSelector("body[style*='min-height']"));
        messageBody.sendKeys("Bye people");

        //3.  Users click the SEND button
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

        //4.  Verify the message is displayed on the feed
        WebElement messageInStream = driver.findElement(By.xpath("//div[@class='feed-post-text-block']"));

        assertEquals(messageInStream.getText(), "Bye people");

    }

    @Test
    public void cancelMessageTest() {

        CRM_Utilities.crm_login(driver);

        // 1. User click message button
        WebElement messageBtn = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageBtn.click();

        // 2. User click cancel button
        WebElement cancelBtn = driver.findElement(By.id("blog-submit-button-cancel"));
        cancelBtn.click();

    }

    @Test
    public void attachLinkTest(){

        CRM_Utilities.crm_login(driver);

        //1.  Users click the MESSAGE tab
        WebElement messageButton = driver.findElement(By.id("feed-add-post-form-tab-message"));
        messageButton.click();

        //2.  Users click the link button
        WebElement linkButton = driver.findElement(By.xpath("//span[@title='Link']"));
        linkButton.click();

        //3.  Users insert the link into the link box
        WebElement linkPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Link URL']"));
        linkPlaceholder.sendKeys("https://www.google.com/");

        //4.  Users click save button
        WebElement saveButton = driver.findElement(By.id("undefined"));
        saveButton.click();

        //5. Verify link is displayed in the feeed
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        assertTrue(messageBody.isDisplayed());

    }


}
