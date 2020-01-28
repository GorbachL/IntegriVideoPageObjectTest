package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendMessageViaButtonTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateMessageSending() {
        String message = "Test 2.2 - Отправить любое сообщение используя Кнопку";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(message);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(message, 1);
    }
}
