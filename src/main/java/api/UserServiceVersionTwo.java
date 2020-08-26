package api;

import entity.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserServiceVersionTwo {
    @Headers("Content-Type: application/json")
    @POST("/register")
    Call<ResponseBodyUser> registerNewUser(@Body User2 user2);

    @Headers("Content-Type: application/json")
    @GET("/login")
    Call<ResponseBody> loginUser(@Query("username") String userName, @Query("password") String password);

    @Headers("Content-Type: application/json")
    @POST("/cart")
    Call<ResponseBody> addProductToCart(@Body ProductSocks productSocks);

    @Headers("Content-Type: application/json")
    @POST("/cart")
    Call<ResponseBody> addProductToCartForLoginUser(@Body ProductSocks productSocks, @Header("Cookie") String cookie);

    @GET("/cart")
    Call<List<Item>> checkCart();
}
