package Lesson6.Enums;

import Lesson6.Base.SubMenuButtons;
import org.openqa.selenium.By;

public enum ExpenseSubMenuButtons implements SubMenuButtons {

    EXPENSE_REQUEST(".//span[@class='title' and text()='Заявки на расходы']");
    private final By by;

    ExpenseSubMenuButtons(String xpath){this.by = By.xpath(xpath);}

    public By getBy(){return by;}
}
