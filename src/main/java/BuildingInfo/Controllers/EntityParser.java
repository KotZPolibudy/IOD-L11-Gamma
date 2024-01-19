package BuildingInfo.Controllers;

import BuildingInfo.Services.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityParser {

    private JsonNode jsonNode;

    /**
     * Public constructor of EntityParser
     */
    public EntityParser() {
    }

    /**
     * Setter entity parser
     * @param jsonNode json node
     */
    public EntityParser(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    /**
     * Getter of json node
     * @return json node
     */
    public JsonNode getJsonNode() {
        return jsonNode;
    }

    /**
     * Setter of json node
     * @param jsonNode json node
     */
    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    /**
     * Object parser
     * @return parse of given Entity (Room / Floor / Building)
     */
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
