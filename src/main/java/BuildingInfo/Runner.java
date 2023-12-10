package BuildingInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main() {
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

        logger.info("Surface: {}", Budynek.calcSurfaceArea());
        logger.info("Volume: {}", Budynek.calcVolume());
        logger.info("Light_Intensity: {}", Budynek.calcLightIntensity());
        logger.info("energy_Consumption: {}", Budynek.calcEnergyConsumption());

        logger.info("Parter - Surface: {}", Budynek.getFloor(0).calcSurfaceArea());
        logger.info("Pierwsze piętro - zużycie energii: {}", Budynek.getFloor(1).calcEnergyConsumption());

        logger.info("Pokój 1 - parter - Surface: {}", Budynek.getFloor(0).getRoom(0).getSurfaceArea());
        logger.info("Pokój 2 - piętro 1 - Surface: {}", Budynek.getFloor(1).getRoom(2 - 1).getSurfaceArea());

        Floor ground = Budynek.getFloor(0);
        Room[] RArray = ground.getRooms();

        double maxArea = 0.0;
        for (Room r : RArray) {
            if (r.getSurfaceArea() > maxArea) {
                maxArea = r.getSurfaceArea();
            }
        }
        logger.info("Room with biggest area has an area of: {}", maxArea);
    }
}
