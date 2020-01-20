package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendMessageViaEnterTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateMessageSendingViaEnter() {
        String message = "Test 1.2 - Отправить любое сообщение используя Enter";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(message);
        chart.sendMessageViaEnter();
        chart.messageShouldContainText(message, 1);
    }
}
