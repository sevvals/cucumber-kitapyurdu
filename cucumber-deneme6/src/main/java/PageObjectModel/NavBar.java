package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {

    By navBarLocator = By.xpath("//span[contains(text(), 'Çok Satan Kitaplar')]");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void click() {
        find(navBarLocator).click();
    }
}