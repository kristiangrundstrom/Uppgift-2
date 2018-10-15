package uppgift2;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Uppgift2 {

    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private String customerInfoMessage;
    private static String data;
    Search search = new Search();
    Customer customer;
    private List<String> workoutHistory;

    public static String input(String message) {
        data = JOptionPane.showInputDialog(message);
        if (data == null) {
            JOptionPane.showMessageDialog(null, "Programmet avbröts!");
            System.exit(0);
        }
        else if (data.equals("")) {
            data = JOptionPane.showInputDialog("Tom söksträng. Skriv in namn eller peronsnummer: ");  
        }

        return data.trim().toLowerCase();
    }

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
            customer = search.isCurrentOrPreviousCustomer(firstName, lastName, personalIdNumber);

            if (customer.getActiveMembership()) {
                customerInfoMessage = "Kund är en aktiv medlem.\nMedlemsavgift betald: " + customer.getDatePaidMembership() + "\n";
            } else if (customer.getPreviousMembership()) {
                customerInfoMessage = "Kund har varit medlem tidigare.\nSenast betalada medlemskapsavgift: " + customer.getDatePaidMembership() + "\n";
            }

            workoutHistory = customer.getWorkoutHistory();
            String workoutHistoryMessage = "Träningshistorik för " + customer.getFirstName() + " " + customer.getLastName() + "\n" +
                    "KundID: " + customer.getPersonalIdNumber() + "\n";

            for (String e : workoutHistory) {
                workoutHistoryMessage += e + "\n";
            }
        
            JOptionPane.showMessageDialog(null, customerInfoMessage + "\n" + workoutHistoryMessage);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Kund finns inte i registret!");
        }

        

    }

    public static void main(String[] args) throws IOException, ParseException, NullPointerException {

        Uppgift2 bestGymEver = new Uppgift2();
    }

}
