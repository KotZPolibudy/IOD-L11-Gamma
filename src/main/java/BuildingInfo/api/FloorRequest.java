package BuildingInfo.api;

import java.util.List;

public class FloorRequest {
    private List<RoomRequest> rooms;

    public List<RoomRequest> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequest> rooms) {
        this.rooms = rooms;
    }
    // Add getters and setters for other properties if needed
}
