package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageBase.AppBasePage;

public class LoginPage extends AppBasePage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "logIn")
    private WebElement loginButton;
    @FindBy(xpath = "//p[@data-qa-id=\"error-display\"]")
    private WebElement notRecognizeErrorMessage;

    public void enterEmail(String emailInput){
        sendKeyToEelement(email,emailInput);
    }
    public void enterPassword(String passwordInput){
        sendKeyToEelement(password, passwordInput);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public boolean isDisplayedErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        return wait.until(ExpectedConditions.visibilityOf(notRecognizeErrorMessage)).isDisplayed();
    }

}
