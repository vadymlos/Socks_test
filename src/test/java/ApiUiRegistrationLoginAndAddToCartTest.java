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
import steps.*;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ApiUiRegistrationLoginAndAddToCartTest extends BaseTest{
    private UserApiService userApiService = new UserApiService();
    private String sessionUser;
    ApiStep apiStep = new ApiStep();
    MainStep mainStep = new MainStep();
    CatalogueStep catalogueStep = new CatalogueStep();
    ProductStep productStep = new ProductStep();
    CartStep cartStep = new CartStep();

    @BeforeMethod
    public void setUp() {
        User user5 = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");
        apiStep.shouldCanRegisterNewUser(user5);
        sessionUser = apiStep.loginUserAndReturnSessionUser(user5);
        apiStep.userCookie(sessionUser);
        mainStep.setUserCookie(apiStep.userCookie(sessionUser));
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
