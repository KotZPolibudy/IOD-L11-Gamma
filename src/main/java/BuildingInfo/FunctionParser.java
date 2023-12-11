package BuildingInfo;

import com.fasterxml.jackson.databind.JsonNode;

public class FunctionParser {
    public String parseFunction(JsonNode node) {
        if (node.has("function")) {
            return node.get("function").asText();
        } else {
            throw new IllegalArgumentException("Function not specified in JSON");
        }
    }
}
