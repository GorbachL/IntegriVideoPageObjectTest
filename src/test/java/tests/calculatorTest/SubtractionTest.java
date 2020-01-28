package tests.calculatorTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Calculator;

import static org.testng.Assert.assertEquals;

public class SubtractionTest {

    @DataProvider
    public static Object[][] substract() {
        return new Object[][]{
                {3, 5, -2,},
                {5, -13, 18},
                {0, -14, 14},
                {23, 0, 23},
                {-27, -24, -3}
        };
    }

    @BeforeMethod
    public void beforeRunTest() {
        System.out.println("Run the latest tests.");
    }

    @Test(dataProvider = "substract", priority = 4)
    public void verifySubstract(int firstNumber, int secondNumber, int expectedResult) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(new Calculator().subtraction(firstNumber, secondNumber), expectedResult);
    }

    @AfterMethod
    public void afterRunTest() {
        System.out.println("All tests have been run.");
    }

}
