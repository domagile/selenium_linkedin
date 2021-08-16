package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHomePage {
   private WebDriver driver;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }


    public MyNetworkPage clickMyNetwork()
    {
        clickLink("My Network");
        return new MyNetworkPage(driver);
    }
}
