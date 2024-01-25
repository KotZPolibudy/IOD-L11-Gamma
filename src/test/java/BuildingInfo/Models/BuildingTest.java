package BuildingInfo.Models;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingTest {

    Building testbuilding;

    @BeforeEach
    void setUp(){
        Floor floor1 = new Floor(new Room[]{
                new Room("Room 1", 20, 50, 30, 60),
                new Room("Room 2", 80, 40, 50, 100),
                new Room("Room 3", 100, 270, 20, 200)});
        Floor floor2 = new Floor(new Room[]{
                new Room("Room 4", 10, 20, 50, 50),
                new Room("Room 5", 40, 40, 50, 40)
        });
        Floor[] floors = new Floor[2];
        floors[0] = floor1;
        floors[1] = floor2;
        testbuilding = new Building(floors);
    }



    @Test
    void testCalcSurfaceArea() {
        assertEquals(250.0, testbuilding.calcSurfaceArea());
    }

    @Test
    void testCalcVolume() {
        assertEquals(420.0, testbuilding.calcVolume() );
    }

    @Test
    void testCalcLightIntensity() {
        assertEquals(1.25, testbuilding.calcLightIntensity());
    }

    @Test
    void testCalcEnergyConsumption() {
        assertEquals(1.25, testbuilding.calcEnergyConsumption());
    }

    @Test
    void testFindHighConsumption() {
        List<String> rooms = testbuilding.findHighConsumption(150);
        assertEquals(rooms.get(0), "Room 3");
    }
    @Test
    void testGetFloors() {
        Floor floor1 = new Floor(new Room[]{new Room("Room 1", 20, 50, 30, 60),
                new Room("Room 2", 30, 40, 50, 100),
                new Room("Room 3", 100, 300, 20, 200)});
        Floor floor2 = new Floor(new Room[]{
                new Room("Room 4", 10, 20, 50, 50),
                new Room("Room 5", 40, 40, 40, 40)
        });

        Floor[] testFloors = new Floor[2];
        testFloors[0] = floor1;
        testFloors[1] = floor2;
        Floor[] setFloors = testbuilding.getFloors();
        assertEquals(setFloors.length, testFloors.length);
        for(int i = 0; i < setFloors.length; ++i){
            Room[] testRooms = testFloors[i].getRooms();
            Room[] setRooms = setFloors[i].getRooms();
            assertEquals(setRooms.length, testRooms.length);
            for(int j = 0; j < setRooms.length; ++j){
                assertEquals(testRooms[i].getSurfaceArea(), setRooms[i].getSurfaceArea());
            }
        }
    }
    @Test
    void testSetFloors() {
        Floor floor1 = new Floor(new Room[]{new Room("Room 1", 235, 5, 30, 12),
                new Room("Room 2", 353, 40, 50, 100),
                new Room("Room 3", 105, 339, 20, 20)});
        Floor floor2 = new Floor(new Room[]{
                new Room("Room 412", 15, 25, 50, 50),
                new Room("Room 5", 45, 40, 40, 405)
        });
        Floor[] testFloors = new Floor[2];
        testFloors[0] = floor1;
        testFloors[1] = floor2;
        testbuilding.setFloors(testFloors);
        Floor[] setFloors = testbuilding.getFloors();
        assertEquals(setFloors.length, testFloors.length);
        for(int i = 0; i < setFloors.length; ++i){
            Room[] testRooms = testFloors[i].getRooms();
            Room[] setRooms = setFloors[i].getRooms();
            assertEquals(setRooms.length, testRooms.length);
            for(int j = 0; j < setRooms.length; ++j){
                assertEquals(testRooms[i].getSurfaceArea(), setRooms[i].getSurfaceArea());
            }
        }
    }
}