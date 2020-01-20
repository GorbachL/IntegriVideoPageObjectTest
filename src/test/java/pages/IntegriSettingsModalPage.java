package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriSettingsModalPage extends BasePage {

    public static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    public static final By USER_NAME = By.cssSelector("[name='userName']");
    public static final By USER_EMAIL = By.cssSelector("[name='userEmail']");
    public static final By PHOTO = By.cssSelector("[name='userPic']");
    public static final By SAVE_BUTTON = By.cssSelector(".integri-user-settings-save.integri-button-blue");
    public static final By CANCEL_BUTTON = By.cssSelector(".integri-button.integri-user-settings-reset.integri-float-right.integri-button-blue-inverse");
    public static final By SETTINGS_MODAL = By.xpath("//div[@class='integri-user-settings']");

    public IntegriSettingsModalPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void enterUserNameAndSave(String userName) {
        wait.until(ExpectedConditions.elementToBeClickable(USER_NAME)).click();
        driver.findElement(USER_NAME).clear();
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(SAVE_BUTTON).click();
        driver.navigate().refresh();
    }

    public void enterEmailAndSave(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(USER_EMAIL)).click();
        driver.findElement(USER_EMAIL).sendKeys(email);
        driver.findElement(SAVE_BUTTON).click();
        driver.navigate().refresh();
    }

    public void validationUserEmailAfterSave(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_MODAL));
        String userEmail = driver.findElement(USER_EMAIL).getAttribute("value");
        assertEquals(email, userEmail, "Smth went wrong - User Email was NOT saved");
    }

    public void enterPhotoAndSave(String photo) {
        wait.until(ExpectedConditions.elementToBeClickable(PHOTO)).click();
        driver.findElement(PHOTO).sendKeys(photo);
        driver.findElement(SAVE_BUTTON).click();
        driver.navigate().refresh();
    }

    public void validationUserPhotoUrlAfterSave(String photo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_MODAL));
        String photoUrl = driver.findElement(PHOTO).getAttribute("value");
        assertEquals(photo, photoUrl, "Smth went wrong - User Photo was NOT saved");
    }
}
