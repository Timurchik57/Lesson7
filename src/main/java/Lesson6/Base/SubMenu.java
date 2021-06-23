package Lesson6.Base;

import org.openqa.selenium.WebDriver;

public abstract class SubMenu extends BaseView {

    public SubMenu(WebDriver driver){super(driver);}
    abstract public BaseView clickSubMenuButton(SubMenuButtons buttons);
}
