package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class ButtonInviteTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateInviteButtonWork() {
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.clickInviteUsersToChartButton();
    }
}
