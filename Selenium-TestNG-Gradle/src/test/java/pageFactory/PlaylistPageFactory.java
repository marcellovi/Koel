package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PlaylistPageFactory extends BasePageFactory{

    public PlaylistPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath="//i[@data-testid=\"sidebar-create-playlist-btn\"]")
    WebElement btnPlusIcon;

    @FindBy(xpath = "//li[@data-testid=\"playlist-context-menu-create-smart\"]")
    WebElement smartPlaylistMenuOption;

    @FindBy(xpath = "//input[@name='name']")
    WebElement smartPlaylistNameField;

    //@FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-row\"]//select[1]")
    @FindBy(xpath = "//select[@name=\"model[]\"]")
    WebElement smartPlaylistFirstCriteriaField;

    @FindBy(xpath = "//input[@name='value[]']")
    WebElement smartPlaylistThirdCriteriaField;

    @FindBy(xpath = "//footer//button[@type='submit']")
    WebElement smartPlaylistSaveButton;

    @FindBy(xpath = "//div[@class=\"alertify-logs top right\"]")
    WebElement smartPlaylistSuccessInfoMsg;

    public PlaylistPageFactory clickAddPlaylistButton(){
        btnPlusIcon.click();
        return this;
    }

    public PlaylistPageFactory clickSmartPlaylistOption(){
        smartPlaylistMenuOption.click();
        return this;
    }

    public PlaylistPageFactory inputSmartPlaylistName(String name){
        smartPlaylistNameField.sendKeys(name);
        return this;
    }

    public PlaylistPageFactory selectSmartPlaylistFirstCriteria(String option){
        Select select = new Select(smartPlaylistFirstCriteriaField);
        select.selectByVisibleText(option);
        //select.selectByIndex(3);
        //smartPlaylistFirstCriteriaField.click();
        return this;
    }

    public PlaylistPageFactory inputSmartPlayThirdCriteriaField(String text){
        smartPlaylistThirdCriteriaField.sendKeys(text);
        return this;
    }

    public PlaylistPageFactory clickSmartPlaySaveButton(){
        smartPlaylistSaveButton.click();
        return this;
    }

    public WebElement sucessInfoMessage(){
        return wait.until(ExpectedConditions.visibilityOf(smartPlaylistSuccessInfoMsg));
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]")));
    }









}
