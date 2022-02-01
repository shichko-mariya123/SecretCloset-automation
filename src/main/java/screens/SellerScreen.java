package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends BaseControlsScreen {

    public SellerScreen() {
        super(By.name("Member"), "Seller screen");
    }

    private final ILabel lblSellerName = getElementFactory().getLabel(By.className("android.widget.TextView"),
            "Seller name");
    private final ILabel lblSellerCityFrom = getLabel("tvItemSellerCity",  "Seller city from label");

    public Seller getSellerInfo(){
        AqualityServices.getLogger().info("Get information about Seller from Seller Screen");
        return Seller.builder()
                .name(lblSellerName.getText())
                .city(lblSellerCityFrom.getText())
                .build();
    }
}