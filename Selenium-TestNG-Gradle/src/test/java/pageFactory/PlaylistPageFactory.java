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

    @FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-row\"][2]//select[@name=\"model[]\"]")
    WebElement smartPlaylistFirstCriteriaFieldRow2;

    @FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-row\"][2]//input[@name=\"value[]\"]")
    WebElement smartPlaylistThirdCriteriaFieldRow2;

    @FindBy(xpath = "//input[@name='value[]']")
    WebElement smartPlaylistThirdCriteriaField;

    @FindBy(xpath = "//footer//button[@type='submit']")
    WebElement smartPlaylistSaveButton;

    @FindBy(css = "button.btn-add-rule")
    WebElement smartPlaylistAddRuleButton;

    @FindBy(xpath = "//div[@class=\"alertify-logs top right\"]")
    WebElement smartPlaylistSuccessInfoMsg;

    @FindBy(xpath = "//button[@class=\"remove-rule\"]")
    WebElement smartPlayListRemoveButton;
    /** New Smart Playlist [ Group Criteria ] **/

    @FindBy(css = "button.btn-add-group")
    WebElement smartPlaylistAddGroup;

    @FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-group\"][2]//select[@name=\"model[]\"]")
    WebElement smartPlaylistFirstGroupCriteriaField;

    @FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-group\"][2]//select[@name=\"operator[]\"]")
    WebElement smartPlaylistSecondGroupCriteriaField;

    @FindBy(xpath = "//div[@data-test=\"smart-playlist-rule-group\"][2]//input[@name=\"value[]\"]")
    WebElement smartPlaylistThirdGroupCriteriaField;



    public PlaylistPageFactory clickAddPlaylistButton(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlusIcon)).click();
        //btnPlusIcon.click();
        return this;
    }

    public PlaylistPageFactory clickSmartPlaylistOption(){
        wait.until(ExpectedConditions.elementToBeClickable(smartPlaylistMenuOption)).click();
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

    public PlaylistPageFactory selectSmartPlaylistFirstCriteriaRow2(String option){
        Select select = new Select(smartPlaylistFirstCriteriaFieldRow2);
        select.selectByVisibleText(option);
        return this;
    }

    public PlaylistPageFactory inputSmartPlaylistThirdCriteriaField(String text){
        smartPlaylistThirdCriteriaField.sendKeys(text);
        return this;
    }

    public PlaylistPageFactory inputSmartPlaylistThirdCriteriaFieldRow2(String text){
        smartPlaylistThirdCriteriaFieldRow2.sendKeys(text);
        return this;
    }

    public PlaylistPageFactory clickSmartPlaylistSaveButton(){
        smartPlaylistSaveButton.click();
        return this;
    }

    public PlaylistPageFactory clickSmartPlaylistAddRule(){
        smartPlaylistAddRuleButton.click();
        return this;
    }

    public WebElement sucessInfoMessage(){
        return wait.until(ExpectedConditions.visibilityOf(smartPlaylistSuccessInfoMsg));
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]")));
    }

    public PlaylistPageFactory clickSmartPlaylistRemoveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(smartPlayListRemoveButton)).click();
        return this;
    }

    /** New Smart Playlist [ Group Criteria ] **/

    public PlaylistPageFactory clickSmartPlaylistGroupButton(){

        smartPlaylistAddGroup.click();
        return this;
    }

    public PlaylistPageFactory selectSmartPlaylistFirstGroupCriteria(String option){
        Select select = new Select(smartPlaylistFirstGroupCriteriaField);
        select.selectByVisibleText(option);
        return this;
    }

    public PlaylistPageFactory selectSmartPlaylistSecondGroupCriteria(String option){
        Select select = new Select(smartPlaylistSecondGroupCriteriaField);
        select.selectByVisibleText(option);
        return this;
    }

    public PlaylistPageFactory inputSmartPlaylistThirdGroupCriteriaField(String text){
        smartPlaylistThirdGroupCriteriaField.sendKeys(text);
        return this;
    }








}
