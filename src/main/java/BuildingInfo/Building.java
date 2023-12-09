package BuildingInfo;

public class Building {

    private Floor[] floors;

    public Building(Floor[] floors) {
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return this.floors;
    }
    public double calcSurfaceArea(){
        double sum = 0.0;
        for (Floor floor : this.floors){
            sum += floor.calcSurfaceArea();
        }
        return sum;
    }
    public double calcVolume(){
        double sum = 0.0;
        for (Floor floor : this.floors){
            sum += floor.calcVolume();
        }
        return sum;
    }
    public double calcLightIntensity(){
        double sum = 0.0;
        for (Floor floor : this.floors){
            sum += floor.calcLightIntensity();
        }
        return sum;
    }
    public double calcEnergyConsumption(){
        double sum = 0.0;
        for (Floor floor : this.floors){
            sum += floor.calcEnergyConsumption();
        }
        return sum;
    }

    public Floor getFloor(int index){
        //if index < len?
        return floors[index];
    }


}
