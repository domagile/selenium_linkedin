package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyNetworkPage {
    private WebDriver driver;
    private By showMoreButton = By.xpath("//*[text()= 'Show more']");
    private By pagesSection = By.xpath("//li[div/*[text()='Recommended pages for you' " +
            "or contains(.,'Because you recently followed')" +
            "or text()='Trending pages in your network']]");
    private By followButton = By.xpath(".//*[text()='Follow']");
    private By pageName = By.xpath("//span[contains(@class,'discover-company-card__name')]");


    public MyNetworkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickShowMoreButton() {
        driver.findElement(showMoreButton).click();
    }


    public String followPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pagesSection));
        WebElement pagesSectionElement = driver.findElement(pagesSection);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(followButton));
        pagesSectionElement.findElement(followButton).click();
        return pagesSectionElement.findElement(pageName).getText();
    }


    private void clickNetworkSectionLink(String linkText) {
        By linkLocator = By.xpath("//a[div/div[text()='" + linkText + "']]");
        driver.findElement(linkLocator).click();
    }


    public PagesPage clickPagesPage(){
        clickNetworkSectionLink("Pages");
        return new PagesPage(driver);
    }
}