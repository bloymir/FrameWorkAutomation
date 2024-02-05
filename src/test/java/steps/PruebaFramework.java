package steps;

import io.cucumber.java.en.*;
import pages.CursosPage;
import pages.FundamentosDelTestingPage;
import pages.PaginaPrincipal;
import pages.RecursosPage;

public class PruebaFramework {
    
    PaginaPrincipal principal = new PaginaPrincipal();
    CursosPage cursos = new CursosPage();
    RecursosPage recursos = new RecursosPage();
    FundamentosDelTestingPage ftp = new FundamentosDelTestingPage();

    @Given("navego a www.freerangetester.com")
    public void navegoAGoogle(){
        principal.navigateToGoogle();
    }

    @When("hago clic en la seccion {word}")
    public void navegarASeccion(String section){
        principal.navigateSection(section);
    }

    @And("hago clic en ver mas, del curso introduccion al testing")
    public void irAlCursoFundamentos(){
        cursos.clickEnFundamentosTestingLink();
        ftp.verIntroduccionAlTesting();
    }
    @And("hago clic en el link de sandbox")
    public void irAlSandbox(){
        recursos.clickAutomationSandbox();
    }

    @When("hago clic en el boton Elegir Plan")
    public void hagoClicEnElBotonElegirPlan(){
        principal.clicEnElegirPlan();
    }
}
