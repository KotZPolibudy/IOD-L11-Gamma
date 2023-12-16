import BuildingInfo.Controllers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Hello and welcome!"); // Logs at the INFO level
        // Load the JSON file for testing
        String jsonFilePath = "src/main/resources/test_building2.json"; // Update with your file path

        try {
            String Json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Pass the loaded JSON to the Runner class
            Runner.main(Json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
