import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Dispatcher theDude = new Dispatcher();

        int menuSelection = 0;

        do {
            System.out.println("1. Add bus\n2. Add Person to bus\n3. Remove bus\n4. Remove person\n" +
                    "5. List passengers\n6. List busses\n7. Requeue bus\n8. Transfer person\n" +
                    "9. Dispatch bus\n10. Exit");
            menuSelection = Integer.parseInt(myScan.nextLine());

            if (menuSelection == 1) {
                Bus toAdd = new Bus();
                theDude.addBus(toAdd);
                System.out.println("Bus "+toAdd.getID()+" added to position "+theDude.getBusPosition(toAdd));
            }
            else if (menuSelection == 2) {
                System.out.print("Bus ID: ");
                int theBus = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(theBus) == null) {
                    System.out.println("No bus with id "+theBus);
                }
                else {
                    System.out.print("Name of passenger: ");
                    String newPassenger = myScan.nextLine();
                    Person newPerson = new Person(newPassenger);
                    theDude.addPersonToBus(theBus, newPerson);
                }
            }
            else if (menuSelection == 3) {
                System.out.print("Bus ID: ");
                int theBus = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(theBus) == null) {
                    System.out.println("No bus with id "+theBus);
                }
                else {
                    System.out.println("Bus " + theDude.removeBus(theBus) + " removed.");
                }
            }
            else if (menuSelection == 4) {
                System.out.print("Bus ID: ");
                int theBus = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(theBus) == null) {
                    System.out.println("No bus with id "+theBus);
                }
                else {
                    System.out.print("Passenger name: ");
                    String theName = myScan.nextLine();
                    if (theDude.findBus(theBus).findPerson(theName) == null) {
                        System.out.println("No such person found in bus "+ theDude.findBus(theBus));
                    }
                    else {
                        theDude.findBus(theBus).removePerson(theDude.findBus(theBus).findPerson(theName));
                        System.out.println(theName + " has been removed from bus "+ theDude.findBus(theBus));
                    }
                }
            }
            else if (menuSelection == 5) {
                System.out.print("Bus ID: ");
                int theBus = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(theBus) == null) {
                    System.out.println("No bus with id "+theBus);
                }
                else {
                    System.out.println("Bus "+theDude.findBus(theBus));
                    System.out.println(theDude.findBus(theBus).getPassengers());
                }
            }
            else if (menuSelection == 6) {
                System.out.println("BUS QUEUE");
                System.out.println(theDude.toString());
            }
            else if (menuSelection == 7) {
                System.out.print("Bus ID: ");
                int theBus = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(theBus) == null) {
                    System.out.println("No bus with id "+theBus);
                }
                else {
                    System.out.print("New position: ");
                    int newPosition = Integer.parseInt(myScan.nextLine());

                    System.out.println("Bus "+theDude.findBus(theBus)+" added to position " + theDude.addBus(theDude.findBus(theBus), newPosition));
                }
            }
            else if (menuSelection == 8) {
                System.out.print("Passenger name: ");
                String theName = myScan.nextLine();
                System.out.print("Bus ID 1: ");
                int bus1 = Integer.parseInt(myScan.nextLine());
                System.out.print("Bus ID 2: ");
                int bus2 = Integer.parseInt(myScan.nextLine());
                if (theDude.findBus(bus1) == null) {
                    System.out.println("No bus with id "+bus1);
                }
                else {
                    if (theDude.findBus(bus1).findPerson(theName) == null) {
                        System.out.print("No person named "+ theName);
                    }
                    else {
                        if(Bus.transferPerson(theDude.findBus(bus1),theDude.findBus(bus2),theDude.findBus(bus1).findPerson(theName))) {
                            System.out.println("Person transferred successfully");
                        }
                        else {
                            System.out.println("Person transfer failed");
                        }
                    }
                }
            }
            else if (menuSelection == 9) {
                if (theDude.dispatchBus() == null) {
                    System.out.println("Bus queue is empty");
                }
                else {
                    System.out.println("Bus "+ theDude.dispatchBus()+" has been dispatched");
                }
            }
        } while (menuSelection!=10);
    }
}
