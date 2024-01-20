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
    Floor testfloor1;
    Floor testfloor2;

    @BeforeEach
    void setUp(){

        //config
        //when(mockbuilding1.calcEnergyConsumption()).thenReturn(5000);
        //when(mockbuilding2.calcEnergyConsumption()).thenReturn(6000);
        when(mockfloor1.calcEnergyConsumption()).thenReturn(2000);
        when(mockfloor2.calcEnergyConsumption()).thenReturn(2000);
        when(mockroom1.calcEnergyConsumption()).thenReturn(500);
        when(mockroom2.calcEnergyConsumption()).thenReturn(600);
        when(mockroom3.calcEnergyConsumption()).thenReturn(301);
        when(mockroom4.calcEnergyConsumption()).thenReturn(400);
        when(mockroom5.calcEnergyConsumption()).thenReturn(699);


        //idk czy to potrzebne będzie
        List<Room> rooms1 = new ArrayList<>();
        rooms1.add(mockroom3);
        rooms1.add(mockroom4);
        rooms1.add(mockroom2);
        rooms1.add(mockroom5);

        List<Room> rooms2 = new ArrayList<>();
        rooms2.add(mockroom1);
        rooms2.add(mockroom2);
        rooms2.add(mockroom1);
        rooms2.add(mockroom4);

        when(mockfloor1.getRooms()).thenReturn(rooms1);
        when(mockfloor2.getRooms()).thenReturn(rooms2);


        Floor testfloor1 = new Floor(new Room[]{mockroom3, mockroom4, mockroom2, mockroom5});
        Floor testfloor2 = new Floor(new Room[]{mockroom1, mockroom2, mockroom1, mockroom4});

        Floor[] floors = new Floor[2];
        floors[0] = testfloor1;
        floors[1] = testfloor2;
        testbuilding = new Building(floors);

    }


    @Test
    void testCalcSurfaceArea() {
        assertEquals(250.0, testbuilding.calcSurfaceArea());
    }




}
