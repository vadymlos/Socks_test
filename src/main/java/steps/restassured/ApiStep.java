package steps.restassured;

import api.UserApiService;
import com.codeborne.selenide.WebDriverRunner;
import entity.User;
import io.qameta.allure.Step;
//import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class ApiStep {
    private UserApiService userApiService = new UserApiService();
    private String sessionUser;

    @Step("Api Registration new user")
    public void shouldCanRegisterNewUser(User user){
        userApiService.registerNewUser(user).then().statusCode(200);
    }

    @Step("Api Login user")
    public String  loginUserAndReturnSessionUser(User user){
        Response response2 = userApiService.loginUser(user.getUsername(), user.getPassword());
        sessionUser = response2.getCookie("md.sid");
        return sessionUser;
    }

    @Step("Set user cookie")
    public List<Cookie> userCookie(String sessionUser){
        List<Cookie> cookies = new ArrayList<>();
        Cookie cookie1 = new Cookie("logged_in", sessionUser.substring(sessionUser.indexOf("%")+3, sessionUser.indexOf(".")));
        Cookie cookie2 = new Cookie("md.sid", sessionUser);
        cookies.add(cookie1);
        cookies.add(cookie2);
        return cookies;
    }
}
