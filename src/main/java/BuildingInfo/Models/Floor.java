package BuildingInfo.Models;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
     * Calculate mean light intensity for surface area of Floor
     * @return mean light intensity for surface area of Floor
     */
    @Override
    public double calcLightIntensity() {
        double sumLightIntensity = 0.0;
        for (Room room : this.rooms) {
            sumLightIntensity += room.calcLightIntensity();
        }
        return sumLightIntensity / calcSurfaceArea();
    }

    /**
     * Calculate mean energy consumption for volume of Floor
     * @return mean energy consumption for volume of Floor
     */
    @Override
    public double calcEnergyConsumption() {
        double sumEnergyConsumption = 0.0;
        for (Room room : this.rooms) {
            sumEnergyConsumption += room.calcEnergyConsumption();
        }
        return sumEnergyConsumption / calcVolume();
    }

    /**
     *
     * @param limit given maximum value of room energy consumption
     * @return array of Room-Entities which energy consumption is over the limit
     */
    @Override
    public List<Room> findHighConsumption(double limit) {
        List<Room> highConsumptionEntities = new ArrayList<>();
        for (Room room : this.getRooms()) {
            if (room.calcEnergyConsumption() > limit){
                highConsumptionEntities.add(room);
            }
        }
        return highConsumptionEntities;
    }

}
