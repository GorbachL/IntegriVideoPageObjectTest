package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;
import pages.IntegriSettingsModalPage;

public class EditUserEmailTest extends BaseTest {

    IntegriChartPage chart;
    IntegriSettingsModalPage settingsModal;

    @Test
    public void validateEditUserEmail() {
        String userEmail = "Test11@mail.ru";
        chart = new IntegriChartPage(driver);
        settingsModal = new IntegriSettingsModalPage(driver);
        chart.openPage();
        chart.openSetting();
        settingsModal.enterEmailAndSave(userEmail);
        chart.openSetting();
        settingsModal.validationUserEmailAfterSave(userEmail);
    }
}

