package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class PruebaFramework {
    
    PaginaPrincipal principal = new PaginaPrincipal();
    CursosPage cursos = new CursosPage();
    RecursosPage recursos = new RecursosPage();
    FundamentosDelTestingPage ftp = new FundamentosDelTestingPage();
    CheckOutPage carrito = new CheckOutPage();

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

    @Then("valido las opciones de planes del carrito")
    public void validoOpcionesPlanesCarritoCompra(){
        List<String> lista = carrito.obtenerListaDePlanes();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 11 productos", "Academia: $176 / año • 11 productos", "Free: Gratis • 1 producto");

        Assert.assertEquals(listaEsperada, lista);
    }
}
