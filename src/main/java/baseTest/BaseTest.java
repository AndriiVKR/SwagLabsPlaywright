package baseTest;

import com.microsoft.playwright.*;
import config.PlaywrightFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import config.ConfigLoader;
import pages.LoginPage;

public class BaseTest {

    // Define the Playwright instance and Page variables
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    // Config values
    protected String baseUrl;
    protected String validUsername;
    protected String validPassword;
    protected String invalidUsername;
    protected String invalidPassword;

    @BeforeEach
    public void setUp() {
        //Load config values
        baseUrl = ConfigLoader.get("base.url");
        validUsername = ConfigLoader.get("username.valid");
        validPassword = ConfigLoader.get("password.valid");
        invalidUsername = ConfigLoader.get("username.invalid");
        invalidPassword = ConfigLoader.get("password.invalid");
        // Set up Playwright and browser
        playwright = Playwright.create();
        boolean headless = ConfigLoader.getBoolean("browser.headless");
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = context.newPage();
    }

    protected LoginPage openLoginPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo(baseUrl);
        return loginPage;
    }

    @AfterEach
    public void tearDown() {
        // Close context and Playwright instance
        if (context != null) {
            context.close();
        }
        browser.close();
        PlaywrightFactory.close();
    }

}
