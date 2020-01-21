package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;

public class IntegriChartPage extends BasePage {

    public static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    public static final By MESSAGE_INPUT_TEXT = By.cssSelector("[placeholder~=Start]");
    public static final By MESSAGE_TEXT_BOX = By.cssSelector(".integri-chat-message-text");
    public static final By EDIT_TEXT_AREA = By.cssSelector(".integri-chat-message-text+textarea");
    public static final By SEND_MESSAGE_BUTTON = By.cssSelector(".integri-chat-send-message");
    public static final By EDIT_MESSAGE_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-pencil integri-chat-edit-message']");
    public static final By DELETE_MESSAGE_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-trash2 integri-chat-remove-message']");
    public static final By REMOVED_MESSAGE = By.cssSelector(".integri-chat-message.integri-chat-message-utility");
    public static final By INVITE_BUTTON = By.xpath("//*[contains(text(), 'Invite users to chat')]");
    public static final By MESSAGE_AFTER_CLICK_INVITE = By.xpath("//span[contains(text(), 'Link was copied')]");
    public static final By COPY_CODE_BUTTON = By.cssSelector(".component-code");
    public static final By MESSAGE_AFTER_CODE_COPIED = By.xpath("//span[contains(text(), 'Code was copied')]");
    public static final By SETTINGS = By.cssSelector(".iv-icon.iv-icon-cog");
    public static final By PROFILE_USER_NAME = By.cssSelector(".integri-session-user-name");
    public static final By ALERT_FOR_EMPTY_MESSAGE = By.xpath("//*[contains(text(), 'Message cannot be empty!')]");
    public static final By DRUG_AND_DROP_TO_UPLOAD = By.cssSelector(".integri-chat-manual-upload");


    public IntegriChartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void sendMessage(String message) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_INPUT_TEXT));
        driver.findElement(MESSAGE_INPUT_TEXT).sendKeys(message);
    }

    public void clickSendMessageButton() {
        driver.findElement(SEND_MESSAGE_BUTTON).click();
    }

    public void sendMessageViaEnter() {
        driver.findElement(MESSAGE_INPUT_TEXT).sendKeys(ENTER);
    }

    public void messageShouldContainText(String message, int messageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT_BOX));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT_BOX, messageNumber - 1));
        String text = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_TEXT_BOX)).get(messageNumber - 1).getText();
        assertEquals(message, text, "The text of the message does not match the text that has been sent");
    }

    public void editMessageDeletingAllText() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT_BOX));
        driver.findElement(MESSAGE_TEXT_BOX).click();
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
        driver.findElement(EDIT_TEXT_AREA).clear();
        driver.findElement(EDIT_TEXT_AREA).sendKeys(ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ALERT_FOR_EMPTY_MESSAGE));
    }

    public void editMessage(String editMessage) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT_BOX));
        driver.findElement(MESSAGE_TEXT_BOX).click();
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
        driver.findElement(EDIT_TEXT_AREA).clear();
        driver.findElement(EDIT_TEXT_AREA).sendKeys(editMessage);
        driver.findElement(EDIT_TEXT_AREA).sendKeys(ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_TEXT_BOX));
        driver.navigate().refresh();
    }

    public void deleteMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT_BOX));
        driver.findElement(MESSAGE_TEXT_BOX).click();
        driver.findElement(DELETE_MESSAGE_BUTTON).click();
    }

    public void verifyMessageWasDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable(REMOVED_MESSAGE));
        String removedText = driver.findElement(REMOVED_MESSAGE).getText();
        assertEquals(removedText, "removed...", "The message was not removed");
    }

    public void clickEditMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TEXT_BOX));
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
    }

    public void openSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(SETTINGS)).click();
    }

    public void openUploadFiles() {
        wait.until(ExpectedConditions.elementToBeClickable(DRUG_AND_DROP_TO_UPLOAD)).click();
    }

    public void clickInviteUsersToChartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(INVITE_BUTTON)).click();
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

    public void clickCopyCode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(COPY_CODE_BUTTON));
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

