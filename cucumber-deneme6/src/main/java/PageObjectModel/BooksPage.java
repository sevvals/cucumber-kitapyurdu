package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksPage extends BasePage {

    By bookNameLocator = new By.ByCssSelector(".pr-img-link");
    By titleLocator = By.xpath("//*[@id=\"content\"]/div/h1");

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomBook() {
        List<WebElement> products = getAllProducts();
        int randomIndex = (int)(Math.random()*products.size());
        products.get(randomIndex).click();
    }

    private List<WebElement> getAllProducts() {
        return findAll(bookNameLocator);
    }

    public boolean isOnBooksPage() {
        return isDisplayed(titleLocator);
    }
}
