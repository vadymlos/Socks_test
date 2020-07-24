package api;

import entity.User2;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.eclipse.sisu.Parameters;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Query;
import retrofit2.http.POST;

public interface UserService {
    @Headers("Content-Type: application/json")
    @POST("/register")
//    Call<User2> registerNewUser(@Body("username") String username, @Query("firstname") String firstname, @Query("lastname") String lastname, @Query("email") String email, @Query("password") String password);
    Call<Response> registerNewUser(@Body User2 user2);
}
