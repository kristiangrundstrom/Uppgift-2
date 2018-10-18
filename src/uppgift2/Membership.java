package uppgift2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Membership {
    
   public boolean hasMembershipWorkoutHistory(Customer customer) throws FileNotFoundException, IOException {
       
       Path filePath = Paths.get("src/uppgift2/workoutHistory.txt");
        try (Scanner sc = new Scanner(filePath)) {
            while(sc.hasNext()) {
                if (sc.next().equals(customer.getFirstName())) {
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("error.");
        }
        
       return false;
   }

    public String workoutHistoryAsMessage(Customer customer) throws IOException {
        String customerInfoMessage = "";

        if (customer.getActiveMembership()) {
            customerInfoMessage = customer.getFirstName() + " " + customer.getLastName() + " är en aktiv medlem.\nMedlemsavgift betald: " + customer.getDatePaidMembership() + "\n";
        } else if (customer.getPreviousMembership()) {
            customerInfoMessage = customer.getFirstName() + " " + customer.getLastName() + " har varit medlem tidigare.\nSenast betalada medlemskapsavgift: " + customer.getDatePaidMembership() + "\n";
        }

        int indexOfLastFourDigits = customer.getPersonalIdNumber().length() - 4;
        String personalIdNumberFormatted = customer.getPersonalIdNumber().substring(0, indexOfLastFourDigits) + "-" + customer.getPersonalIdNumber().substring(indexOfLastFourDigits);
        customerInfoMessage += "Personnunmmer: " + personalIdNumberFormatted + "\n";

        List<String> workoutHistory;
        workoutHistory = customer.getWorkoutHistory();
        String workoutHistoryMessage = "";
        
        for (String e : workoutHistory) {
            workoutHistoryMessage += e + "\n";
        }
        return customerInfoMessage + "\n" + "Träningshistorik: \n" + workoutHistoryMessage;
    }

    private BufferedInputStream BufferedReader(FileReader fileReader) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
