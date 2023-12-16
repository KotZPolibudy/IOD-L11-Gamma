package BuildingInfo.Controllers;

import BuildingInfo.Models.*;
import BuildingInfo.Services.RoomParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api")
public class Controller {
    private EntityParser entityParser;
    private Object entity;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping
    public String setJson(@RequestBody JsonNode jsonNode) {
        this.entityParser = new EntityParser(jsonNode);
        this.entity = this.entityParser.parse();
        return "Success";
    }

    @GetMapping("/json")
    public Object getJson() {
        return entity;
    }
}