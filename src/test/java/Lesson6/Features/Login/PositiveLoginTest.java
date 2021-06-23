package Lesson6.Features.Login;

import Lesson6.Base.BaseUiTest;
import Lesson6.Pages.LoginPage;
import org.junit.jupiter.api.Test;

import static Lesson6.Common.Configuration.*;

public class PositiveLoginTest extends BaseUiTest {

    @Test
    public void loginWithBaseUserTest(){
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton();
//                .checkUrl(BASE_URL);
    }
}
