import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.SleepUtil.sleep;

public class AddPageTest extends BaseTest {
    @Test
    public void addPage() {
        LoginPage loginPage = new HomePage(getWebDriver()).clickSignIn();
        UserHomePage userHomePage = loginPage.signIn();

        MyNetworkPage networkPage = userHomePage.clickMyNetwork();
        String pageName = networkPage.followPage();
        //let linkedin to update data
        sleep(3000);
        networkPage.clickShowMoreButton();
        PagesPage pagesPage = networkPage.clickPagesPage();
        boolean isPageFollowed = pagesPage.isPageFollowed(pageName);
        if (isPageFollowed) {
            pagesPage.unfollowPage(pageName);
        }

        assertTrue(isPageFollowed, "Page is not followed");
    }
}
