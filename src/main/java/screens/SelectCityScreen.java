package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class SelectCityScreen extends BaseControlsScreen {

    public SelectCityScreen() {
        super(By.name("Select city"), "Select city screen");
    }

    private final ITextBox txtCityName = getTextBox("etSearchTest", "City name input");
    private final IButton btnAccept = getElementFactory().getButton(By.id("android:id/button1"),
            "Accept button");
    private final ILabel lblResultCity = getLabel("tvCityItemName", "City from search result");

    public void typeCityName(String cityName) {
        txtCityName.clearAndType(cityName);
    }

    public void acceptAlert() {
        AqualityServices.getLogger().info("Accept alert");
        btnAccept.click();
    }

    public void clickOnCityFromSearchResult(){
        lblResultCity.click();
    }
}
