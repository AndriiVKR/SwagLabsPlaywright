package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.*;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Epic("Authentication")
    @Feature("Login Functionality")
    @Story("User Login - Basic Validation")

//    @Test
//    public void testValidLogin() {
//        LoginPage loginPage = new LoginPage(page);
//        loginPage.navigateTo(baseUrl);
//        loginPage.login(validUsername, validPassword);
//        assertTrue(loginPage.isLoginSuccessful(), "User should be logged in. ");
//    }

    @Epic("Login Feature")
    @Feature("User Authentication")
    @Story("Valid login with standard_user")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("MyName")
    @Description("This test verifies login with valid credentials.")
    @Test
    public void testValidLogin() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(validUsername, validPassword);
        assertTrue(loginPage.isLoginSuccessful(), "Login should succeed with valid credentials.");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that the user should not be able to login with invalid Username and valid Password")
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(invalidUsername, validPassword);
        assertFalse(loginPage.isLoginSuccessful(), "Login should fail with wrong username");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user should not be able to login with invalid Password and valid Username")
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(validUsername, invalidPassword);
        assertFalse(loginPage.isLoginSuccessful(), "Login should fail with wrong password");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login fails when username is empty")
    public void loginWithEmptyUsername() {
        LoginPage loginPage = openLoginPage();
        loginPage.login("", validPassword);
        assertFalse(loginPage.isLoginSuccessful(), "Login should fail with empty username");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login fails when password is empty")
    public void loginWithEmptyPassword() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(validUsername, "");
        assertFalse(loginPage.isLoginSuccessful(), "Login should fail with empty password");
    }



}
