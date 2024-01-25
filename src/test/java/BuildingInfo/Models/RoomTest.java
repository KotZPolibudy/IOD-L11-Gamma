package BuildingInfo.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    Room testroom;
    @BeforeEach
    void setUp(){
        testroom = new Room("TestRoom", 40.0, 80.0, 20.0, 40.0);
    }

    @Test
    void getSurfaceArea() {
        assertEquals(testroom.getSurfaceArea(), 40.0);
    }

    @Test
    void getVolume() {
        assertEquals(testroom.getVolume(), 80.0);
    }

    @Test
    void getLightIntensity() {
        assertEquals(testroom.getLightIntensity(), 20.0);
    }

    @Test
    void getEnergyConsumption() {
        assertEquals(testroom.getEnergyConsumption(), 40.0);
    }

    @Test
    void calcSurfaceArea() {
        assertEquals(testroom.calcSurfaceArea(), 40.0);
    }

    @Test
    void calcVolume() {
        assertEquals(testroom.calcVolume(), 80.0);
    }

    @Test
    void calcLightIntensity() {
        assertEquals(testroom.calcLightIntensity(), 20.0);
    }

    @Test
    void calcEnergyConsumption() {
        assertEquals(testroom.getEnergyConsumption(), 40.0);
    }

    @Test
    void findHighConsumption() {
        List<String> rooms = testroom.findHighConsumption(30.0);
        assertEquals(rooms.get(0), "TestRoom");
    }
}