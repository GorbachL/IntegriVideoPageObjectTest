package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class ButtonCodeTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateCopyCodeText() {
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.clickCopyCode();
    }
}
