package stepDefinition;

import PageObjectModel.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logintest_steps {
    WebDriver driver;
    HomePage homePage;
    @Given("navigate to website")
    public void navigate_to_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("click login")
    public void click_login() {
        homePage = new HomePage(driver);
        homePage.find(new By.ByCssSelector(".menu-top-button.login")).click();
    }
    @Given("enter email {string}")
    public void enter_email(String email) {
        homePage.find(By.xpath("//*[@id=\"login-email\"]")).sendKeys(email);
    }
    @Given("enter password {string}")
    public void enter_password(String password) {
        homePage.find(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
    }
    @When("click login button")
    public void click_login_button() {
        homePage.find(By.xpath("/html/body/div[5]/div/div/div/div/div[2]/div/form/div[5]/button")).click();
    }
    @Then("check if login is successful")
    public void check_if_login_is_successful() {
        
    }

}
