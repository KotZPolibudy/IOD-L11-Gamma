package BuildingInfo.Models;

public class Building implements Entity {

    private Floor[] floors;

    public Building(Floor[] floors) {
        this.floors = floors;
    }

    // Other methods and constructors

    @Override
    public double calcSurfaceArea() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcSurfaceArea();
        }
        return sum;
    }

    @Override
    public double calcVolume() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcVolume();
        }
        return sum;
    }

    @Override
    public double calcLightIntensity() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcLightIntensity();
        }
        return sum;
    }

    @Override
    public double calcEnergyConsumption() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcEnergyConsumption();
        }
        return sum;
    }

    // Other methods from the Building class
}
