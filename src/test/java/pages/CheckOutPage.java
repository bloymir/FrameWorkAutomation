package pages;


import pages.FrameWork.SeleniumPage;

import java.util.List;

public class CheckOutPage extends SeleniumPage {
    private String planesOptions = "//select[@id='cart_cart_item_attributes_plan_with_interval']";
    public CheckOutPage() {
        super(driver);
    }

    public List<String> obtenerListaDePlanes(){
         return getDropdownValues(planesOptions);
    }
}
