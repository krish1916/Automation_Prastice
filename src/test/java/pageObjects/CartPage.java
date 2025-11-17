package pageObjects;

import org.openqa.selenium.By;
import utils.TestBase;

public class CartPage extends TestBase {
    By productName = By.xpath("//h4[@class='media-heading']");
    By checkoutBtn = By.xpath("(//button[normalize-space()='Checkout'])[1]");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
