package pages;

import pages.FrameWork.SeleniumPage;

public class PaginaPrincipal extends SeleniumPage {

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirPlanBtn = "//a[contains(text(), 'Elegir Plan')]";

    public PaginaPrincipal() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.freerangetesters.com/");
    }

    public void navigateSection(String section){
        //Reemplazar el marcado de posicion
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }
    public void clicEnElegirPlan(){
        clickElement(elegirPlanBtn);
    }
    
}
