package com.bibuat.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThinkingTimeUtil {

    public static final Integer WAITING_TIME = 40;

    public static final Integer POLLING_TIME = 1;
    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {
        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
    }
}
