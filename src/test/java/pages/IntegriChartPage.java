package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class IntegriChartPage extends BasePage {

    public static final By MESSAGE_INPUT_TEXT = By.tagName("textarea");
    public static final By MESSAGE_TEXT = By.cssSelector(".integri-chat-message .integri-chat-message-text");
    public static final By SEND_MESSAGE_BUTTON = By.cssSelector(".integri-chat-send-message.integri-chat-action-button");
    public static final By EDIT_MESSAGE_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-pencil integri-chat-edit-message']");
    public static final By DELETE_MESSAGE_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-trash2 integri-chat-remove-message']");
    public static final By INVITE_BUTTON = By.xpath("//*[contains(text(), 'Invite users to chat')]");
    public static final By MESSAGE_AFTER_CLICK_INVITE = By.xpath("//span[contains(text(), 'Link was copied')]");
    public static final By COPY_CODE_BUTTON = By.cssSelector(".component-code");
    public static final By MESSAGE_AFTER_CODE_COPIED = By.xpath("//span[contains(text(), 'Code was copied')]");
    public static final By SETTINGS = By.cssSelector(".iv-icon.iv-icon-cog");
    public static final By PROFILE_USER_NAME = By.cssSelector(".integri-session-user-name .integri-session-user-name");
    public static final By ALERT_FOR_EMPTY_MESSAGE = By.xpath("//*[contains(text(), 'Message cannot be empty!')]");
    public static final By DRUG_AND_DROP_TO_UPLOAD = By.cssSelector(".integri-chat-manual-upload.integri-pointer");


    public IntegriChartPage(WebDriver driver) {
        super(driver);
    }

    public void messageSend(String message) {
        driver.findElement(MESSAGE_INPUT_TEXT).sendKeys(message);
        driver.findElement(SEND_MESSAGE_BUTTON).click();
    }

    public void messageShouldContainText(String message, int messageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, messageNumber - 1));
        String text = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_TEXT)).get(messageNumber - 1).getText();
        assertEquals(message, text, "The text of the message does not match the text that has been sent");
    }

    public void editMessageDeletingAllText() {
        driver.findElement(MESSAGE_TEXT).click();
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
        driver.findElement(MESSAGE_TEXT).clear();
        driver.findElement(MESSAGE_TEXT).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ALERT_FOR_EMPTY_MESSAGE));
    }

    public void editMessage(String editMessage) {
        driver.findElement(MESSAGE_TEXT).click();
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
        //driver.findElement(MESSAGE_TEXT).clear();
        driver.findElement(MESSAGE_INPUT_TEXT).sendKeys(editMessage);
        driver.findElement(MESSAGE_INPUT_TEXT).sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }

    public void deleteMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT));
        driver.findElement(DELETE_MESSAGE_BUTTON).click();
    }

    public void clickSendMessage() {
        driver.findElement(SEND_MESSAGE_BUTTON).click();
    }

    public void clickEditMessage() {
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
    }

    public void openSetting() {
        driver.findElement(SETTINGS).click();
    }

    public void openUploadFiles() {
        driver.findElement(DRUG_AND_DROP_TO_UPLOAD).click();
    }

    public void inviteUsersToChart() {
        driver.findElement(INVITE_BUTTON).click();
        driver.findElement(MESSAGE_AFTER_CLICK_INVITE).isDisplayed();
        String textPopup = driver.findElement(MESSAGE_AFTER_CLICK_INVITE).getText();
        assertEquals(textPopup, "Link was copied", "Info doesn't match");
        String textLink = driver.getCurrentUrl();
        String data = null;
        try {
            data = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(textLink, data, "Link does not match");
    }

    public void copyCode() {
        String textCode = driver.findElement(COPY_CODE_BUTTON).getText();
        String textCodeRefactoring = textCode.replaceAll("\n", "");
        driver.findElement(COPY_CODE_BUTTON).click();
        driver.findElement(MESSAGE_AFTER_CODE_COPIED).isDisplayed();
        String data = null;
        try {
            data = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(textCodeRefactoring, data, "Code text does not match");
    }

    public void validationUserNameAfterSave(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROFILE_USER_NAME));
        String profileName = driver.findElement(PROFILE_USER_NAME).getText();
        assertEquals(profileName, userName, "smth went wrong - User Name was NOT changed");
    }

}

