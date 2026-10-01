package P191_UnitTesting;

import org.junit.*;
import org.junit.Test;

public class StringUtilTest { //right click here or the module-directory to automatically run all test methods below
    //Unit Testing (单元测试): testing the accuracy of every method
    //JUnit framework

    //Procedure
    //1.Import the JUnit Framework Jar File into the Project
    //IDEA has integrated the JUnit framework, so manual import is not required

    //2.Define a Test Class for the Business Class to be Tested
    //For each business method, write a corresponding test method (must be public, parameterless, and void
    //@Test can only annotate static test methods

    //3.Annotate the Test Method with @Test
    //In the test method, write code to call the business method being tested

    @Test //ALT + ENTER to import JUnit framework here
    public void testPrintNumber() {
        StringUtil.printNumber("admin");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        int index1 = StringUtil.getMaxIndex(null);
        System.out.println(index1);

        int index2 = StringUtil.getMaxIndex("admin");
        System.out.println(index2); //no Exception, but we need it to be 4 instead of 5
        //Assertion Mechanism 断言机制
        Assert.assertEquals("Error Occurs", 4, index2);
    }

    //4.Run the Test Method
    //Directly run the test method, it will show green; if it fails, it will show red


    //Other annotations

    //@Before (@BeforeEach in JUnit 5):
    //for instance test methods
    //run the methods before EACH test method
    //usually used for initializing resources
    @Before
    public void testBefore() {
        System.out.println("---> test @Before has been executed!");
    }

    //@After (@AfterEach in JUnit 5):
    //for instance test methods
    //run the methods after EACH test method
    //usually used for releasing resources
    @After
    public void testAfter() {
        System.out.println("---> test @After has been executed!");
    }

    //@BeforeClass (@BeforeAll in JUnit 5):
    //for static test methods
    //run the methods ONCE before All test method
    //usually used for initializing resources
    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("---> test @BeforeClass has been executed!");
    }

    //@AfterClass (@AfterAll in JUnit 5):
    // for static test methods
    //run the methods ONCE after All test method
    //usually used for releasing resources
    @AfterClass
    public static void testAfterClass() {
        System.out.println("---> test @AfterClass has been executed!");
    }
}
