package BuildingInfo.Models;

import com.fasterxml.jackson.annotation.*;

public class Floor implements Entity {

    private Room[] rooms;

    /**
     * Public constructor of Floor-Entity
     * @param rooms array of Room-Entity
     */
    public Floor(Room[] rooms) {
        this.rooms = rooms;
    }

    /**
     * JSON rooms getter of Floor
     * @return array of Room-Entity
     */
    @JsonProperty("rooms")
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * Public setter of rooms
     * @param rooms array of Room-Entity
     */
    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    /**
     * Calculate surface area of Floor
     * @return surface area of Floor
     */
    @Override
    public double calcSurfaceArea() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcSurfaceArea();
        }
        return sum;
    }

    /**
     * Calculate volume of Floor
     * @return volume of Floor
     */
    @Override
    public double calcVolume() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcVolume();
        }
        return sum;
    }

    /**
     * Calculate light intensity of Floor
     * @return light intensity of Floor
     */
    @Override
    public double calcLightIntensity() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcLightIntensity();
        }
        int numberOfRooms = this.rooms.length;

        // Check if there are rooms to avoid division by zero
        if (numberOfRooms > 0) {
            return sum / numberOfRooms;
        } else {
            return 0.0; // or handle this case as per your requirement
        }
    }

    /**
     * Calculate energy consumption of Floor
     * @return energy consumption of Floor
     */
    @Override
    public double calcEnergyConsumption() {
        double sum = 0.0;
        for (Room room : this.rooms) {
            sum += room.calcEnergyConsumption();
        }
        int numberOfRooms = this.rooms.length;

        // Check if there are rooms to avoid division by zero
        if (numberOfRooms > 0) {
            return sum / numberOfRooms;
        } else {
            return 0.0; // or handle this case as per your requirement
        }
    }

}
