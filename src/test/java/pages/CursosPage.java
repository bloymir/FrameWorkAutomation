package pages;

import org.openqa.selenium.WebDriver;

import pages.FrameWork.SeleniumPage;

public class CursosPage extends SeleniumPage{

    private String fundamentosTesingLink = "//a[@href='/fundamentos-del-testing'][normalize-space()='Ver cursos']";

    public CursosPage() {
        super(driver);
    }
    
    public void clickEnFundamentosTestingLink(){
        clickElement(fundamentosTesingLink);
    }
}
