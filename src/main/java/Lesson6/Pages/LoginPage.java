package Lesson6.Pages;

import Lesson6.Base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    @FindBy(css = "input[id='prependedInput']")
    private WebElement inputLogin;

    @FindBy(css = "input[id='prependedInput2']")
    private WebElement inputPassword;

    @FindBy(css = "button[id='_submit']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver){super(driver);}

    public LoginPage enterLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton(){
        buttonSignIn.click();
        return new HomePage(driver);
    }

    public HomePage authoriseScenario(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }

}
