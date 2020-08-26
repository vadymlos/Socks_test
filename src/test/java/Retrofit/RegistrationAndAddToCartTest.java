package Retrofit;

import api.MyCookieJar;
import com.google.gson.GsonBuilder;
import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.BasicAuthInterceptor;
import utils.Utils;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationAndAddToCartTest extends BaseTestForRetrofit{

    private String sessionUser;

    @BeforeMethod
    public void setUp() throws IOException {
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
    }

    @Test(description = "Login user add product to cart")
    public void shouldCanLoginUserAddProductToCart() throws IOException {
        ProductSocks productSocks = new ProductSocks("itemId", "3395a43e-2d88-40de-b95f-e00e1502085b");

        Response<ResponseBody> response3 = apiStep2Retro.canAddProductToCartForLoginUser(productSocks, sessionUser);
        assertThat(response3.code(), is(201));

        Response<List<Item>> response4 = apiStep2Retro.checkCartWithProduct();
        assertThat(response4.code(), is(200));
        assertThat(response4.body().get(0).getQuantity(), notNullValue());
        System.out.println(response4.body().get(0).getId());
    }
}
