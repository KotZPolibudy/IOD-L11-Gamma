package BuildingInfo.Models;

import com.fasterxml.jackson.annotation.*;

public class Room implements Entity {

    private double surfaceArea;
    private double volume;
    private double lightIntensity;
    private double energyConsumption;

    public Room(double surfaceArea, double volume, double lightIntensity, double energyConsumption) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.lightIntensity = lightIntensity;
        this.energyConsumption = energyConsumption;
    }

    @JsonProperty("surfaceArea")
    public double getSurfaceArea() {
        return surfaceArea;
    }

    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("lightIntensity")
    public double getLightIntensity() {
        return lightIntensity;
    }

    @JsonProperty("energyConsumption")
    public double getEnergyConsumption() {
        return energyConsumption;
    }

    @Override
    public double calcSurfaceArea() {
        return this.surfaceArea;
    }

    @Override
    public double calcVolume() {
        return this.volume;
    }

    @Override
    public double calcLightIntensity() {
        return this.lightIntensity;
    }

    @Override
    public double calcEnergyConsumption() {
        return this.energyConsumption;
    }
}
