package BuildingInfo;

public class Floor {

    private Room[] rooms;

    public Floor(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms(){
        return this.rooms;
    }
    public double calcSurfaceArea(){
        double sum = 0.0;
        for (Room room : this.rooms){
            sum += room.getSurfaceArea();
        }
        return sum;
    }
    public double calcVolume(){
        double sum = 0.0;
        for (Room room : this.rooms){
            sum += room.getVolume();
        }
        return sum;
    }
    public double calcLightIntensity(){
        double sum = 0.0;
        for (Room room : this.rooms){
            sum += room.getLightIntensity();
        }
        return sum;
    }
    public double calcEnergyConsumption(){
        double sum = 0.0;
        for (Room room : this.rooms){
            sum += room.getEnergyConsumption();
        }
        return sum;
    }

    public Room getRoom(int index){
        //if index < len?
        return rooms[index];
    }
}
