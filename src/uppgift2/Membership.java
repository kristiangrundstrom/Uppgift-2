package uppgift2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("Något fel med filen inträffade.");
        }
       return false;
   }

    public String workoutHistoryAsMessage(Customer customer) throws IOException {
        if (!hasMembershipWorkoutHistory(customer)) {
            return "Kund har ingen träningshistorik.";
        }
        
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
}
