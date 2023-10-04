package stepdefinitions.common;

import com.bibuat.consts.ElementType;
import com.bibuat.utility.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.LoginElements.UAT_WEBSITE_LINK;
import static com.bibuat.utility.ThinkingTimeUtil.*;

public class CommonStepDefs {

    //Objects
    DriverManager manager = new DriverManager();
    WebDriver driver = manager.initializeDriver();
    WebDriverWait wait = getWebDriverWait(driver);

    //paths
    private static final String X_BTN = "/html/body/div[1]/div/span/div/div[2]/div/div[5]/div/button";
    private static final String NAVIGATION_LOGIN_BTN = "/html/body/div[1]/div/span/div/header/div[2]/div[1]/div/button[1]";
    private static final String LOGIN_EMAIL_SECTION = "//span[contains(.,'Email')]";

    @Given("I am at the Homepage")
    public void iAmAtTheHomepage() {
        manager.openPage(UAT_WEBSITE_LINK);
    }

    @And("Click the X button")
    public void clickTheXButton() {
        WebElement closeBtn = getElementWithPolling(wait, getBy(X_BTN, ElementType.X_PATH));
        closeBtn.click();
    }

    @When("I will click the Login page")
    public void iWillClickTheLoginPage() {
        WebElement navLoginBtn = getElementWithPolling(wait, getBy(NAVIGATION_LOGIN_BTN, ElementType.X_PATH));
        navLoginBtn.click();
    }

    @Then("Should be at Login page and Click the Email section")
    public void shouldBeAtLoginPageAndClickTheEmailSection() {
        WebElement emailSection = getElementWithPolling(wait, getBy(LOGIN_EMAIL_SECTION, ElementType.X_PATH));
        emailSection.click();
    }
}
