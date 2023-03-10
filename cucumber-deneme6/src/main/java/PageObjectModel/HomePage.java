package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

   public NavBar navBar;

    public HomePage(WebDriver driver) {
        super(driver);
        navBar = new NavBar(driver);
    }

    public NavBar navBar() {
        return this.navBar;
    }

    public void goToCart() throws InterruptedException {
        driver.findElement(By.id("sprite-cart-icon")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("js-cart")).click();
    }
}
