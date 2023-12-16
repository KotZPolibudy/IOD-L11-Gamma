package BuildingInfo.Services;

import BuildingInfo.Controllers.Controller;
import BuildingInfo.Models.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloorParser {

    private static final Logger logger = LoggerFactory.getLogger(FloorParser.class);
    public static Floor parseFloorFromJson(JsonNode floorNode) {
        JsonNode roomsNode = floorNode.get("rooms");
        Room[] floorRooms = new Room[roomsNode.size()];

        for (int j = 0; j < roomsNode.size(); j++) {
            JsonNode room = roomsNode.get(j);
            double surfaceArea = room.get("surfaceArea").asDouble();
            double volume = room.get("volume").asDouble();
            double lightIntensity = room.get("lightIntensity").asDouble();
            double energyConsumption = room.get("energyConsumption").asDouble();

            floorRooms[j] = new Room(surfaceArea, volume, lightIntensity, energyConsumption);
        }

        return new Floor(floorRooms);
    }
}
