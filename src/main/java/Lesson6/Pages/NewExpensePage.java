package Lesson6.Pages;

import Lesson6.Base.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewExpensePage extends BaseView {

    public NewExpensePage(WebDriver driver){super(driver);}

    @FindBy(xpath = ".//textarea")
    private WebElement descriptionTextInput;

    @FindBy(name = "crm_expense_request[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_expense_request[expenditure]")
    private WebElement expenditureDropDownSelect;

    @FindBy(name = "crm_expense_request[sumPlan]")
    private WebElement expenseRequestSumTextInput;

    @FindBy(name = "crm_expense_request[dateChangeNotify]")
    private WebElement notifyDateHasChanged;

    @FindBy(xpath = ".//div[preceding-sibling::div[child::label[@calss='required']]]//input[@class='datepicker-input hasDatepicker'")
    private WebElement calendarView;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewExpensePage enterDescription(String description){
        descriptionTextInput.sendKeys(description);
        return this;
    }

    public NewExpensePage selectBusinessUnit(int value){
        Select businessUnitDropDawn = new Select(businessUnitDropDownSelect);
        businessUnitDropDawn.selectByValue(String.valueOf(value));
        return this;
    }

    public NewExpensePage selectExpenditure(int value){
        Select expenditureDropDawn = new Select(expenditureDropDownSelect);
        expenditureDropDawn.selectByValue(String.valueOf(value));
        return this;
    }

    public NewExpensePage setExpenseSum(int sum){
        expenseRequestSumTextInput.clear();
        expenseRequestSumTextInput.sendKeys(String.valueOf(sum));
        return this;
    }

    public NewExpensePage clickNotifyDateChangedCheckBox(){
        notifyDateHasChanged.click();
        return this;
    }

    public NewExpensePage selectDateInDatePicker(int day){
        calendarView.click();
        String xpath = String.format(".//a[text()='%d']", day);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public AllExpensesPage clickSubmit(){
        submitButton.click();
        return new AllExpensesPage(driver);
    }
}
