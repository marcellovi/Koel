package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory extends BasePageFactory {

    public HomePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="img.avatar")
    WebElement avatarIcon;

    public WebElement avatar(){
        return avatarIcon;
    }
}
