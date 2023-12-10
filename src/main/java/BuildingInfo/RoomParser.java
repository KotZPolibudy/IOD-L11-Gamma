package BuildingInfo;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoomParser {
    private static final Logger logger = LoggerFactory.getLogger(RoomParser.class);

    public static Room parseRoomFromJson(JsonNode roomNode) {
        JsonNode room = roomNode.get("room");
        double surfaceArea = room.get("surfaceArea").asDouble();
        double volume = room.get("volume").asDouble();
        double lightIntensity = room.get("lightIntensity").asDouble();
        double energyConsumption = room.get("energyConsumption").asDouble();

        return new Room(surfaceArea, volume, lightIntensity, energyConsumption);
    }
}
