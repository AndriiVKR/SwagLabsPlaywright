package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage{

    private String usernameField = "#user-name";
    private String passwordField = "#password";
    private String loginButton = "#login-button";
    private String errorMessage = "[data-test='error']";

    public LoginPage(Page page) {
        super(page);
    }

    // Navigate to url
    public void navigateTo(String url) {
        page.navigate(url);
    }

    public void login(String username, String password) {
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return page.url().contains("inventory");
    }

    public String getErrorMessage() {
        return page.locator(errorMessage).textContent();
    }
}
