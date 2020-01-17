package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriSettingsModalPage extends BasePage {

    public static final By USER_NAME = By.cssSelector("[name='userName']");
    public static final By USER_EMAIL = By.cssSelector("[name='userEmail']");
    public static final By PHOTO = By.cssSelector("[name='userPic']");
    public static final By SAVE = By.cssSelector(".integri-user-settings-save.integri-button-blue");
    public static final By CANCEL = By.cssSelector(".integri-button.integri-user-settings-reset.integri-float-right.integri-button-blue-inverse");
    public static final By SETTINGS_MODAL = By.xpath("//div[@class='integri-user-settings']");

    public IntegriSettingsModalPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserNameAndSave(String userName) {
        driver.findElement(SETTINGS_MODAL);
        //wait.until(ExpectedConditions.elementToBeClickable(USER_NAME)).click();
        driver.findElement(USER_NAME).clear();
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(SAVE).click();
        driver.navigate().refresh();
    }

    public void enterEmailAndSave(String email) {
        driver.findElement(SETTINGS_MODAL);
        driver.findElement(USER_EMAIL).click();
        driver.findElement(USER_EMAIL).sendKeys(email);
        driver.findElement(SAVE).click();
        driver.navigate().refresh();
    }

    public void validationUserEmailAfterSave(String email) {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_MODAL));
        String userEmail = driver.findElement(USER_EMAIL).getAttribute("value");
        assertEquals(email, userEmail, "Smth went wrong - User Email was NOT saved");
    }

    public void enterPhotoAndSave(String photo) {
        driver.findElement(PHOTO).click();
        driver.findElement(PHOTO).sendKeys(photo);
        driver.findElement(SAVE).click();
        driver.navigate().refresh();
    }
}
