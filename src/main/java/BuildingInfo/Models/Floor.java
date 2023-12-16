package BuildingInfo.Models;

public class Floor implements Entity {

    private Room[] rooms;

    public Floor(Room[] rooms) {
        this.rooms = rooms;
    }

    // Other methods and constructors

    @Override
    public double calcSurfaceArea() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcSurfaceArea();
        }
        return sum;
    }

    @Override
    public double calcVolume() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcVolume();
        }
        return sum;
    }

    @Override
    public double calcLightIntensity() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcLightIntensity();
        }
        return sum;
    }

    @Override
    public double calcEnergyConsumption() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcEnergyConsumption();
        }
        return sum;
    }

    // Other methods from the Floor class
}
