package Lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class lesson3 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "user";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws InterruptedException {


        //Первый сценарий

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(LOGIN_PAGE_URL);
        Thread.sleep(1000);

        Login();

        // Второй сценарий

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get(LOGIN_PAGE_URL);
        Thread.sleep(1000);

        Login();

        WebElement proekt = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]"));
        proekt.click();

        WebElement proekt1 = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[3]"));
        proekt1.click();
        Thread.sleep(3000);

        WebElement proekt2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div"));
        proekt2.click();
        Thread.sleep(5000);


        WebElement name = driver.findElement(By.cssSelector("input[data-name='field__name']"));
        name.sendKeys("-7946133497");

        Select organization = new Select(driver.findElement(By.xpath("//*[@id=\"s2id_crm_project_company-uid-60bb197b77796\"]/a/span[1]")));
        organization.deselectByValue("2");

        Select finans = new Select(driver.findElement(By.xpath("//*[@id=\"crm_project_financeSource-uid-60b90c0fce2db\"]")));
        finans.deselectByValue("2");

        Select podrazdilenie = new Select(driver.findElement(By.xpath("//*[@id=\"crm_project_businessUnit-uid-60b90c0fe24b4\"]")));
        podrazdilenie.deselectByValue("1");

        Select curator = new Select(driver.findElement(By.xpath("//*[@id=\"crm_project_curator-uid-60b90c101c88a\"]")));
        curator.deselectByValue("8");

        Select rukovoditel = new Select(driver.findElement(By.xpath("//*[@id=\"crm_project_rp-uid-60b90c1010846\"]")));
        rukovoditel.deselectByValue("8");

        Select manager = new Select(driver.findElement(By.xpath("//*[@id=\"crm_project_manager-uid-60b90c0febead\"]")));
        manager.deselectByValue("8");

        WebElement save = driver.findElement(By.xpath("//*[@id=\"crm_project-uid-60b91f1b55164\"]/div[1]/div/div/div[2]/div[1]/div[4]/button"));
        save.click();

    }
    public static void Login() throws InterruptedException {
        WebElement login = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        login.sendKeys(LOGIN);
        Thread.sleep(500);

        WebElement password = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        password.sendKeys(PASSWORD);
        Thread.sleep(500);

        WebElement button = driver.findElement(By.cssSelector("button[id='_submit']"));
        button.click();
        Thread.sleep(1000);

    }
}
