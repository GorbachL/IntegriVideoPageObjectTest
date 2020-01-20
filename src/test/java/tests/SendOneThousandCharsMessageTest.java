package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class SendOneThousandCharsMessageTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateSendOneThousandCharsMessage() {
        String thousandChars = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vitae metus mauris. " +
                "In hac habitasse platea dictumst. Ut faucibus massa quis lacus lacinia varius. Curabitur porttitor lacus eu enim scelerisque porttitor. " +
                "Sed eu nunc vestibulum, tincidunt purus vel, volutpat metus. Curabitur lobortis augue sit amet leo luctus rhoncus. " +
                "Sed venenatis tincidunt nisi sit amet rhoncus. Suspendisse finibus pellentesque leo, in volutpat libero tempus non. " +
                "Donec ornare nibh eu ipsum scelerisque, tristique tincidunt lorem tincidunt. Sed convallis et nunc nec finibus. " +
                "Vivamus pharetra a ante eget pellentesque. Morbi dapibus eleifend nulla, non porta quam blandit sit amet. " +
                "Vivamus lacinia, urna ac luctus commodo, magna sem tempor velit, nec dignissim purus dui vitae massa. " +
                "Duis consectetur pharetra nunc, nec blandit nisl cursus eget. Vivamus interdum vel risus ut vestibulum. " +
                "Donec vehicula sem non leo pulvinar venenatis. Nulla varius quam diam, vel sodales augue pretium ut. Integer luctus massa nunc.";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(thousandChars);
        chart.clickSendMessageButton();
        chart.messageShouldContainText(thousandChars, 1);
    }
}
