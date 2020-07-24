package api;

import entity.User2;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserServiceVersionTwo {
    @Headers("Content-Type: application/json")
    @POST("/register")
    Call<ResponseBody> registerNewUser(@Body User2 user2);
}
