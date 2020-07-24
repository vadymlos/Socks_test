package api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class ApiClient {
    public Retrofit retrofit;
    public UserService userService;

//    public Retrofit getRetrofit() {
//        OkHttpClient okhttp = new OkHttpClient.Builder()
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .readTimeout(10, TimeUnit.SECONDS)
//        .build();
//        init();
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://localhost:80")
//                .client(okhttp)
//                .build();
//        return retrofit;
//    }
//    public void init(){
//
//    }
}
