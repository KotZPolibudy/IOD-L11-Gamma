package BuildingInfo.Services;

import BuildingInfo.Models.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoomParser {
    private static final Logger logger = LoggerFactory.getLogger(RoomParser.class);

    /**
     *
     * @param roomNode JSON node having information for room construction
     * @return Room-Entity created from given informations
     */
    public static Room parseRoomFromJson(JsonNode roomNode) {
        String name = roomNode.get("name").asText();
        double surfaceArea = roomNode.get("surfaceArea").asDouble();
        double volume = roomNode.get("volume").asDouble();
        double lightIntensity = roomNode.get("lightIntensity").asDouble();
        double energyConsumption = roomNode.get("energyConsumption").asDouble();

        return new Room(name, surfaceArea, volume, lightIntensity, energyConsumption);
    }
}
