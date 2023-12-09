package BuildingInfo;

public class Room {

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

    public double getSurfaceArea(){
        return this.surfaceArea;
    }
    public double getVolume(){
        return this.volume;
    }
    public double getLightIntensity(){
        return this.lightIntensity;
    }
    public double getEnergyConsumption(){
        return this.energyConsumption;
    }
}