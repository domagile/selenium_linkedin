import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    private WebDriver driver;

    protected WebDriver getWebDriver()
    {
        return driver;
    }

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\app\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
    }

    @BeforeEach
    public void goHome() {
        driver.get("https://www.linkedin.com");
    }


    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
