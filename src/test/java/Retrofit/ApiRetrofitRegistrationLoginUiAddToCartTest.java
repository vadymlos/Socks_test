package Retrofit;

import api.MyCookieJar;
import api.UserApiService;
import api.UserServiceVersionTwo;
import com.codeborne.selenide.Selenide;
import com.google.gson.GsonBuilder;
import entity.ResponseBodyUser;
import entity.User;
import entity.User2;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import steps.restassured.ApiStep;
import steps.retrofit.ApiStep2Retro;
import steps.ui.CartStep;
import steps.ui.CatalogueStep;
import steps.ui.MainStep;
import steps.ui.ProductStep;
import utils.BasicAuthInterceptor;
import utils.Utils;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ApiRetrofitRegistrationLoginUiAddToCartTest extends BaseTestForRetrofit{

    MainStep mainStep = new MainStep();
    CatalogueStep catalogueStep = new CatalogueStep();
    ProductStep productStep = new ProductStep();
    CartStep cartStep = new CartStep();

    @BeforeMethod
    public void setUp() throws IOException {
        MyCookieJar myCookieJar = new MyCookieJar();
        User2 user3 = new User2(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");

        Response<ResponseBodyUser> response = apiStep2Retro.registerNewUser(user3);
        assertThat(response.code(), is(200));
        String userId = response.body().getId();
        assertThat(userId, notNullValue());
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(user3.getUsername(), user3.getPassword()))
                .cookieJar(new MyCookieJar())
                .build();
        retrofit = new Retrofit.Builder().client(client)
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .host("http://localhost/")
                .build();
        client.cookieJar().loadForRequest(httpUrl);

        open("/index.html");
        apiStep2Retro = new ApiStep2Retro(retrofit);
        mainStep.setUserCookieOk(  );
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
