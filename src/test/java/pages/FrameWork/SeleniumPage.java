package pages.FrameWork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumPage {
    
    protected static WebDriver driver;
    private static Actions actions;
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

    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> valores = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            valores.add(option.getText());
        }
        return valores;
    }

    protected void hoverOverElement(String locator){
        actions.moveToElement(Find(locator));
    }

    protected void doubleClick(String locator){
        actions.doubleClick(Find(locator));
    }

    protected void rightClick(String locator){
        actions.contextClick(Find(locator));
    }

    protected String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return  Find(cellINeed).getText();
    }

    protected void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"table/tbody/tr["+row+"]td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
