import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


class BusesTest {
    @Test
    void addBus() throws Exception {
        Buses bus = new Buses();
        String[] stops = {"47", "48"};
        int count = bus.addBus("first", stops );
        Assertions.assertEquals("1 first [47, 48]\n", bus.toString());
        Assertions.assertEquals(1, count);
    }

    @Test
    void addBusException() throws Exception {
        Buses bus = new Buses();
        String[] stops = {"47", "48"};
        bus.addBus("first", stops );
        Assertions.assertThrows(Exception.class,()->{bus.addBus("first", stops );});
    }

    @Test
    void sBusesToStop() throws Exception {
        Buses bus = new Buses();
        String[] stops1 = {"first", "second"};
        String[] stops2 = {"first", "third"};
        String[] stops3 = {"third", "second"};
        bus.addBus("47", stops1 );
        bus.addBus("48", stops2);
        bus.addBus("49", stops3);
        List<String> resBus = new ArrayList<>();
        resBus.add("47");
        resBus.add("48");
        Assertions.assertEquals(resBus, bus.sbusesForStop("first"));
    }

    @Test
    void sBusesToStopException() throws Exception {
        Buses bus = new Buses();
        String[] stops1 = {"first", "second"};
        bus.addBus("47", stops1 );
        Assertions.assertThrows(Exception.class,()->{bus.sbusesForStop("third");});
    }

    @Test
    void nBusesToStop() throws Exception {
        Buses bus = new Buses();
        String[] stops1 = {"first", "second"};
        String[] stops2 = {"first", "third"};
        String[] stops3 = {"third", "second"};
        bus.addBus("47", stops1 );
        bus.addBus("48", stops2);
        bus.addBus("49", stops3);
        List<String> resBus = new ArrayList<>();
        resBus.add("47");
        resBus.add("48");
        Assertions.assertEquals(resBus, bus.sbusesForStop("first"));
    }
}