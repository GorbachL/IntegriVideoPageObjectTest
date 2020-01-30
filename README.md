-1- Обновить версии всех библиотек в проекте

 > mvn versions:display-dependency-updates
- BUILD SUCCESS

-2- Запустить тесты используя mvn clean test команду
 
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

-4- Создать альтернативный pom.xml и запустить из него mvn билд

-5- Пробросить параметр из mvn command line внутрь теста
