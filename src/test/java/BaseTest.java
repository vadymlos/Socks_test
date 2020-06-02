import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import driver.SelenoidDriverProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void BeforeMethod(){
        Configuration.baseUrl = "http://172.32.65.10/";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = SelenoidDriverProvider.class.getName();
        Configuration.fastSetValue = true;
        Configuration.driverManagerEnabled = false;
        Selenide.clearBrowserCookies();
        open("index.html");
    }
}
