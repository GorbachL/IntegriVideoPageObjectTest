package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class IntegriChartTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateMessageSending() {
        String message = "Test 2.1";
        chart = new IntegriChartPage(driver);
        //chart.openPage();
        chart.typeMessage(message);
        chart.sendMessageUsingButton();
        chart.messageShouldContainText(message);
    }
}
