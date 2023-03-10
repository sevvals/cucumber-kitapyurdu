package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    By bookNameLocator = By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[3]/div/div/a");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfAdded() {
        return getProducts().size() > 0;
    }
    private List<WebElement> getProducts(){
        return findAll(bookNameLocator);
    }
}
