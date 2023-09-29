package com.bibuat.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.LoginElements.UAT_WEBSITE_LINK;
import static com.bibuat.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;


public class LoginStepsDefs {

    private  WebDriver driver;
    private  WebDriverWait wait;

    public LoginStepsDefs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = getWebDriverWait(driver);
    }

    //Homepage Navigation
    @Given("I am at the Homepage")
    public void iAmAtTheHomepage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(UAT_WEBSITE_LINK);
        Thread.sleep(3000);
    }

    @And("Click the fcking X button")
    public void clickTheFckingXButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/span/div/div[2]/div/div[5]/div/button")).click();
        Thread.sleep(3000);
    }

    @When("I will click the Login page")
    public void iWillClickTheLoginPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/span/div/header/div[2]/div[1]/div/button[1]")).click();
        Thread.sleep(3000);
    }

    @Then("Should be at Login page and Click the Email section")
    public void shouldBeAtLoginPageAndClickTheEmailSection() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(.,'Email')]")).click();
        Thread.sleep(3000);
    }

    //Enter Valid credentials
    @Given("I enter a valid {string} address and a valid {string}")
    public void iEnterAValidAddressAndAValid(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//section[2]/div/div[2]/input")).sendKeys(password);
    }

    @And("Click the hidden eye button")
    public void clickTheHiddenEyeButton() {
        driver.findElement(By.cssSelector(".ps-is-show")).click();
    }

    @When("I will click the Login button")
    public void iWillClickTheLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(5000);
    }

    @Then("Gee-test will prompt")
    public void geeTestWillPrompt() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[3]")).isDisplayed();
        Thread.sleep(3000);
    }

    // Email with invalid password
    @Given("I enter a valid {string} address and a invalid {string}")
    public void iEnterAValidAddressAndAInvalid(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//section[2]/div/div[2]/input")).sendKeys(password);
    }

    @Then("The prompt of wrong password will show")
    public void thePromptOfWrongPasswordWillShow() {
        WebElement prompt = getElementWithPolling(wait, By.xpath("//li/div"));
        prompt.click();
    }

    @Given("I enter a Invalid {string} address and a invalid {string}")
    public void iEnterAInvalidAddressAndAInvalid(String email, String password)  {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//section[2]/div/div[2]/input")).sendKeys(password);
    }

    @Then("The prompt of non-registered email will show")
    public void thePromptOfNonRegisteredEmailWillShow() {
        WebElement prompt = getElementWithPolling(wait, By.cssSelector(".alertShowRegister .el-dialog__header"));
        prompt.click();
    }
}