package tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class DeleteMessageTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateDeleteMessage() {
        String message = "Test 8.2 - Удалить сообщение";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(message);
        chart.clickSendMessageButton();
        chart.deleteMessage();
        acceptAlert();
        chart.verifyMessageWasDeleted();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
