-1- Обновить версии всех библиотек в проекте

 > mvn versions:display-dependency-updates
- BUILD SUCCESS

-2- Запустить тесты используя mvn clean test команду
 
 # Run all the unit test classes.
 - > mvn clean test
 - Tests run: 45, Failures: 0, Errors: 0, Skipped: 0
 - BUILD SUCCESS
 
-3- Использовать параметры для запуска конкретных тестов и методов 
(может быть затык с запуск нескольких методов, здесь документация 
https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html , 
для работы необходим обновленный maven-surefire-plugin, 
как обновить написано здесь http://maven.apache.org/surefire/maven-surefire-plugin/usage.html ) 

> mvn versions:display-plugin-updates
 - BUILD SUCCESS
 
*** 
 # Run a single test class.
> mvn -Dtest=MultiplicationTest test
 
 [INFO]  T E S T S
 [INFO] -------------------------------------------------------
 [INFO] Running tests.calculatorTest.MultiplicationTest
 [INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 15.524 s - in tests.calculatorTest.MultiplicationTest
 [INFO]
 [INFO] Results:
 [INFO]
 [INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
 [INFO]
 [INFO] ------------------------------------------------------------------------
 [INFO] BUILD SUCCESS
 [INFO] ------------------------------------------------------------------------
 [INFO] Total time:  17.908 s
 [INFO] Finished at: 2020-01-29T18:46:32+03:00
 
***
 # Run a single test method from a test class.
 > mvn -Dtest=AdditionTest#verifySum test

[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running tests.calculatorTest.AdditionTest
#16 TestNG-PoolService-4: -27 : -24
#15 TestNG-PoolService-3: 23 : 0
#13 TestNG-PoolService-1: 5 : -13
#14 TestNG-PoolService-2: 0 : 14
#12 TestNG-PoolService-0: 3 : 5
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.447 s - in tests.calculatorTest.AdditionTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.948 s
[INFO] Finished at: 2020-01-29T18:50:13+03:00
[INFO] ------------------------------------------------------------------------

***
 # Run multiple methods from a test class. 
 > mvn -Dtest=DivisionTest#verifyDivide+verifyDivisionByZero test

[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running tests.calculatorTest.DivisionTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.472 s - in tests.calculatorTest.DivisionTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.011 s
[INFO] Finished at: 2020-01-29T18:53:13+03:00
[INFO] ------------------------------------------------------------------------

***
 # Run multiple test classes.
> mvn -Dtest=DivisionTest,SubtractionTest test

[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
Run the latest tests.
All tests have been run.
Run the latest tests.
All tests have been run.
Run the latest tests.
All tests have been run.
Run the latest tests.
All tests have been run.
Run the latest tests.
All tests have been run.
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 19.615 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  24.664 s
[INFO] Finished at: 2020-01-30T13:35:12+03:00
[INFO] ------------------------------------------------------------------------

***

-4- Создать альтернативный pom.xml и запустить из него mvn билд //

 > mvn -f{path-to-another/pom.xml}

mvn -f pom.xml test
mvn -f myPom.xml test


-5- Пробросить параметр из mvn command line внутрь теста //

 > mvn -Dtest=DivisionTest#runTest -DtestProp=NEW-prop-set test

[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running tests.calculatorTest.DivisionTest
testProp is set to: NEW-prop-set
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.409 s - in tests.calculatorTest.DivisionTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.616 s
[INFO] Finished at: 2020-02-03T13:14:06+03:00
[INFO] ------------------------------------------------------------------------

***