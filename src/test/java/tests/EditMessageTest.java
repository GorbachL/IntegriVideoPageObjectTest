package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class EditMessageTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateEditMessage() {
        String message = "Test 2.6";
        String messageEdited = "Test 2.6 + Edit text..";
        chart = new IntegriChartPage(driver);
        chart.messageSend(message);
        chart.messageShouldContainText(message, 1);
        //chart.clickEditMessage();
        chart.editMessage(messageEdited);
        chart.messageShouldContainText(messageEdited + message, 1);
    }
}
