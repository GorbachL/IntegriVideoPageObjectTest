package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;
import pages.IntegriSettingsModalPage;

public class EditUserPhotoTest extends BaseTest {

    IntegriChartPage chart;
    IntegriSettingsModalPage settingsModal;

    @Test
    public void validateUserPhoto() {
        String userUrl = "https://cdn.pixabay.com/photo/2018/01/09/11/04/dog-3071334_960_720.jpg";
        chart = new IntegriChartPage(driver);
        settingsModal = new IntegriSettingsModalPage(driver);
        chart.openPage();
        chart.openSetting();
        settingsModal.enterPhotoAndSave(userUrl);
        chart.openSetting();
        settingsModal.validationUserPhotoUrlAfterSave(userUrl);
    }
}
