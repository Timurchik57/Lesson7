package Lesson6.Features.Expenses;

import Lesson6.Base.BaseUiTest;
import Lesson6.Common.Configuration;
import Lesson6.Enums.ExpenseSubMenuButtons;
import Lesson6.Enums.NavigationBarTabs;
import Lesson6.Pages.AllExpensesPage;
import Lesson6.Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class NewExpensesTest extends BaseUiTest {

    @Test
    public void createNewExpensePositiveTest(){
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit();
//                .CheckNewExpensePopUp();
    }
}
