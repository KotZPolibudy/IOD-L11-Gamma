package BuildingInfo.Controllers;

import BuildingInfo.Services.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityParser {
    private static final Logger logger = LoggerFactory.getLogger(EntityParser.class);
    public Object parse(JsonNode node) {
        Object result = null;
        if (node.has("entity")) {
            String entity = node.get("entity").asText();
            switch (entity) {
                case "building":
                    result = BuildingParser.parseBuildingFromJson(node);
                    break;
                case "floor":
                    result = FloorParser.parseFloorFromJson(node);
                    break;
                case "room":
                    result = RoomParser.parseRoomFromJson(node);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown entity: " + entity);
            }
        } else {
            throw new IllegalArgumentException("Entity not specified in JSON");
        }
        return result;
    }
}
