package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;
import pages.IntegriSettingsModalPage;

public class EditUserNameTest extends BaseTest {

    IntegriChartPage chart;
    IntegriSettingsModalPage settingModal;

    @Test
    public void validateEditUserName() {
        String userName = "New User - Test 10.2";
        chart = new IntegriChartPage(driver);
        settingModal = new IntegriSettingsModalPage(driver);
        chart.openPage();
        chart.openSetting();
        settingModal.enterUserNameAndSave(userName);
        chart.validationUserNameAfterSave(userName);
    }
}
