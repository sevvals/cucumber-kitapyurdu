package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailPage extends BasePage {
    By addToCartButtonLocator = By.xpath("//*[@id=\"button-cart\"]");

    public BookDetailPage(WebDriver driver) {
        super(driver);
    }


    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public boolean isOnBookDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }
}
