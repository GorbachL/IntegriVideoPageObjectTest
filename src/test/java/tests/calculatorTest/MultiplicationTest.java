package tests.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Calculator;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest {

    @DataProvider
    public Object[][] multiply() {
        return new Object[][]{
                {3, 5, 15},
                {5, 13, 65},
                {15, -14, -210},
                {0, 34, 0},
                {27, 0, 0}
        };
    }

    @Test(dataProvider = "multiply", invocationCount = 3, threadPoolSize = 5, priority = 3)
    public void verifyMultiply(int firstNumber, int secondNumber, int expectedResult) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(new Calculator().multiplication(firstNumber, secondNumber), expectedResult);
    }
}
