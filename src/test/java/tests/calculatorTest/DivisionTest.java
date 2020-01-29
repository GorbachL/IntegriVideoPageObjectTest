package tests.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Calculator;

import static org.testng.Assert.assertEquals;

public class DivisionTest {

    @DataProvider
    public Object[][] divide() {
        return new Object[][]{
                {5, 5, 1},
                {15, 3, 5},
                {15, -14, -1},
                {0, 34, 0}
        };
    }

    @Test(dataProvider = "divide", description = "verify test #5", priority = 1)
    public void verifyDivide(int firstNumber, int secondNumber, int expectedResult) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(new Calculator().division(firstNumber, secondNumber), expectedResult);
    }

//    @Test(retryAnalyzer = Retry.class)
//    public void dependsOn() {
//        throw new ArithmeticException();
//    }

    @Test(alwaysRun = true, expectedExceptions = ArithmeticException.class)
    public void verifyDivisionByZero() {
        int a = 2;
        int b = 0;
        Calculator calculator = new Calculator();
        calculator.division(a, b);
    }
}
