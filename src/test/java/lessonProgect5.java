import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

public class lessonProgect5 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "user";
    private static final String PASSWORD = "1234";
    private static final String Menu = "//ul[contains(@class,'nav-multilevel')]/li[contains(.,'Контрагенты')]";
    private static final String subMenu = "//li[@data-route='crm_contact_index']/a";
    private static final String createProject = "//a[@title='Создать контактное лицо']";
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
    private static final String close = "//*[@id=\"crm_project-uid-60c214df908de\"]/div[1]/div/div/div[2]/div[1]/div[4]/button";
    private static final String massage = "//div[contains (@class, 'alert-success')]";


    @BeforeAll
    public static  void setupWebDriverManager(){
        WebDriverManager.chromedriver().setup();}

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
        WebElement project = driver.findElement(By.xpath(Menu));
        actionsProject.moveToElement(project).perform();

        driver.findElement(By.xpath(subMenu)).click();
        driver.findElement(By.xpath(createProject)).click();

        WebElement LastName = driver.findElement(By.cssSelector("input[name='crm_contact[lastName]']"));
        LastName.sendKeys("Юзеров");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Юзер");

        driver.findElement(By.name("crm_contact[company]"));
        driver.findElement(By.xpath("//input[contains (@class,'select2-input')]")).sendKeys("104");
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='select2-result-label']"))));
        driver.findElement(By.xpath("//input[contains (@class,'select2-input')]")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTittle]")).sendKeys("Менеджер");

        WebElement Save = driver.findElement(By.xpath("//button[contains(./'Сохранить и закрыть')]"));

        String massageSuccess = new WebDriverWait(driver,5).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (@class, 'alter-success')]"))).getText();

        Assertions.assertTrue(massageSuccess.contains("Контактное лицо создано! "));

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
