package pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

public class HomePage extends BasePage{

    // Constructor
    public HomePage(Page page) {
        super(page);
    }

    // Locators
    private final String welcomeBanner = "#welcome-banner";  // Sample element
    private final String logoutButton = "text=Logout";
    private final String userProfileIcon = ".user-icon";

    // Page Actions
    public boolean isWelcomeBannerVisible() {
        return page.isVisible(welcomeBanner);
    }

    public String getPageTitle() {
        return page.title();
    }

    public void clickLogout() {
        page.click(logoutButton);
    }

    public boolean isUserIconVisible() {
        return page.isVisible(userProfileIcon);
    }

}
