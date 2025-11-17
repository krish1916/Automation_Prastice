package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestBase;

public class LoginPage extends TestBase {
    By username = By.id("username");
    By password = By.id("password");
    By userRadio = By.cssSelector("input[value='user']");
    By okayBtn = By.id("okayBtn");
    By roleDropdown = By.cssSelector("select.form-control");
    By terms = By.id("terms");
    By signInBtn = By.id("signInBtn");
    By errorMsg = By.xpath("//div[@class='alert alert-danger col-md-12']");

    public void openApp() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void selectUserRadio() {
        driver.findElement(userRadio).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayBtn)).click();
    }

    public WebElement getRoleDropdown() {
        return driver.findElement(roleDropdown);
    }

    public void acceptTerms() {
        driver.findElement(terms).click();
    }

    public void signIn() {
        driver.findElement(signInBtn).click();
    }
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return driver.findElement(errorMsg).getText();
    }
}
