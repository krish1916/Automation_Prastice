package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestBase;

import java.util.List;

public class HomePage extends TestBase {
    By productCards = By.cssSelector(".card-body");
    By cartButton = By.cssSelector(".nav-link.btn.btn-primary");
   //By addButton=By.xpath("(//button[contains(text(),'Add')])");

    public void addProductToCart(String productName) throws InterruptedException {

        List<WebElement> items = driver.findElements(productCards);
        //Thread.sleep(5000);


        items.stream()
                .filter(card -> card.findElement(By.cssSelector(".card-title"))
                        .getText().contains(productName))
                .findFirst()
                .ifPresent(card ->
                        card.findElement(By.xpath("(//button[contains(text(),'Add')])")).click()
                );
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }
}
