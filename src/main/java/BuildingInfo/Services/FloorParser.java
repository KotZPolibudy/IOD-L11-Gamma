package BuildingInfo.Services;

import BuildingInfo.Controllers.Controller;
import BuildingInfo.Models.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloorParser {

    public static Floor parseFloorFromJson(JsonNode floorNode) {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(ch.qos.logback.classic.Level.DEBUG);
        JsonNode roomsNode = floorNode.get("rooms");
        Room[] floorRooms = new Room[roomsNode.size()];
        logger.info("Rooms loaded succesully");
        for (int j = 0; j < roomsNode.size(); j++) {
            JsonNode room = roomsNode.get(j);
            String name = room.get("name").asText();
            double surfaceArea = room.get("surfaceArea").asDouble();
            double volume = room.get("volume").asDouble();
            double lightIntensity = room.get("lightIntensity").asDouble();
            double energyConsumption = room.get("energyConsumption").asDouble();
            logger.debug("Energy Conspumption {}", energyConsumption);
            floorRooms[j] = new Room(name, surfaceArea, volume, lightIntensity, energyConsumption);
        }

        return new Floor(floorRooms);
    }
}
