package tests;

import org.testng.annotations.Test;
import pages.IntegriChartPage;
import pages.IntegriFileUploadModalPage;

public class UploadManyFilesTest extends BaseTest {

    IntegriChartPage chart;
    IntegriFileUploadModalPage fileUploadModalPage;

    @Test
    public void uploadManyFile() {
        //String filePath = "C:\\Users\\LenaGorbach\\IdeaProjects\\IntegriVideoPageObjectTest\\src\\test\\resources\\Food waste is the world- followup.docx\n" +
          //      "C:\\Users\\LenaGorbach\\IdeaProjects\\IntegriVideoPageObjectTest\\src\\test\\resources\\Handout 2.pdf";
        String filePathMac = "/Users/alenahorbach/Desktop/IntegriVideoPageObjectTest/src/test/resources/Food waste is the world- followup.docx\n" +
                "/Users/alenahorbach/Desktop/IntegriVideoPageObjectTest/src/test/resources/Handout 2.pdf";
        chart = new IntegriChartPage(driver);
        fileUploadModalPage = new IntegriFileUploadModalPage(driver);
        chart.openPage();
        chart.openUploadFiles();
        //fileUploadModalPage.uploadFile(2, filePath);
        fileUploadModalPage.uploadFile(2, filePathMac);
    }
}
