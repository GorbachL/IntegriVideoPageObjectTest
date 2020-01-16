package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegriSettingsModalPage extends BasePage {

    WebDriver driver;

    /*
    name
    email
    photo
    save button
    cancel button
    cross sign
     */

    public static final By NAME = By.cssSelector("[name='userName']");
    public static final By EMAIL = By.cssSelector("[name='userEmail']");
    public static final By PHOTO = By.cssSelector("[name='userPic']");
    public static final By SAVE = By.cssSelector(".integri-user-settings-save.integri-button-blue");
    public static final By CANCEL = By.cssSelector(".integri-button.integri-user-settings-reset.integri-float-right.integri-button-blue-inverse");
    public static final By CROSSSIGN = By.xpath("//*[@class='iv-icon iv-icon-cross close-integri-modal']");


    public IntegriSettingsModalPage(WebDriver driver) {
        super(driver);
    }
}
