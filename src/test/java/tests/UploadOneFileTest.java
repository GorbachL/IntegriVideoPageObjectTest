package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;
import pages.IntegriFileUploadModalPage;

public class UploadOneFileTest extends BaseTest {

    IntegriChartPage chart;
    IntegriFileUploadModalPage fileUploadModalPage;

    @Test
    public void uploadOneFile() {
        String filePath = "C:\\Users\\LenaGorbach\\IdeaProjects\\IntegriVideoPageObjectTest\\src\\test\\resources\\Handout 2.pdf";
        chart = new IntegriChartPage(driver);
        fileUploadModalPage = new IntegriFileUploadModalPage(driver);
        chart.openPage();
        chart.openUploadFiles();
        fileUploadModalPage.uploadFile(1, filePath);
    }
}
