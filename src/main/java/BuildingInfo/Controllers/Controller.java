package BuildingInfo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/Volume")
    public Map<String, Double> calculateVolume() {
        Map<String, Double> response = new HashMap<>();
        try {
            Method method = entity.getClass().getMethod("calcVolume");
            double volume = (double) method.invoke(entity);
            response.put("volume", volume);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking calcVolume() method");
        }
        return response;
    }

    @GetMapping("/SurfaceArea")
    public Map<String, Double> calculateSurfaceArea() {
        Map<String, Double> response = new HashMap<>();
        try {
            Method method = entity.getClass().getMethod("calcSurfaceArea");
            double surfaceArea = (double) method.invoke(entity);
            response.put("surfaceArea", surfaceArea);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking calcSurfaceArea() method");
        }
        return response;
    }

    @GetMapping("/LightIntensity")
    public Map<String, Double> calculateLightIntensity() {
        Map<String, Double> response = new HashMap<>();
        try {
            Method method = entity.getClass().getMethod("calcLightIntensity");
            double lightIntensity = (double) method.invoke(entity);
            response.put("lightIntensity", lightIntensity);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking calcLightIntensity() method");
        }
        return response;
    }

    @GetMapping("/EnergyConsumption")
    public Map<String, Double> calculateEnergyConsumption() {
        Map<String, Double> response = new HashMap<>();
        try {
            Method method = entity.getClass().getMethod("calcEnergyConsumption");
            double energyConsumption = (double) method.invoke(entity);
            response.put("energyConsumption", energyConsumption);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking calcEnergyConsumption() method");
        }
        return response;
    }gi

}