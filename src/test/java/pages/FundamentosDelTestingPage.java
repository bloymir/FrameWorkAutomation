package pages;

import pages.FrameWork.SeleniumPage;

public class FundamentosDelTestingPage extends SeleniumPage{

    private String introduccionAlTestingBtn = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    public FundamentosDelTestingPage(){
        super(driver);
    }

    public void verIntroduccionAlTesting(){
        clickElement(introduccionAlTestingBtn);
    }
    
}
