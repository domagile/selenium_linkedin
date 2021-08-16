package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SleepUtil.sleep;

public class PagesPage {
    private WebDriver driver;


    public PagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageFollowed(String pageName) {
        sleep(1000);
        By pageNameLocator = By.xpath("//h3[contains(@class,'follows-recommendation-card__name')][text()='" + pageName + "']");
        return !driver.findElements(pageNameLocator).isEmpty();
    }

    public void unfollowPage(String pageName) {
        By unfollowPageButtonLocator = By.xpath("//button[contains(@aria-label, '" + pageName + "')]");
        driver.findElement(unfollowPageButtonLocator).click();
    }
}
