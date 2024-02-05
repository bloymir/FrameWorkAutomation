package pages;

import org.openqa.selenium.WebDriver;
import pages.FrameWork.SeleniumPage;

public class RecursosPage extends SeleniumPage {

    private String automationSandbox = "//h2[contains(text(),'Automation Sandbox')]";
    public RecursosPage() {
        super(driver);
    }

    public void clickAutomationSandbox(){
        clickElement(automationSandbox);
    }
}
