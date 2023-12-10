import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Hello and welcome!"); // Logs at the INFO level
        // Load the JSON file for testing
        String jsonFilePath = "src/main/resources/test_building.json"; // Update with your file path

        try {
            String buildingJson = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Example:
            logger.info("Loaded JSON: {}", buildingJson);
            // Perform further operations with the 'buildingJson' string

        } catch (Exception e) {
            e.printStackTrace();
        }

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
