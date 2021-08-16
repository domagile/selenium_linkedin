package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignIn() {
        clickLink("Sign in");
        return new LoginPage(driver);
    }

    private void clickLink(String linkTest) {
        driver.findElement(By.linkText(linkTest)).click();
    }

}
