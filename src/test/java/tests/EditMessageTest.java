package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class EditMessageTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateEditMessage() {
        String message = "Test 6.2 - Отредактировать сообщение";
        String messageEdited = "Test 6.2 + Edited text..";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(message);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(message, 1);
        chart.editMessage(messageEdited);
        chart.messageShouldContainText(messageEdited, 1);
    }
}
