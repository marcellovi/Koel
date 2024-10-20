import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private String url = "https://qa.koel.app/";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    protected ChromeOptions options;

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    //@Parameters({"baseUrl"})
    @BeforeMethod
    public void initMethod(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","--disable-notifications","--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        action = new Actions(driver);
        // Open browser w/url
        driver.get(url);
    }

    @AfterMethod
    public void endMethod(){
        driver.quit();
    }

}
