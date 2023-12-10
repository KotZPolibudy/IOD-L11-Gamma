package BuildingInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String buildingJson) {
        // Example:
        logger.info("Loaded JSON: {}", buildingJson);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode buildingNode = objectMapper.readTree(buildingJson);

            Building building = BuildingParser.parseBuildingFromJson(buildingNode);

            performBuildingOperations(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void performBuildingOperations(Building building) {
        double surfaceArea = building.calcSurfaceArea();
        double volume = building.calcVolume();
        double lightIntensity = building.calcLightIntensity();
        double energyConsumption = building.calcEnergyConsumption();

        logger.info("Surface: {}", surfaceArea);
        logger.info("Volume: {}", volume);
        logger.info("Light Intensity: {}", lightIntensity);
        logger.info("Energy Consumption: {}", energyConsumption);
        // You can perform other operations as needed
    }

}
