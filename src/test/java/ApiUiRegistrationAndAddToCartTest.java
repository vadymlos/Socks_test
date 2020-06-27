import api.UserApiService;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import driver.SelenoidDriverProvider;
import entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CartStep;
import steps.CatalogueStep;
import steps.MainStep;
import steps.ProductStep;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ApiUiRegistrationAndAddToCartTest {
    private UserApiService userApiService = new UserApiService();
    private String sessionUser;
    MainStep mainStep = new MainStep();
    CatalogueStep catalogueStep = new CatalogueStep();
    ProductStep productStep = new ProductStep();
    CartStep cartStep = new CartStep();

    @BeforeMethod
    public void setUp() {
        RestAssured.port = 80;
        User user4 = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");

        Response response = userApiService.registerNewUser(user4);

        assertThat(response.statusCode(), equalTo(200));
        String userId = response.body().jsonPath().get("id").toString();
        assertThat(userId, not(isEmptyOrNullString()));

        Response response2 = userApiService.loginUser(user4.getUsername(), user4.getPassword());

        assertThat(response2.statusCode(), equalTo(200));
        sessionUser = response2.getCookie("md.sid");
        System.out.println(sessionUser);

        Configuration.baseUrl = "http://172.32.64.78";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = SelenoidDriverProvider.class.getName();
        Configuration.fastSetValue = true;
        Configuration.driverManagerEnabled = false;
        Cookie cook1 = new Cookie("logged_in", sessionUser.substring(sessionUser.indexOf("%")+3, sessionUser.indexOf(".")));
        Cookie cook2 = new Cookie("md.sid", sessionUser);

        open("http://172.32.64.78");
        Selenide.clearBrowserCookies();
        WebDriverRunner.getWebDriver().manage().addCookie(cook1);
        WebDriverRunner.getWebDriver().manage().addCookie(cook2);
        Selenide.refresh();
        mainStep.checkThatLogoutLinkIsVisible();
    }

    @Test(description = "Add product to cart")
    public void shouldCanAddProductToCart(){
        mainStep.clickOnCatalogueButton();
        catalogueStep.clickOnProductName();
        productStep.clickTheButtonAddToCart();
        productStep.clickTheButtonItemsInCart();
        cartStep.checkProductInCart();
        cartStep.checkValueOnTheButtonItemsInCart();
        cartStep.clickTheButtonRefresh();
        cartStep.checkProductInCart();
        cartStep.checkValueOnTheButtonItemsInCart();
    }
}
