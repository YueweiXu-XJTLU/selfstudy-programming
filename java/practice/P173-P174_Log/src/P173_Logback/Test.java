package P173_Logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    //Logback(Log Framework) implements SLF4J(Simple Logging Facade for Java)(Log Interface)

    //Logback is divided into three modules
    //1. logback-core(strictly necessary): lays the groundwork for the other two modules
    //2. logback-classic(strictly necessary): natively implements the SLF4J-API(strictly necessary)
    //3. logback-access(NOT strictly necessary): integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality
    //*. a core profile: logback.xml is also strictly necessary to put directly under src-directory

    //Procedure to use:
    //1. create a Logger Object (Usually the unique Logger Object in a project(static), public to every members(public) and unrepealable(final)
    //2. call LoggerFactory.getLogger("Name")
    public static final Logger LOGGER = LoggerFactory.getLogger("LogbackTest");
    //3. use the Logger Object inside the codes

    public static void main(String[] args) {
        while (true) {
            try {
                //3.1. successfully-run: info()
                LOGGER.info("Division method begins!");
                division(10,0);
                LOGGER.info("Division method finishes!");
            } catch (Exception e) {
                //3.2. error-occur: error()
                LOGGER.error("Division method stops because of BUG!");
            }
        }

    }

    public static void division(int a, int b) {
        //3.3. execution-process-record: debug()
        LOGGER.debug("parameter a: " + a);
        LOGGER.debug("parameter b: " + b);
        int c = a / b;
        LOGGER.debug("Result is: " + c);
    }
}
