package Lesson6.Pages;

import Lesson6.Base.BaseView;
import Lesson6.Views.NavigationBar;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseView {

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver){
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

//    public void checkUrl(String url){ assertEquals(driver.getCurrentUrl(), url); }


    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}
