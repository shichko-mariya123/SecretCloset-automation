import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ItemScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;

public class CheckThatTheMainDataOfSellersAndItemIsCorrectTest extends BaseAndroidTest{

    private static final String CITY_NAME = "London";
    private SelectCityScreen selectCityScreen;
    private ItemScreen itemScreen;
    private SellerScreen sellerScreen;

    @Test
    public void checkThatSellerIsCorrectTest(){
        mainScreen.clickOnCityLabel();
        selectCityScreen = new SelectCityScreen();
        selectCityScreen.acceptAlert();
        selectCityScreen.typeCityName(CITY_NAME);
        selectCityScreen.clickOnCityFromSearchResult();
        Assert.assertEquals(CITY_NAME, mainScreen.getToolbarCityName(), "City name should be: " + CITY_NAME);
        mainScreen.selectFirstItemWithDiscount();
        itemScreen = new ItemScreen();
        Assert.assertEquals(mainScreen.getActualItemName().equals(itemScreen.getItemName()),
                "The item should has the same name");
        Assert.assertEquals(mainScreen.getItemFromMainScreen(), itemScreen.getItemFromItemScreen(),
                "Items should be the same");
        itemScreen.clickOnSeller();
        sellerScreen = new SellerScreen();
        Assert.assertEquals(itemScreen.getSellerFromItemScreen(), sellerScreen.getSellerFromSellerScreen(),
                "Sellers should be the same");
    }
}
