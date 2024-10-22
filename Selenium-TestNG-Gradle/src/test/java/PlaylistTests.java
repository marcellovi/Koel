import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.PlaylistPageFactory;

import java.time.Duration;
import java.util.List;

public class PlaylistTests extends BaseTest{

    @Test
    public void createSmartPlaylist(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton();
        playlistPageFactory.clickSmartPlaylistOption();
        playlistPageFactory.inputSmartPlaylistName("AKMV-18 Songs");
        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("AKMV-18");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        // success message for creating playlist
        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());

        List<WebElement> listFound = driver.findElements(By.xpath("//div[@class=\"item-container\"]//td[contains(text(),'AKMV-18')]"));
        System.out.println("Number of elements:" +listFound.size());
        Assert.assertTrue(!listFound.isEmpty());

    }

    @Test
    public void createSmartPlaylistWith1Char(){

        String str_max_256_chars = "A";

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton();
        playlistPageFactory.clickSmartPlaylistOption();
        playlistPageFactory.inputSmartPlaylistName(str_max_256_chars);
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("AKMV-18");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());
    }

    @Test
    public void createSmartPlaylistWith300Chars(){

        String str_max_256_chars = "THIS_STRING_IS_300_CHARACTERS_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx123";

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton();
        playlistPageFactory.clickSmartPlaylistOption();
        playlistPageFactory.inputSmartPlaylistName(str_max_256_chars);
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("AKMV-18");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());
    }

    @Test
    public void createEmptySmartPlaylist(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton();
        playlistPageFactory.clickSmartPlaylistOption();
        playlistPageFactory.clickSmartPlaylistSaveButton();

        // Gets the Validation Message for a Required Field after submitted //
        String validationMessage = playlistPageFactory.validationMessage().getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Please fill out this field.");
    }

    @Test
    public void createNoSongsMatchSmartPlaylist(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton();
        playlistPageFactory.clickSmartPlaylistOption();

        playlistPageFactory.inputSmartPlaylistName("NoMatchFoundPlaylist");
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("abc");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.emptyNoSongsMatchDivText().isDisplayed());
    }

    @Test
    public void createSmartPlaylistUsingGroup() throws InterruptedException {
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

       // Thread.sleep(Duration.ofSeconds(1000));
        playlistPageFactory.clickAddPlaylistButton();
        // Thread.sleep(Duration.ofSeconds(1000));
        playlistPageFactory.clickSmartPlaylistOption();
        playlistPageFactory.inputSmartPlaylistName("AKMV-18 Songs Group");

        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("AKMV-18");

        playlistPageFactory.clickSmartPlaylistGroupButton();
        playlistPageFactory.selectSmartPlaylistFirstGroupCriteria("Title");
        playlistPageFactory.selectSmartPlaylistSecondGroupCriteria("begins with");
        playlistPageFactory.inputSmartPlaylistThirdGroupCriteriaField("a");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());

        List<WebElement> listFound = driver.findElements(By.xpath("//div[@class=\"item-container\"]//td[contains(text(),'AKMV-18')]"));
        System.out.println("Number of elements Using Artist AKMV-18 :" +listFound.size());
        Assert.assertTrue(!listFound.isEmpty());
    }



    @Test
    public void createSmartPlaylistMultipleRules(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io")
                .inputPassword("TestPro@123")
                .clickSubmit();

        WebElement avatarIcon = homePageFactory.avatar();
        Assert.assertTrue(avatarIcon.isDisplayed());

        playlistPageFactory.clickAddPlaylistButton()
                .clickSmartPlaylistOption()
                .selectSmartPlaylistFirstCriteria("Artist")
                .inputSmartPlaylistName("AKMV-18 Multi Rules")
                .selectSmartPlaylistFirstCriteria("Artist")
                .inputSmartPlaylistThirdCriteriaField("AKMV-18")
                .clickSmartPlaylistAddRule()
                .selectSmartPlaylistFirstCriteriaRow2("Album")
                .inputSmartPlaylistThirdCriteriaFieldRow2("Chevalerie EP")
                .clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());

        List<WebElement> listFound = driver.findElements(By.xpath("//div[@class=\"item-container\"]//td[contains(text(),'Chevalerie EP')]"));
        System.out.println("Number of elements Using Album Chevalerie EP :" +listFound.size());
        Assert.assertTrue(!listFound.isEmpty());

    }
}
