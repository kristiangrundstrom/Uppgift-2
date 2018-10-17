package uppgift2;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Membership {

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
        String workoutHistoryMessage = "Träningshistorik: :\n";

        for (String e : workoutHistory) {
            workoutHistoryMessage += e + "\n";
        }
        return customerInfoMessage + "\n" + workoutHistoryMessage;
    }

}
