package stepdefinitions;

import com.bibuat.consts.ElementType;
import com.bibuat.utility.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.utility.ThinkingTimeUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginStepsDefs {

    //Objects
    DriverManager manager = new DriverManager();
    WebDriver driver = manager.initializeDriver();
    WebDriverWait wait = getWebDriverWait(driver);

    //paths
    private static final String EMAIL = "email";
    private static final String PASSWORD = "//section[2]/div/div[2]/input";
    private static final String PASSWORD_EYE_BTN = ".ps-is-show";
    private static final String LOGIN_BTN = "login-btn";
    private static final String GEETEST_PROMPT = "/html/body/div[5]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[3]";
    private static final String WRONG_PASSWORD_PROMPT = "//li/div";
    private static final String REGISTER_ERROR_MESSAGE = ".alertShowRegister .el-dialog__header";

    @Given("I enter a {string} address and a {string}")
    public void iEnterAAddressAndA(String email, String password) {
        WebElement emailField = getElementWithPolling(wait, getBy(EMAIL, ElementType.NAME));
        emailField.sendKeys(email);
        WebElement passwordField = getElementWithPolling(wait, getBy(PASSWORD, ElementType.X_PATH));
        passwordField.sendKeys(password);
    }

    @And("Click the hidden eye button")
    public void clickTheHiddenEyeButton() {
        WebElement hideBtn = getElementWithPolling(wait, getBy(PASSWORD_EYE_BTN, ElementType.CSS_SELECTOR));
        hideBtn.click();
    }

    @When("I will click the Login button")
    public void iWillClickTheLoginButton() {
        WebElement hideBtn = getElementWithPolling(wait, getBy(LOGIN_BTN, ElementType.ID));
        hideBtn.click();
    }

    @Test
    @Then("Gee-test will prompt")
    public void geeTestWillPrompt() {
        WebElement geeTestPrompt = getElementWithPolling(wait, getBy(GEETEST_PROMPT, ElementType.X_PATH));
        assertTrue(geeTestPrompt.isDisplayed());
    }


    @Then("The prompt of wrong password will show")
    public void thePromptOfWrongPasswordWillShow() {
        WebElement prompt = getElementWithPolling(wait, getBy(WRONG_PASSWORD_PROMPT, ElementType.X_PATH));
        assertTrue(prompt.isDisplayed());
    }


    @Then("The prompt of non-registered email will show")
    public void thePromptOfNonRegisteredEmailWillShow() {
        WebElement prompt = getElementWithPolling(wait, getBy(REGISTER_ERROR_MESSAGE, ElementType.CSS_SELECTOR));
        assertTrue(prompt.isDisplayed());
    }

    @And("I quit the Driver")
    public void iQuitTheDriver() {
        manager.tearDown();
    }

}