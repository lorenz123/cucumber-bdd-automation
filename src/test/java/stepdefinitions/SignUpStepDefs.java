package stepdefinitions;

import com.bibuat.utility.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;

public class SignUpStepDefs {

    //Objects
    DriverManager manager = new DriverManager();
    WebDriver driver = manager.initializeDriver();
    WebDriverWait wait = getWebDriverWait(driver);

    @Given("I am at the Sign Up page")
    public void iAmAtTheSignUpPage() {
    }

    @When("I click the Sign Up button")
    public void iClickTheSignUpButton() {
    }

    @Then("An error message should be prompted to the user")
    public void anErrorMessageShouldBePromptedToTheUser() {
    }

    @Given("I enter a invalid {string} address and a valid {string}")
    public void iEnterAInvalidAddressAndAValid(String arg0, String arg1) {
    }
}
