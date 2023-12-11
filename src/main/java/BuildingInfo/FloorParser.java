package BuildingInfo;

import com.fasterxml.jackson.databind.JsonNode;

public class FloorParser {
    public static Floor parseFloorFromJson(JsonNode floorNode) {
        JsonNode floor = floorNode.get("floor");
        JsonNode rooms = floor.get("rooms");
        Room[] floorRooms = new Room[rooms.size()];

        for (int j = 0; j < rooms.size(); j++) {
            JsonNode room = rooms.get(j);
            double surfaceArea = room.get("surfaceArea").asDouble();
            double volume = room.get("volume").asDouble();
            double lightIntensity = room.get("lightIntensity").asDouble();
            double energyConsumption = room.get("energyConsumption").asDouble();

            floorRooms[j] = new Room(surfaceArea, volume, lightIntensity, energyConsumption);
        }

        return new Floor(floorRooms);
    }
}
