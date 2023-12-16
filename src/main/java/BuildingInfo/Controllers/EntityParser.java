package BuildingInfo.Controllers;

import BuildingInfo.Services.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityParser {

    private JsonNode jsonNode;

    public EntityParser() {
    }

    public EntityParser(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }
    public Object parse() {
        JsonNode node = this.jsonNode;
        Object result = null;
        if (node.has("building")) {
            result = BuildingParser.parseBuildingFromJson(node.get("building"));
        } else if (node.has("floor")) {
            result = FloorParser.parseFloorFromJson(node.get("floor"));
        } else if (node.has("room")) {
            result = RoomParser.parseRoomFromJson(node.get("room"));
        } else {
            throw new IllegalArgumentException("Unknown or missing object in JSON");
        }

        return result;
    }
}
