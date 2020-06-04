package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.IntegriChartPage;
import steps.SendMessageViaButtonSteps;

public class SendMessageViaButtonTest extends BaseTest {

    //IntegriChartPage chart;
    SendMessageViaButtonSteps steps;

    @Test(description = "Send message via button")
    @Description("Validate sending message via button")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateMessageSendingTest() {
        String message = "Test 2.2 - Отправить любое сообщение используя Кнопку";
//        chart = new IntegriChartPage(driver);
//        chart.openPage();
//        chart.sendMessage(message);
//        chart.clickSendMessageButton();
//        chart.messageShouldContainText(message, 1);
        steps = new SendMessageViaButtonSteps(driver);
        steps.validateMessageSending(message);
    }
}
