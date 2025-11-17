package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestBase;

import java.util.List;

public class CheckOutPage extends TestBase {
    By countryBox = By.id("country");
    By suggestionList = By.cssSelector(".suggestions li");
    By purchaseBtn = By.xpath("//input[@value='Purchase']");
    By successMsg = By.cssSelector(".alert.alert-success.alert-dismissible");

    public void enterCountry(String country) {
        driver.findElement(countryBox).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionList));
    }

    public void selectCountry(String requiredCountry) {

        List<WebElement> options = driver.findElements(suggestionList);

        options.stream()
                .filter(opt -> opt.getText().equalsIgnoreCase(requiredCountry))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
