import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.PlaylistPageFactory;

public class PlaylistTests extends BaseTest{

    @Test
    public void createSmartPlaylist() throws InterruptedException {
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
        playlistPageFactory.inputSmartPlayThirdCriteriaField("AKMV-18");
        playlistPageFactory.clickSmartPlaySaveButton();

        Assert.assertTrue(playlistPageFactory.sucessInfoMessage().isDisplayed());
    }
}
