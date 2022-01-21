package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import entity.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends Screen {

    public SellerScreen() {
        super(By.id("android:id/content"), "Seller page");
    }

    private final ILabel sellerName = getElementFactory().getLabel(By.className("android.widget.TextView"),
            "Seller name label");
    private final ILabel sellerCityFrom = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"),
            "Seller city from label");

    private Seller sellerFromSellerScreen;

    public String getSellerName() {
        return sellerName.getText();
    }

    public String getSellerCityNameFrom() {
        return sellerCityFrom.getText();
    }

    public void setSellerFromSellerScreen(){
        sellerFromSellerScreen = new Seller();
        sellerFromSellerScreen.setCity(getSellerCityNameFrom());
        sellerFromSellerScreen.setName(getSellerName());
    }

    public Seller getSellerFromSellerScreen(){
        setSellerFromSellerScreen();
        AqualityServices.getLogger().info("Get Seller information from Seller screen");
        return sellerFromSellerScreen;
    }

}
