package Lesson6.Pages;

import Lesson6.Base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllExpensesPage extends BaseView {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewExpenseButton;
    public AllExpensesPage(WebDriver driver){super(driver);}

    public NewExpensePage clickOnCreateNewExpenseButton(){
        createNewExpenseButton.click();
        return new NewExpensePage(driver);
    }

//    public AllExpensesPage checkNewExpensePopUp(){
//        String massage = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
//                "div[class=massage']"))).getText();
//        assertTrue(massage.contains("Заявка на расход сохранена"));
//        return this;
//    }
}
