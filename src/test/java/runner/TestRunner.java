package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.FrameWork.SeleniumPage;

@RunWith(Cucumber.class) 
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps",
    plugin = { "pretty", "html:target/cucumber-reports" }, 
    tags = "@MembreciaTest"
)
public class TestRunner {


    @BeforeClass
    public static void initNavigate(){
        SeleniumPage.maxBrowser();
    }
  /*  @AfterClass
    public static void cleanDriver(){
        SeleniumPage.closeBrowser();
    }*/
}
