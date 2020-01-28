package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendMessageWithLinkTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateMessageWithLink() {
        String sendText = "Test 4.2 - Отправить сообщение со ссылкой" + " " + "https://catalog.onliner.by/";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(sendText);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(sendText, 1);
    }
}
