package Lesson6.Views;

import Lesson6.Base.BaseView;
import Lesson6.Base.SubMenu;
import Lesson6.Base.SubMenuButtons;
import Lesson6.Enums.ExpenseSubMenuButtons;
import Lesson6.Pages.AllExpensesPage;
import org.openqa.selenium.WebDriver;

public class ExpenseSubMenu extends SubMenu {
        public ExpenseSubMenu(WebDriver driver){super(driver);}

        @Override
        public BaseView clickSubMenuButton(SubMenuButtons buttons){
            if (buttons instanceof ExpenseSubMenuButtons){
                switch ((ExpenseSubMenuButtons) buttons){
                    case EXPENSE_REQUEST:
                        driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                        return new AllExpensesPage(driver);
                    default:
                        throw new IllegalArgumentException("Not implemented yet");
                }
            }else {
                throw new IllegalArgumentException("Incorrect button type");
            }
        }
    }


