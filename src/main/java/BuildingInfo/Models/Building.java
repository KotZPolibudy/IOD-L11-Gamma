package BuildingInfo.Models;

import com.fasterxml.jackson.annotation.*;

public class Building implements Entity {

    private Floor[] floors;

    /**
     * Public constructor of Building-Entity
     * @param floors array of Floor-Entity
     */
    public Building(Floor[] floors) {
        this.floors = floors;
    }

    /**
     * JSON floors getter of Building
     * @return array of Floor-Entity
     */
    @JsonProperty("floors")
    public Floor[] getFloors() {
        return floors;
    }

    /**
     * Public setter of floors
     * @param floors array of Floor-Entity
     */
    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    /**
     * Calculate surface area of Building
     * @return surface area of Building
     */
    @Override
    public double calcSurfaceArea() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcSurfaceArea();
        }
        return sum;
    }

    /**
     * Calculate volume of Building
     * @return volume of Building
     */
    @Override
    public double calcVolume() {
        double sum = 0.0;
        for (Floor floor : this.floors) {
            sum += floor.calcVolume();
        }
        return sum;
    }

    /**
     * Calculate average light intensity of Building per Floor
     * @return average light intensity of Building per Floor
     */
    @Override
    public double calcLightIntensity() {
        double sum = 0.0;
        int totalFloors = this.floors.length;

        for (Floor floor : this.floors) {
            sum += floor.calcLightIntensity();
        }

        // Check if there are floors to avoid division by zero
        if (totalFloors > 0) {
            return sum / totalFloors;
        } else {
            return 0.0; // or handle this case as per your requirement
        }
    }

    /**
     * Calculate average energy consumption of Building per Floor
     * @return average energy consumption of Building per Floor
     */
    @Override
    public double calcEnergyConsumption() {
        double sum = 0.0;
        int totalFloors = this.floors.length;

        for (Floor floor : this.floors) {
            sum += floor.calcEnergyConsumption();
        }

        // Check if there are floors to avoid division by zero
        if (totalFloors > 0) {
            return sum / totalFloors;
        } else {
            return 0.0; // or handle this case as per your requirement
        }
    }
}
