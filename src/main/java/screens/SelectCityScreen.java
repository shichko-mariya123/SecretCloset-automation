package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SelectCityScreen extends Screen {

    public SelectCityScreen() {
        super(By.id("android:id/content"), "City list page");
    }

    private static final String locatorTemplate = "com.zdv.secretcloset:id/%s";
    private final ITextBox cityNameInput = getElementFactory().getTextBox(By.id(String
                    .format(locatorTemplate, "etSearchTest")), "City name input field");
    private final IButton acceptButton = getElementFactory().getButton(By.id("android:id/button1"),
            "Accept button");
    private final IButton cityFromSearchResult = getElementFactory().getButton(By.id(String
                    .format(locatorTemplate, "tvCityItemName")), "City from search result");

    public void typeCityName(String cityName) {
        AqualityServices.getLogger().info("Type city  name to city name input field: " + cityName );
        cityNameInput.clearAndType(cityName);
    }

    public void acceptAlert() {
        AqualityServices.getLogger().info("Accept alert");
        acceptButton.click();
    }

    public void clickOnCityFromSearchResult(){
        AqualityServices.getLogger().info("Click on city from search result");
        cityFromSearchResult.click();
    }
}
