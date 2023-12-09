package BuildingInfo;

public class Runner {
    public static void main(){
        Building Budynek;
        Floor P1, P2;
        Room R1, R2, R3, R4, R5;

        Room[] Rlist;
        Floor[] Flist;

        R1 = new Room(20, 20, 20, 20);
        R2 = new Room(15, 15, 15, 15);
        R3 = new Room(35, 35, 35, 35);
        R4 = new Room(3, 3, 3, 3);
        R5 = new Room(6, 3, 6, 3);

        Rlist = new Room[3];
        Rlist[0] = R1;
        Rlist[1] = R2;
        Rlist[2] = R3;

        P1 = new Floor(Rlist);

        Rlist = new Room[2];
        Rlist[0] = R4;
        Rlist[1] = R5;

        P2 = new Floor(Rlist);

        Flist = new Floor[2];
        Flist[0] = P1;
        Flist[1] = P2;

        Budynek = new Building(Flist);

        System.out.print("Surface: ");
        System.out.println(Budynek.calcSurfaceArea());
        System.out.print("Volume: ");
        System.out.println(Budynek.calcVolume());
        System.out.print("Light_Intensity: ");
        System.out.println(Budynek.calcLightIntensity());
        System.out.print("energy_Consumption: ");
        System.out.println(Budynek.calcEnergyConsumption());

        System.out.print("Parter - Surface: ");
        System.out.println(Budynek.getFloor(0).calcSurfaceArea());

        System.out.print("Pierwsze piętro - zużycie energii: ");
        System.out.println(Budynek.getFloor(1).calcEnergyConsumption());

        System.out.print("Pokój 1 - parter - Surface: ");
        System.out.println(Budynek.getFloor(0).getRoom(0).getSurfaceArea());

        System.out.print("Pokój 2 - piętro 1 - Surface: ");
        System.out.println(Budynek.getFloor(1).getRoom(2-1).getSurfaceArea());


        //Get Biggest Room on first floor
        //ROOMS SHOULD HAVE "names"*   *as numbers, for example

        Floor ground = Budynek.getFloor(0);
        Room[] RArray = ground.getRooms();

        int number;
        double  maxArea = 0.0;
        for (Room r : RArray){
            if (r.getSurfaceArea() > maxArea){
                maxArea = r.getSurfaceArea();
                //number = r.getNumber();
            }
        }
        System.out.print("Room with biggest area is Room nr. _ with area of: ");
        System.out.println(maxArea);
        //This is exactly why rooms need unique IDs!!!



        




    }

}
