package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriChartPage;

public class SendMessageViaButtonSteps {

    private IntegriChartPage chart;

    public SendMessageViaButtonSteps(WebDriver driver) {
        chart = new IntegriChartPage(driver);
    }

    @Step("Send {message} via button")
    public SendMessageViaButtonSteps validateMessageSending(String message) {
        chart.openPage();
        chart.sendMessage(message);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(message, 1);
        return this;
    }
}
