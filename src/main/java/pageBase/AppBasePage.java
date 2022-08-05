package pageBase;

import org.openqa.selenium.WebElement;

public class AppBasePage {
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void sendKeyToEelement(WebElement element, String input){
        element.sendKeys(input);
    }
}
