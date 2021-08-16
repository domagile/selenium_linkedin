package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text() ='Sign in']");
    public String email = "some@gmail.com";
    public String password = "somepath";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePage signIn() {
        driver.findElement(usernameField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new UserHomePage(driver);
    }


}
