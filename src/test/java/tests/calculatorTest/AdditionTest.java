package tests.calculatorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Calculator;

import static org.testng.Assert.assertEquals;

public class AdditionTest {

    @DataProvider(parallel = true)
    public Object[][] sum() {
        return new Object[][]{
                {3, 5, 8},
                {5, -13, -8},
                {0, 14, 14},
                {23, 0, 23},
                {-27, -24, -51}
        };
    }

    @Test(dataProvider = "sum", priority = 2)
    public void verifySum(int firstNumber, int secondNumber, int expectedResult) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
        int result = calculator.addition(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
        final Thread thread = Thread.currentThread();
        System.out.printf("#%d %s: %s : %s", thread.getId(), thread.getName(), firstNumber, secondNumber);
        System.out.println();
    }
}


/*
В тестах заиспользовать аннотации и параметры TestNG.
Обязательные:
@BeforeMethod, +
@AfterMethod, +
dataProvider, +
запуск в параллели, +
retryAnalyzer, +
description, +
priority, +
invocationCount, +
threadPoolSize +
 */