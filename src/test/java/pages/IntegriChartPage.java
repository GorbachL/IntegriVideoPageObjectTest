package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriChartPage extends BasePage {

    WebDriver driver;

    //public static final String URL = "https://dev.integrivideo.com/demo/chat/new";

    /*
    text input ++
    send button ++
    edit button ++
    delete button ++
    invite button ++
    copy code button ++
    messages locator ++
    Settings ++
    Profile Details locator +
     */

    public static final By MESSAGE_TEXT_AREA = By.tagName("textarea");
    public static final By SEND_BUTTON = By.cssSelector(".integri-chat-send-message.integri-chat-action-button");
    public static final By EDIT_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-pencil integri-chat-edit-message']");
    public static final By DELETE_BUTTON = By.xpath("//span[@class='iv-icon iv-icon-trash2 integri-chat-remove-message']");
    public static final By INVITE_BUTTON = By.xpath("//*[contains(text(), 'Invite users to chat')]");
    public static final By COPYCODE_BUTTON = By.xpath("//span[contains(text(), 'Code was copied')]");
    public static final By MESSAGE_TEXT = By.cssSelector(".integri-chat-message .integri-chat-message-text");
    public static final By SETTINGS = By.cssSelector(".iv-icon.iv-icon-cog");
    public static final By PROFILEDETAILS = By.cssSelector(".integri-session-user-name .integri-session-user-name");

    public IntegriChartPage(WebDriver driver) {
        super(driver);
    }

//    public void openPage() {
//        driver.get(URL);
//    }

    public void typeMessage(String message) {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }

    public void sendMessageUsingButton() {
        driver.findElement(SEND_BUTTON).click();
    }

    public void messageShouldContainText(String message) {

        String text = driver.findElement(MESSAGE_TEXT).getText();
        assertEquals(message, text, "The text of the message does not match the text that has been sent");
    }

    public void editMessage() {
        driver.findElement(EDIT_BUTTON).click();
    }

    public void deleteMessage() {
        driver.findElement(DELETE_BUTTON).click();
    }

    public void inviteUsersToChart() {
        driver.findElement(INVITE_BUTTON).click();
    }

    public void copyCode() {
        driver.findElement(COPYCODE_BUTTON).click();
    }

    public void openSetting() {
        driver.findElement(SETTINGS).click();
    }

}
