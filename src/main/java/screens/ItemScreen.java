package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import entity.Item;
import entity.Seller;
import org.openqa.selenium.By;

public class ItemScreen extends Screen {

    public ItemScreen() {
        super(By.id("android:id/content"), "Item page");
    }

    private static final String locatorTemplate = "com.zdv.secretcloset:id/%s";
    private final ILabel itemName = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvItemBrand")),
            "Item name label");
    private final ILabel originalItemPrise = getElementFactory().getLabel(By.id(String
            .format(locatorTemplate, "tvItemOriginalPrice")), "Original item prise label");
    private final ILabel itemDiscount = getElementFactory().getLabel(By.id(String
            .format(locatorTemplate, "tvItemDiscount")), "Item discount");
    private final ILabel itemPrice = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvItemPrice")),
            "Item price");
    private final ILabel sellerName = getElementFactory().getLabel(By.id(String
            .format(locatorTemplate, "tvItemSellerName")), "Seller name");
    private final ILabel sellerCityFrom = getElementFactory().getLabel(By.id(String
            .format(locatorTemplate, "tvItemSellerCity")), "Seller city from");

    private Item itemFromItemScreen;
    private Seller sellerFromItemScreen;

    public String getItemName() {
        return itemName.getText();
    }

    public String getOriginalItemPrise() {
        return originalItemPrise.getText();
    }

    public String getItemDiscount() {
        return itemDiscount.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getSellerName() {
        return sellerName.getText();
    }

    public String getSellerCityNameFrom() {
        return sellerCityFrom.getText();
    }

    public void clickOnSeller() {
        AqualityServices.getLogger().info("Click on seller of item");
        sellerName.click();
    }

    public void setItemFromItemScreen(){
        itemFromItemScreen = new Item();
        itemFromItemScreen.setName(getItemName());
        itemFromItemScreen.setActualPrise(getItemPrice());
        itemFromItemScreen.setDiscount(getItemDiscount());
        itemFromItemScreen.setOriginalPrise(getOriginalItemPrise());
    }

    public Item getItemFromItemScreen(){
        AqualityServices.getLogger().info("Get Item information from Item screen");
        setItemFromItemScreen();
        return itemFromItemScreen;
    }

    public void setSellerFromItemScreen(){
        sellerFromItemScreen = new Seller();
        sellerFromItemScreen.setName(getSellerName());
        sellerFromItemScreen.setCity(getSellerCityNameFrom());
    }

    public Seller getSellerFromItemScreen(){
        AqualityServices.getLogger().info("Get Seller information from item screen");
        setSellerFromItemScreen();
        return sellerFromItemScreen;
    }
}
