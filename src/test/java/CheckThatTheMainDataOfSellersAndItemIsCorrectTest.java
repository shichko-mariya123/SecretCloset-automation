import models.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ItemScreen;
import screens.MainScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;
import testDataUtil.TestDataManager;

public class CheckThatTheMainDataOfSellersAndItemIsCorrectTest extends BaseAndroidTest {

    private static final String CITY_NAME = TestDataManager.getTestData().getValue("/city").toString();
    private MainScreen mainScreen = new MainScreen();
    private SelectCityScreen selectCityScreen = new SelectCityScreen();
    private ItemScreen itemScreen = new ItemScreen();
    private SellerScreen sellerScreen = new SellerScreen();
    private Item item;

    @Test
    public void checkThatSellerIsCorrectTest(){
        mainScreen.clickOnCityLabel();
        selectCityScreen.acceptAlert();
        selectCityScreen.typeCityName(CITY_NAME);
        selectCityScreen.clickOnCityFromSearchResult();
        Assert.assertEquals(CITY_NAME, mainScreen.getToolbarCityName(), "City name should be: " + CITY_NAME);
        item = mainScreen.getItemInfo();
        mainScreen.selectFirstItemWithDiscount();
        Assert.assertEquals(item.getName().equals(itemScreen.getItemName()),
                "Item should be displayed on screen");
        Assert.assertEquals(item, itemScreen.getItemInfo(),
                "Items should be the same");
        itemScreen.clickOnSeller();
        Assert.assertEquals(itemScreen.getSellerInfo(), sellerScreen.getSellerInfo(),
                "Sellers should be the same");
    }
}
