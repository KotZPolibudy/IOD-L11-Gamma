package BuildingInfo.Services;

import BuildingInfo.Models.*;
import com.fasterxml.jackson.databind.JsonNode;

public class BuildingParser {
    public static Building parseBuildingFromJson(JsonNode buildingNode) {
        JsonNode floors = buildingNode.get("floors");
        Floor[] buildingFloors = new Floor[floors.size()];

        for (int i = 0; i < floors.size(); i++) {
            JsonNode floor = floors.get(i);
            JsonNode rooms = floor.get("rooms");
            Room[] floorRooms = new Room[rooms.size()];

            for (int j = 0; j < rooms.size(); j++) {
                JsonNode room = rooms.get(j);
                String name = room.get("name").asText();
                double surfaceArea = room.get("surfaceArea").asDouble();
                double volume = room.get("volume").asDouble();
                double lightIntensity = room.get("lightIntensity").asDouble();
                double energyConsumption = room.get("energyConsumption").asDouble();

                floorRooms[j] = new Room(name, surfaceArea, volume, lightIntensity, energyConsumption);
            }

            buildingFloors[i] = new Floor(floorRooms);
        }

        return new Building(buildingFloors);
    }
}

