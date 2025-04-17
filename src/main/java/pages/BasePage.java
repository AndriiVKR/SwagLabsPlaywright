package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public String getTitle() {
        return page.title();
    }

    //Find locator method
    public Locator find(String selector) {
        return page.locator(selector);
    }

    //Click element method
    public void click(String selector) {
        page.locator(selector).click();
    }

    //Type text into input field
    public void type(String selector, String text) {
        page.locator(selector).type(text);
    }

    //Wait element method
    public void waitForElement(String selector) {
        page.locator(selector).waitFor();
    }

    //Scroll into view method
    public void scrollTo(String selector) {
        page.locator(selector).scrollIntoViewIfNeeded();
    }

    protected LoginPage openLoginPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo(baseUrl);
        return loginPage;
    }
}
