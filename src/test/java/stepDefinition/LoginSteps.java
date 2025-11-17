package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.TestBase;

public class LoginSteps extends TestBase {
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    CartPage cart = new CartPage();
    CheckOutPage checkout = new CheckOutPage();

    @Given("User launches the application")
    public void user_launches_the_application() {
        initializeDriver();
        login.openApp();
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in(String user, String pass) {
        login.enterUsername(user);
        login.enterPassword(pass);
    }

    @When("User selects User role and clicks okay")
    public void user_selects_user_role() {
        login.selectUserRadio();
    }

    @When("User selects {string} from dropdown")
    public void user_selects_from_dropdown(String role) {
        Select s = new Select(login.getRoleDropdown());
        s.selectByVisibleText(role);
    }

    @When("User accepts terms and logs in")
    public void user_accepts_terms_and_logs_in() {
        login.acceptTerms();
        login.signIn();
    }

    @When("User adds {string} to cart")
    public void user_adds_to_cart(String product) throws InterruptedException {
        home.addProductToCart(product);
    }

    @When("User proceeds to cart")
    public void user_proceeds_to_cart() {
        home.openCart();
    }

    @Then("The product {string} should be present in cart")
    public void verify_product_in_cart(String product) {
        Assert.assertEquals(cart.getProductName(), product);
    }

    @When("User checks out the product")
    public void user_checks_out_product() {
        cart.clickCheckout();
    }

    @When("User selects country {string}")
    public void user_selects_country(String country) {
        checkout.enterCountry("ind");
        checkout.selectCountry(country);
        checkout.clickPurchase();
    }

    @Then("Order should be successfully placed")
    public void order_should_be_successful() {
        System.out.println(checkout.getSuccessMessage());
        //driver.quit();
    }
    @Then("An error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMsg) {
        String actualMsg = login.getErrorMessage();
        System.out.println("Actual Error: " + actualMsg);
        Assert.assertTrue(actualMsg.contains(expectedMsg),
                "Expected error message not found!");
        driver.quit();
    }


}
