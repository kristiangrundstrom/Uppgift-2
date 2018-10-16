package uppgift2;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Uppgift2 {

    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private static String data;

    public Uppgift2() throws IOException, ParseException, NullPointerException {
        String indata = input("Välkommen! Ange namn eller personnumer: ");

        if (indata.contains(" ")) {
            String[] arr = indata.split(" ");
            firstName = arr[0];
            lastName = arr[1];
            personalIdNumber = "";
        } else {
            personalIdNumber = indata;
        }

        try {
            Search search = new Search();
            Customer customer = search.isCurrentOrPreviousCustomer(firstName, lastName, personalIdNumber);

            Workout workout = new Workout();
            workout.registerWorkout(customer);

            Membership membership = new Membership();
            membership.printStatus(customer);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Kund finns inte i registret!");
        }
    }

    public static String input(String message) throws NullPointerException {
        try {
            data = JOptionPane.showInputDialog(message);

            while (data.equals("")) {
                data = JOptionPane.showInputDialog("Tom söksträng. Skriv in namn eller peronsnummer: ");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Sökning avbruten. Programmet avslutas.");
            System.exit(0);
        }
        return data.trim().toLowerCase();
    }

    public static void main(String[] args) throws IOException, ParseException, NullPointerException {

        Uppgift2 bestGymEver = new Uppgift2();
    }

}
