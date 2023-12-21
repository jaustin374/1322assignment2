public class Person {
    private String name;
    private int ticketNumber;
    private static int nextTicketNumber = 0;

    public Person() {
        name = "NO NAME";
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public Person(String n) {
        name = n;
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    @Override
    public String toString() {
        return ticketNumber +"\t"+ name;
    }
}
