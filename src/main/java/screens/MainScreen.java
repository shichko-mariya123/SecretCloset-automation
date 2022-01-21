package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import entity.Item;
import org.openqa.selenium.By;

public class MainScreen extends Screen {

    public MainScreen() {
        super(By.id("android:id/content"), "Main application screen");
    }

    private static final String locatorTemplate = "com.zdv.secretcloset:id/%s";
    private final ILabel cityLabel = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvToolbarCity")),
            "City toolbar label");
    private final ILabel firstItemWithDiscount = getElementFactory().getLabel(By.id(String
            .format(locatorTemplate, "rlBanner")), "First Item with discount");
    private final ILabel itemName = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvBrand")),
            "Item name");
    private final ILabel itemPrice = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvSumm")),
            "Item price");
    private final ILabel itemActualPrise = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvPrice")),
            "Item actual price");
    private final ILabel itemDiscount = getElementFactory().getLabel(By.id(String.format(locatorTemplate, "tvDiscount")),
            "Item discount");

    private static Item itemFromMainScreen;

    public String getToolbarCityName() {
        AqualityServices.getLogger().info("Get toolbar city name");
        cityLabel.state().waitForDisplayed();
        return cityLabel.getText();
    }

    public void clickOnCityLabel(){
        AqualityServices.getLogger().info("Click on city label");
        cityLabel.click();
    }

    public String getNameOfItem() {
        return itemName.getText();
    }

    public String getPriceOfItem() {
        return itemPrice.getText();
    }

    public String getActualPriceOfItem() {
        return itemActualPrise.getText();
    }

    public String getDiscountOfItem() {
        return itemDiscount.getText();
    }

    public void setFirstItemWithDiscount(){
        itemFromMainScreen = new Item();
        itemFromMainScreen.setName(this.getNameOfItem());
        itemFromMainScreen.setDiscount(this.getDiscountOfItem());
        itemFromMainScreen.setOriginalPrise(this.getPriceOfItem());
        itemFromMainScreen.setActualPrise(this.getActualPriceOfItem());
    }

    public String getActualItemName(){
        return itemFromMainScreen.getName();
    }

    public void selectFirstItemWithDiscount(){
        AqualityServices.getLogger().info("Select first item with discount");
        this.setFirstItemWithDiscount();
        firstItemWithDiscount.click();
    }

    public Item getItemFromMainScreen(){
        AqualityServices.getLogger().info("Get item information from main screen");
        return itemFromMainScreen;
    }

}
