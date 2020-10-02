# N11 Smoke Test Automation with Selenium using Page Object Design Pattern

**Page Object is a Design Pattern** which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented class that serves as an interface to a page of your AUT. The tests then use the methods of this page object class whenever they need to interact with the UI of that page. 
The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently all changes to support that new UI are located in one place.


**Tech Stack**

* [Selenium Webdriver](https://www.selenium.dev/documentation/en/webdriver/) -  Web Automation Framework
* [Java JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)- Development Kit
* [JUnit](https://junit.org/junit4/index.html) -Java Unit Testing Framework
* [Maven](https://maven.apache.org/index.html) - Build System
* [Intellij](https://www.jetbrains.com/idea/download/#section=windows) - IDE



**Running Test** 

Execute any of the following commands to run tests:

```sh
mvn clean install
```
    
```sh
mvn -Dtest=N11SmokeTest test
```


**NOTE:** You should update [configdatafile.properties](src/test/resources/configdatafile.properties) with valid **"loginEmail"** and **"loginPassword"** values before test execution.



**Running test methods in order with Junit**

 For running test methods in same class in order with Junit especially where the steps are dependent on each other , use *"@FixMethodOrder"* annotation with approprite value.
 
 **"@FixMethodOrder(MethodSorters.NAME_ASCENDING)" :** Sorts the test methods by method name, in lexicographic order.
 
 For more information : https://github.com/junit-team/junit4/wiki/Test-execution-order


**NOTE:** You can find manual test case documentation here --> [manualtestcase.docx](src/test/resources/manualtestcase.docx)
