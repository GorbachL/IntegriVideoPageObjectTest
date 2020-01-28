package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendMessageWithJavaScriptTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateSendMessageWithJavaScript() {
        String textToTest = "<html><body><p>test 5.2</p></body></html>";
        String text = "test 5.2";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(textToTest);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(text, 1);
    }
}
