package Lesson6.Views;

import Lesson6.Base.BaseView;
import Lesson6.Base.SubMenu;
import Lesson6.Enums.NavigationBarTabs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver){super(driver);}

    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab){
            case EXPENSES:
                return new ExpenseSubMenu(driver);
            default:
                throw new IllegalArgumentException("Another tabs currently not implemented");
        }
    }

//    public NavigationBar checkTabVisibility(NavigationBarTabs tab){
//        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
//        return this;
//    }
}
