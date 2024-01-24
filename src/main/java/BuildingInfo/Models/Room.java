package BuildingInfo.Models;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"name", "surfaceArea", "volume", "lightIntensity", "energyConsumption"})
public class Room implements Entity {
    private double surfaceArea;
    private double volume;
    private double lightIntensity;
    private double energyConsumption;
    private String name;

    /**
     * Public constructor of Room-Entity
     * @param name String of characters, given name of Room
     * @param surfaceArea positive value, given surface area of Room
     * @param volume positive value, given volume of Room
     * @param lightIntensity positive value, given light intensity of Room
     * @param energyConsumption positive value, given energy consumption of Room
     */
    public Room(String name, double surfaceArea, double volume, double lightIntensity, double energyConsumption) {
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.lightIntensity = lightIntensity;
        this.energyConsumption = energyConsumption;
    }

    /**
     * JSON name getter of Room
     * @return name of Room
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * JSON surface area getter of Room
     * @return surface area of Room
     */
    @JsonProperty("surfaceArea")
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * JSON volume getter of Room
     * @return volume of Room
     */
    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    /**
     * JSON light intensity getter of Room
     * @return light intensity of Room
     */
    @JsonProperty("lightIntensity")
    public double getLightIntensity() {
        return lightIntensity;
    }

    /**
     * JSON energy consumption getter of Room
     * @return energy consumption of Room
     */
    @JsonProperty("energyConsumption")
    public double getEnergyConsumption() {
        return energyConsumption;
    }

    /**
     * Calculate surface area of Room
     * @return surface area of Room
     */
    @Override
    public double calcSurfaceArea() {
        return this.surfaceArea;
    }

    /**
     * Calculate volume of Room
     * @return volume of Room
     */
    @Override
    public double calcVolume() {
        return this.volume;
    }

    /**
     * Calculate light intensity of Room
     * @return light intensity of Room
     */
    @Override
    public double calcLightIntensity() {
        return this.lightIntensity;
    }

    /**
     * Calculate energy consumption of Room
     * @return energy consumption of Room
     */
    @Override
    public double calcEnergyConsumption() {
        return this.energyConsumption;
    }

    /**
     *
     * @param limit given maximum value of room energy consumption
     * @return array of Room-Entities which energy consumption is over the limit
     */
    @Override
    public List<String> findHighConsumption(double limit) {
        List<String> highConsumptionEntities = new ArrayList<>();
        if (this.energyConsumption > limit) {
            highConsumptionEntities.add(this.name);
        }
        return highConsumptionEntities;
    }
}
