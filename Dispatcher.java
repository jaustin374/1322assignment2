import java.util.ArrayList;

public class Dispatcher {
    ArrayList<Bus> busQueue = new ArrayList<Bus>();

    public int addBus(Bus b) {
        busQueue.add(b);
        return busQueue.indexOf(b);
    }

    public int getBusPosition(Bus b) {
        return busQueue.indexOf(b);
    }

    public void addPersonToBus(int id, Person p) {
        busQueue.get(id).addPerson(p);
    }

    public int addBus(Bus b, int p) {
        if (busQueue.size() >= p) {
            busQueue.set(p, b);
            return busQueue.indexOf(b);
        }
        busQueue.add(b);
        return busQueue.indexOf(b);
    }

    public Bus findBus(int id) {
        for (int i = 0;i < busQueue.size();i ++) {
            if (Integer.parseInt(busQueue.get(i).toString())==id) {
                return busQueue.get(i);
            }
        }
        return null;
    }

    public Bus removeBus(int id) {
        Bus toReturn;
        for (int i = 0;i < busQueue.size();i++) {
            if (Integer.parseInt(busQueue.get(i).toString())==id) {
                toReturn = busQueue.get(i);
                busQueue.remove(i);
                return toReturn;
            }
        }
        return null;
    }

    public Bus dispatchBus() {
        if (busQueue.isEmpty()) {
            return null;
        }
        else {
            Bus temp = busQueue.get(0);
            busQueue.remove(0);
            return temp;
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0;i < busQueue.size();i++) {
            toReturn += busQueue.get(i).toString() + "\n";
        }
        return toReturn;
    }
}
