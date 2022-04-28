import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Bus {

    private final int number;
    private final String name;
    private final List<String> busStop = new ArrayList<>();

    public Bus(int number, String name, String[] stops) {
        this.number = number;
        this.name = name;
        Collections.addAll(busStop, stops);
    }

    public void add(String str) {
        busStop.add(str);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != getClass())
            return false;

        return busStop.equals(((Bus) obj).busStop);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<String> getStops() {
        return busStop;
    }

    public boolean hasAStop(String stop) {
        return busStop.contains(stop);
    }
}

public class Buses {

    private final List<Bus> buses;
    private int count = 0;

    public Buses() {
        buses = new ArrayList<>();
    }

    public int addBus(String name, String[] stops) throws Exception {
        count++;
        Bus checkedBus = new Bus(count, name, stops);
        for (Bus bus : buses) {
            if (bus.equals(checkedBus)) {
                count--;
                throw new Exception("Already exists for " + bus.getNumber());
            }
        }
        buses.add(checkedBus);
        return checkedBus.getNumber();
    }

    public List<String> sbusesForStop(String nameStop) throws Exception {
        List<String> resBus = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.hasAStop(nameStop))
                resBus.add(bus.getName());
        }
        if (resBus.isEmpty())
            throw new Exception("No stop");
        return resBus;
    }

    public Set<Integer> nbusesForStop(String nameStop) throws Exception {
        Set<Integer> resBus = new HashSet<>();
        for (Bus bus : buses) {
            if (bus.hasAStop(nameStop))
                resBus.add(bus.getNumber());
        }
        if (resBus.isEmpty())
            throw new Exception("No stop");
        return resBus;
    }

    public List<String> allBuses() throws Exception {
        if (buses.isEmpty())
            throw new Exception("No buses");
        List<String> list = new ArrayList<>();
        for (Bus bus : buses) {
            list.add(bus.getName());
        }
        Collections.sort(list);
        return list;
    }

    private Bus findBusByName(String name) {
        for (Bus bus : buses) {
            if (bus.getName().equals(name)) {
                return bus;
            }
        }
        return null;
    }

    public Map<String, Set<Integer>> stopsForBus(String name) throws Exception {
        Map<String, Set<Integer>> map = new HashMap<>();
        Bus resBus = findBusByName(name);

        if (resBus == null)
            throw new Exception("No bus");

        for (String s : resBus.getStops()) {
            Set<Integer> setBuses = new HashSet<>();
            for (Bus bus : buses) {
                if (bus.getName() != name) {
                    if (bus.hasAStop(s))
                        setBuses.add(bus.getNumber());
                }
            }
            map.put(s, setBuses);
        }
        return map;
    }

    @Override
    public String toString() {
        String res = "";
        for (Bus bus : buses) {
            res += bus.getNumber() + " " + bus.getName() + " " + bus.getStops() + "\n";
        }
        return res;
    }
}
