package BuildingInfo.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    Floor testfloor;
    @BeforeEach
    void setUp(){
        testfloor = new Floor(new Room[]{
            new Room("Room 1", 70, 50, 30, 90),
            new Room("Room 2", 30, 40, 50, 100),
            new Room("Room 3", 100, 105, 20, 200)
        });
    }


    @Test
    void testGetRooms() {
        Room[] testRooms = testfloor.getRooms();
        assertEquals(testRooms[0].getSurfaceArea(), 70);
        assertEquals(testRooms[1].getSurfaceArea(), 30);
        assertEquals(testRooms[2].getSurfaceArea(), 100);
    }

    @Test
    void testSetRooms() {
        Room[] testRooms = new Room[]{
                new Room("Room 4", 10, 25, 50, 50),
                new Room("Room 5", 40, 40, 40, 40)
        };
        testfloor.setRooms(testRooms);
        Room[] setRooms = testfloor.getRooms();
        assertEquals(setRooms[0].getSurfaceArea(), testRooms[0].getSurfaceArea());
        assertEquals(setRooms[1].getSurfaceArea(), testRooms[1].getSurfaceArea());
    }

    @Test
    void testCalcSurfaceArea() {
        assertEquals(testfloor.calcSurfaceArea(), 200);
    }

    @Test
    void testCalcVolume() {
        assertEquals(testfloor.calcVolume(), 195);
    }

    @Test
    void testCalcLightIntensity() {
        assertEquals(testfloor.calcLightIntensity(), 0.5);
    }

    @Test
    void testCalcEnergyConsumption() {
        assertEquals(testfloor.calcEnergyConsumption(), 2.0);
    }

    @Test
    void testFindHighConsumption() {
        List<Room> rooms = testfloor.findHighConsumption(150);
        assertEquals(rooms.get(0).getEnergyConsumption(), 200);
    }
}