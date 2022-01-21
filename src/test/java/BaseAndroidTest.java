import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.application.MobileModule;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.MainScreen;

public abstract class BaseAndroidTest {

    MainScreen mainScreen;

    @BeforeMethod
    void setUp() {
        System.setProperty("profile", "androidwebsession");
        AqualityServices.initInjector(new MobileModule(AqualityServices::getApplication));
        mainScreen = new MainScreen();
    }

    @AfterMethod
    void tearDown() {
        if (AqualityServices.isApplicationStarted()) {
            AqualityServices.getApplication().quit();
        }
        System.clearProperty("profile");
    }
}
