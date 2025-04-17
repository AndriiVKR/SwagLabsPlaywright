package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    public static BrowserContext createBrowserContext() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        return browser.newContext();
    }

    public static void close() {
        if (playwright != null) {
            playwright.close();
        }
    }

}
