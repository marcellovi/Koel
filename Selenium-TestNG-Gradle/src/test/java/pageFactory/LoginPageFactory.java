package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePageFactory{

    public LoginPageFactory(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css="[type='email']")
    WebElement emailField;

    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public LoginPageFactory inputEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageFactory inputPassword(String pwd){
        passwordField.sendKeys(pwd);
        return this;
    }

    public LoginPageFactory clickSubmit(){
        submitButton.click();
        return this;
    }

}
