package testClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageBase.CommonAPI;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginFunctionalityTest extends CommonAPI {
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod
    public void initializePages(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void userIsNotAbleToLoginWithInvalidCredential() throws InterruptedException {
        homePage.clickOnLogin();
        loginPage.enterEmail(getEmailId());
        loginPage.enterPassword(getPassword());
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),"Error message is not visible");
    }

}
