import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeSuite
    public void BeforeClass(){
        Configuration.baseUrl = "http://localhost/";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.fastSetValue  = true;
    }

    @BeforeMethod
    public void beforeMethod() {
        Selenide.clearBrowserCookies();
        open("/");
    }
}
