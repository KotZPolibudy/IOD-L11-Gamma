import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello and welcome!"); // Logs at the INFO level

        BuildingInfo.Runner.main();

        // Example debug.log
        if (logger.isDebugEnabled()) {
            logger.debug("Place this when debugging"); // Logs at the DEBUG level
        }
        //Example of logger.warn
        //logger.warn("Possible memory leak detected");
        //Example of logger.error
        /*try {
            int result = 1/0;
            logger.info("Division result: {}", result);
        } catch (ArithmeticException ex) {
            logger.error("Error occurred during division: {}", ex.getMessage());
        }*/
    }
}
