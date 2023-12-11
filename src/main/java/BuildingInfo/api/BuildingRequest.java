package BuildingInfo.api;

import java.util.List;

public class BuildingRequest {
    private List<FloorRequest> floors;

    public List<FloorRequest> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorRequest> floors) {
        this.floors = floors;
    }
    // Add getters and setters for other properties if needed
}