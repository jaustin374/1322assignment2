import java.util.ArrayList;

public class Bus {
    ArrayList<Person> passengers;
    private static int nextId = 0;
    private int busID;

    public Bus() {
        passengers = new ArrayList<Person>();
        busID = nextId;
        nextId++;
    }

    public int getID() {
        return busID;
    }

    public void addPerson(Person p) {
        passengers.add(p);
    }

    public boolean removePerson(Person p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
            return true;
        }
        else {
            return false;
        }
    }

    public Person findPerson(String n) {
        for (int i = 0; i < passengers.size();i++) {
            if (passengers.get(i).toString().contains(n)) {
                return passengers.get(i);
            }
        }
        return null;
    }

    public static boolean transferPerson(Bus b1, Bus b2, Person p) {
        for (int i = 0; i < b1.passengers.size(); i++) {
            if (b1.passengers.contains(p)) {
                b1.passengers.remove(p);
                b2.passengers.add(p);
                return true;
            }
        }
        return false;
    }

    public String getPassengers(){
        String toReturn = "";
        for (int i=0;i<passengers.size();i++) {
            toReturn += passengers.get(i).toString() + "\n";
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return "" + busID;
    }
}
