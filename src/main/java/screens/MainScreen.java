package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Item;
import org.openqa.selenium.By;

public class MainScreen extends BaseControlsScreen {

    public MainScreen() {
        super(By.name("SecretCloset"), "Main screen");
    }

    private final ILabel lblCity = getLabel("tvToolbarCity", "City toolbar");
    private final ILabel lblItem = getLabel("rlBanner", "Item with discount");
    private final ILabel lblItemName = getLabel("tvBrand", "Item name");
    private final ILabel lblItemPrice = getLabel("tvSumm", "Item price");
    private final ILabel lblItemActualPrise = getLabel("tvPrice", "Item actual price");
    private final ILabel lblItemDiscount = getLabel("tvDiscount", "Item discount");

    public String getToolbarCityName() {
        lblCity.state().waitForDisplayed();
        return lblCity.getText();
    }

    public void clickOnCityLabel(){
        lblCity.click();
    }

    public void selectFirstItemWithDiscount(){
        lblItem.click();
    }

    public Item getItemInfo(){
        AqualityServices.getLogger().info("Get information about item from Main Screen");
        return Item.builder()
                .name(lblItemName.getText())
                .discount(lblItemDiscount.getText())
                .originalPrise(lblItemPrice.getText())
                .actualPrise(lblItemActualPrise.getText())
                .build();
    }
}
