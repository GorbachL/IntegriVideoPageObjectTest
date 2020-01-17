package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendMessageViaButtonTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateMessageSending() {
        String message = "Test 2.1";
        chart = new IntegriChartPage(driver);
        chart.messageSend(message);
        chart.messageShouldContainText(message, 1);
    }
}
