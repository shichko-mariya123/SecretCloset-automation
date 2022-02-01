package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Item;
import models.Seller;
import org.openqa.selenium.By;

public class ItemScreen extends BaseControlsScreen {

    public ItemScreen() {
        super(By.name("Buy"), "Item screen");
    }

    private final ILabel lblItemName = getLabel("tvItemBrand", "Item name");
    private final ILabel lblOriginalItemPrise = getLabel("tvItemOriginalPrice", "Original item prise");
    private final ILabel lblItemDiscount = getLabel("tvItemDiscount", "Item discount");
    private final ILabel lblItemPrice = getLabel("tvItemPrice", "Item price");
    private final ILabel lblSellerName = getLabel("tvItemSellerName", "Seller name");
    private final ILabel lblSellerCityFrom = getLabel("tvItemSellerCity", "Seller city from");

    public void clickOnSeller() {
        lblSellerName.click();
    }

    public String getItemName(){
        return lblItemName.getText();
    }

    public Item getItemInfo(){
        AqualityServices.getLogger().info("Get information about item from Item Screen");
        return Item.builder()
                .name(getItemName())
                .discount(lblItemDiscount.getText())
                .originalPrise(lblOriginalItemPrise.getText())
                .actualPrise(lblItemPrice.getText())
                .build();
    }

    public Seller getSellerInfo(){
        AqualityServices.getLogger().info("Get information about seller from Item Screen");
        return Seller.builder()
                .name(lblSellerName.getText())
                .city(lblSellerCityFrom.getText())
                .build();
    }
}
