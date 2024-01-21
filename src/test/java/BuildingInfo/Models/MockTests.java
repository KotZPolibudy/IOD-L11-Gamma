package BuildingInfo.Models;
        import java.util.ArrayList;
        import java.util.List;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

public class MockTests {

    Building mockbuilding1 = mock(Building.class);
    Building mockbuilding2 = mock(Building.class);
    Floor mockfloor1 = mock(Floor.class);
    Floor mockfloor2 = mock(Floor.class);
    Room mockroom1 = mock(Room.class);
    Room mockroom2 = mock(Room.class);
    Room mockroom3 = mock(Room.class);
    Room mockroom4 = mock(Room.class);
    Room mockroom5 = mock(Room.class);
    Room mockroom6 = mock(Room.class);


    Building testbuilding;
    Building testmockbuilding;
    Floor testfloor1;
    Floor testfloor2;

    @BeforeEach
    void setUp(){

        //config
        //when(mockbuilding1.calcEnergyConsumption()).thenReturn(5000.0);
        //when(mockbuilding2.calcEnergyConsumption()).thenReturn(6000.0);
        when(mockfloor1.calcEnergyConsumption()).thenReturn(2000.0);
        when(mockfloor2.calcEnergyConsumption()).thenReturn(2001.0);
        when(mockroom1.calcEnergyConsumption()).thenReturn(500.0);
        when(mockroom2.calcEnergyConsumption()).thenReturn(600.0);
        when(mockroom3.calcEnergyConsumption()).thenReturn(301.0);
        when(mockroom4.calcEnergyConsumption()).thenReturn(400.0);
        when(mockroom5.calcEnergyConsumption()).thenReturn(699.0);
        when(mockroom1.calcVolume()).thenReturn(100.0);
        when(mockroom2.calcVolume()).thenReturn(100.0);
        when(mockroom3.calcVolume()).thenReturn(100.0);
        when(mockroom4.calcVolume()).thenReturn(100.0);
        when(mockroom5.calcVolume()).thenReturn(100.0);
        when(mockroom1.calcSurfaceArea()).thenReturn(100.0);
        when(mockroom2.calcSurfaceArea()).thenReturn(200.0);
        when(mockroom3.calcSurfaceArea()).thenReturn(300.0);
        when(mockroom4.calcSurfaceArea()).thenReturn(400.0);
        when(mockroom5.calcSurfaceArea()).thenReturn(500.0);
        when(mockroom1.calcLightIntensity()).thenReturn(1.0);
        when(mockroom2.calcLightIntensity()).thenReturn(2.0);
        when(mockroom3.calcLightIntensity()).thenReturn(3.0);
        when(mockroom4.calcLightIntensity()).thenReturn(4.0);
        when(mockroom5.calcLightIntensity()).thenReturn(5.0);




        Room[] rooms1 = {mockroom3, mockroom4, mockroom2, mockroom5};
        Room[] rooms2 = {mockroom1, mockroom2, mockroom1, mockroom4};

        when(mockfloor1.getRooms()).thenReturn(rooms1);
        when(mockfloor2.getRooms()).thenReturn(rooms2);

        when(mockfloor1.calcSurfaceArea()).thenReturn(213.0);
        when(mockfloor2.calcSurfaceArea()).thenReturn(137.0);

        when(mockfloor1.calcLightIntensity()).thenReturn(21.0);
        when(mockfloor2.calcLightIntensity()).thenReturn(37.0);

        when(mockfloor1.calcVolume()).thenReturn(21.0);
        when(mockfloor2.calcVolume()).thenReturn(37.0);

        Floor testfloor1 = new Floor(rooms1);
        Floor testfloor2 = new Floor(rooms2);

        Floor[] floors = new Floor[2];
        floors[0] = testfloor1;
        floors[1] = testfloor2;
        testbuilding = new Building(floors);

        Floor[] mockfloors = new Floor[2];
        mockfloors[0] = mockfloor1;
        mockfloors[1] = mockfloor2;
        testmockbuilding = new Building(mockfloors);

    }

    @Test
    void test_some_room_to_find_if_mockito_works() {
        assertEquals(600.0, mockroom2.calcEnergyConsumption());
    }

    /*
    //Nadal nie rozumiem, dlaczego niby testfloor1 jest nullem. :<
    @Test
    void testFindEnergyConsumingRoomsInFloor1(){
        List<Room> pom = testfloor1.findHighConsumption(500.0);
        assertEquals(2, pom.toArray().length);
    }

    @Test
    void testFindEnergyConsumingRoomsInFloor2(){
        List<Room> pom = testfloor1.findHighConsumption(450.0);
        assertEquals(3, pom.size());
        assertEquals(3, pom.toArray().length);
    }

     */

    //Średnie zużycie dla mocków
    @Test
    void Testmockbuilding_calcenergyconsumption(){
        assertEquals(2000.5,testmockbuilding.calcEnergyConsumption());
    }

    @Test
    void placeholderTest2(){
        assertEquals(5.0,testbuilding.calcEnergyConsumption());
    }

    /*
    @Test
    void placeholderTest3(){
        assertEquals(5.0,testfloor1.calcEnergyConsumption());
    }

    @Test
    void placeholderTest4(){
        assertEquals(5.0,testfloor2.calcEnergyConsumption());
    }
     */

    @Test
    void placeholderTest5(){
        assertEquals(29.0,testmockbuilding.calcLightIntensity());
    }

    @Test
    void placeholderTest6(){
        assertEquals(350,testmockbuilding.calcSurfaceArea());
    }

    @Test
    void placeholderTest7(){
        assertEquals(58,testmockbuilding.calcVolume());
    }

    @Test
    void placeholderTest8(){
        assertEquals(2200,testbuilding.calcSurfaceArea());
    }

    @Test
    void placeholderTest9(){
        assertEquals(800,testbuilding.calcVolume());
    }

    @Test
    void placeholderTest10(){
        assertEquals(1,testbuilding.calcLightIntensity());
    }

}
