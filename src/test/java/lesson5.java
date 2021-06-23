import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class lesson5 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "user";
    private static final String PASSWORD = "1234";
    private static final String upProject = "//*[@id=\"main-menu\"]/ul/li[3]";
    private static final String upProject1 = "//*[@id=\"main-menu\"]/ul/li[3]/ul/li[3]";
    private static final String createProject = "//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div";
    private static final String name = "input[data-name='field__name']";
    private static final String organization = "crm_project[company]";
    private static final String organization1 = "//div[@class='company-container']/div/a/span[@class='select2-arrow']";
    private static final String organizationInput = "//input[@class='select2-input select2-focused']";
    private static final String organizationInput1 = "//div[@class='select2-result-label']";
    private static final String contact = "crm_project[contactMain]";
    private static final String business = "crm_project[businessUnit]";
    private static final String curator = "crm_project[curator]";
    private static final String rucov = "crm_project[rp]";
    private static final String manager = "crm_project[manager]";
    private static final String close = "//button[contains(.,'Сохранить и закрыть')]";
    private static final String massage = "//div[contains (@class, 'alert-success')]";


    @BeforeAll
    public static  void setupWebDriverManager(){WebDriverManager.chromedriver().setup();}

    @BeforeEach
    public void beforeTest() throws InterruptedException {
        setUpDriverSession();
        login();
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void pressProject() throws InterruptedException {
        Actions actionsProject = new Actions(driver);
        WebElement project = driver.findElement(By.xpath(upProject));
        actionsProject.moveToElement(project).perform();

        driver.findElement(By.xpath(upProject1)).click();
        driver.findElement(By.xpath(createProject)).click();

        driver.findElement(By.cssSelector(name)).sendKeys("Project_10_06_2021");

        WebElement Organisation = driver.findElement(By.name(organization));
        new WebDriverWait(driver,3).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(organization1))));
        driver.findElement(By.xpath(organization1)).click();

        new WebDriverWait(driver,3).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(organizationInput))));
        driver.findElement(By.xpath(organizationInput)).click();

        new WebDriverWait(driver,3).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(organizationInput1))));
        driver.findElement(By.xpath(organizationInput)).click();

        Select Business = new Select(driver.findElement(By.name(business)));
        Business.selectByValue("1");

        Select Curator = new Select(driver.findElement(By.name(curator)));
        Curator.selectByVisibleText("Юзеров Юзер");

        Select Rucov = new Select(driver.findElement(By.name(rucov)));
        Rucov.selectByVisibleText("Сычев Евгений");

        Select Manager = new Select(driver.findElement(By.name(manager)));
        Manager.selectByVisibleText("Юзеров Юзер");

        driver.findElement(By.xpath(close)).click();

        String massageSuccess = new WebDriverWait(driver,5).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(massage))).getText();

        Assertions.assertTrue(massageSuccess.contains("Проект создан! "));

    }
    private void setUpDriverSession(){
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);

        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        login.sendKeys(LOGIN);

        WebElement password = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        password.sendKeys(PASSWORD);

        WebElement button = driver.findElement(By.cssSelector("button[id='_submit']"));
        button.click();

    }
}
