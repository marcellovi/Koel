import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.PlaylistPageFactory;

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
        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.inputSmartPlaylistName("AKMV-18 Songs");
        playlistPageFactory.selectSmartPlaylistFirstCriteria("Artist");
        playlistPageFactory.inputSmartPlaylistThirdCriteriaField("AKMV-18");
        playlistPageFactory.clickSmartPlaylistSaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());
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
    }
}
