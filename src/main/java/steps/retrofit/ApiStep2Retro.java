package steps.retrofit;

import api.UserServiceVersionTwo;
import entity.*;
import io.qameta.allure.Step;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class ApiStep2Retro {
    private Retrofit retrofit;

    public ApiStep2Retro(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    @Step("Register new user")
    public Response<ResponseBodyUser> registerNewUser(User2 user2) throws IOException {
        return retrofit.create(UserServiceVersionTwo.class).registerNewUser(user2).execute();
    }

    @Step("Login user")
    public Response<ResponseBody> loginUser(String username, String password) throws IOException {
        return retrofit.create(UserServiceVersionTwo.class).loginUser(username, password).execute();
    }

    @Step("Add product to cart for not login user")
    public Response<ResponseBody> canAddProductToCart(ProductSocks productSocks) throws IOException {
        return retrofit.create(UserServiceVersionTwo.class).addProductToCart(productSocks).execute();
    }

    @Step("Add product to cart for login user")
    public Response<ResponseBody> canAddProductToCartForLoginUser(ProductSocks productSocks, String cookie) throws IOException {
        return retrofit.create(UserServiceVersionTwo.class).addProductToCartForLoginUser(productSocks, cookie).execute();
    }

    @Step("Add cookie for session when add product to cart")
    public Response<List<Item>> checkCartWithProduct() throws IOException {
        return retrofit.create(UserServiceVersionTwo.class).checkCart().execute();
    }
}
