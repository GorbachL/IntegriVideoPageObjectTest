package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriFileUploadModalPage extends BasePage {

    private static final By BROWSE_BUTTON = By.cssSelector(".integri-file-upload-manual-init");
    private static final By INPUT_FILE = By.xpath("//input[@type='file']");
    private static final By START_BUTTON = By.cssSelector(".integri-file-upload-start");
    private static final By CANCEL_BUTTON = By.cssSelector(".integri-file-upload-cancel ");
    private static final By FILE_LIST_FOR_UPLOADING = By.cssSelector(".integri-file-item");
    private static final By ICON_CROSS_FILE_REMOVE_FROM_LIST = By.cssSelector(".iv-icon.iv-icon-cross.integri-file-item-remove");
    private static final By UPLOAD_FILE_MODAL = By.xpath("//div[contains(text(), 'Upload files')]");

    public IntegriFileUploadModalPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(int numberOfFiles, String... pathFile) {
        //wait.until(ExpectedConditions.elementToBeClickable(BROWSE_BUTTON)).click();
        WebElement input = driver.findElement(INPUT_FILE);
        input.sendKeys(pathFile);
        driver.findElement(START_BUTTON).click();
        List<WebElement> files = driver.findElements(FILE_LIST_FOR_UPLOADING);
        assertEquals(files.size(), numberOfFiles, "Check the number of files to upload");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOAD_FILE_MODAL)).isDisplayed();
    }
}
