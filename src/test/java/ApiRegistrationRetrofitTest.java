import api.ApiClient;
import api.UserService;
import entity.User2;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiRegistrationRetrofitTest {
    private User2 user2;
    ApiClient apiClient = new ApiClient();

    @Test
    public void testUserPage() throws IOException {
        apiClient.userService.registerNewUser("dot.com", "123").execute().body();
    }

}
