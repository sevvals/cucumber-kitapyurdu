package stepDefinition;

import PageObjectModel.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class mytest_steps{

    HomePage homePage;
    BooksPage booksPage;
    BookDetailPage bookDetailPage;
    CartPage cartPage;
    public static WebDriver driver;

    @Given("^go to website$")
    public void go_to_website() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^click best seller$")
    public void click_best_seller() throws Throwable {
        homePage = new HomePage(driver);
        homePage.navBar.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[1]/div/div[1]/div[1]/ul[1]/li[1]/a")));
    }

    @Given("^click on best seller literature books$")
    public void click_on_best_seller_literature_books() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[1]/div/div[1]/div[1]/ul[1]/li[1]/a")).click();
        booksPage = new BooksPage(driver);
    }

    @Given("^select a random book$")
    public void select_a_random_book() throws Throwable {
        booksPage.selectRandomBook();
        bookDetailPage = new BookDetailPage(driver);
    }

    @Given("^add book to cart$")
    public void add_book_to_cart() throws Throwable {
        bookDetailPage.addToCart();
        Thread.sleep(2000);
    }

    @When("^go to cart$")
    public void go_to_cart() throws Throwable {
        homePage.goToCart();
        Thread.sleep(2000);
    }

    @Then("^check if the book is added to cart$")
    public void check_if_the_book_is_added_to_cart() throws Throwable {
        cartPage = new CartPage(driver);
        Thread.sleep(2000);

        if (cartPage.checkIfAdded()) {
            System.out.println("Added to cart!");
        } else {
            System.out.println("Not added to cart!");
        }
    }
    @AfterAll
    public static void afterAll(){
        if (driver != null) {
            driver.quit();
        }
    }
}