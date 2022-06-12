package com.nextBaseCRM.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    public static void crm_login(WebDriver driver){


        driver.get("https://login2.nextbasecrm.com/");

        WebElement userNameBox = driver.findElement(By.name("USER_LOGIN"));
        userNameBox.sendKeys("helpdesk25@cybertekschool.com");

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("UserUser");

        driver.findElement(By.className("login-btn")).click();
    }

    public static void crm_login(WebDriver driver, String username, String password){

        driver.get("https://login2.nextbasecrm.com/");

        WebElement userNameBox = driver.findElement(By.name("USER_LOGIN"));
        userNameBox.sendKeys(username);

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(password);

        driver.findElement(By.className("login-btn")).click();


    }

}
