package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;

public class EditMessageDeletingAllTextTest extends BaseTest {

    IntegriChartPage chart;

    @Test
    public void validateAlertWhileDeletingAllText() {
        String text = "Test 7.2 - Отредактировать сообщение удалив весь текст (должна быть ошибка)";
        chart = new IntegriChartPage(driver);
        chart.openPage();
        chart.sendMessage(text);
        chart.clickSendMessageButton();
        chart.editMessageDeletingAllText();
    }
}
