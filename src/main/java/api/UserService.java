package api;

import entity.User2;
import okhttp3.ResponseBody;
import org.eclipse.sisu.Parameters;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("/register")
    Call<User2> registerNewUser(@Query("email") String email, @Query("password") String password);
}
