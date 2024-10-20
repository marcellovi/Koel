import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        //WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(enabled = false)
    public void loginEmptyEmailPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }


}
