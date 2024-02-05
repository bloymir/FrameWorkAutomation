package pages.FrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumPage {
    
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public SeleniumPage(WebDriver driver){
        SeleniumPage.driver = driver;
    }

    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }     
    }

    public static void maxBrowser(){
        driver.manage().window().maximize();
    }
    protected static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected void clickElement(String locator){
        Find(locator).click();
    }

    protected void write(String locator, String keyToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keyToSend);
    }

    protected void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.deselectByValue(value);
    }

    protected void selectFromDropdownByIndex(String locator, int index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    protected int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }
}
