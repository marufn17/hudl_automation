package pageBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver;
    @BeforeMethod
    public void browserSetup(@Optional ("chrome") String browserName, @Optional ("https://www.hudl.com/") String URL) {
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--start-fullscreen");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
            driver.get(URL);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public String getEmailId(){
        return ("testuser_"+ new Random().nextInt(1000)+"@hudl.com");
    }
    public String getPassword(){
        return new Faker().internet().password();
    }


}
