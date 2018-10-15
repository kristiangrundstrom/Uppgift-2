package uppgift2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private LocalDate datePaidMembership;
    private boolean activeMembership;
    private boolean previousMembership;
    private List<String> workoutHistory;

    public Customer(String firstName, String lastName, String personalIdNumber, LocalDate datePaidMembership, boolean activeMembership, boolean previousMembership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalIdNumber = personalIdNumber;
        this.datePaidMembership = datePaidMembership;
        this.activeMembership = activeMembership;
        this.previousMembership = previousMembership;

    }

    public Customer(Customer currentOrPreviousCustomer) {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDatePaidMembership() {
        return datePaidMembership;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public boolean getActiveMembership() {
        return activeMembership;
    }

    public boolean getPreviousMembership() {
        return previousMembership;
    }

    public List<String> getWorkoutHistory() throws IOException {

        Path filePath = Paths.get("src/uppgift2/workoutHistory.txt");
        try (Scanner sc = new Scanner(filePath)) {
            workoutHistory = new LinkedList<>();

            while (sc.hasNextLine()) {
                if(sc.next().equals(firstName) && sc.next().equals(lastName)) {
                    sc.next(); // Skip personalIdNumber
                workoutHistory.add(sc.nextLine()); }
                
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fel på fil med kunds träningshistorik!");
        }

        return workoutHistory;
    }
}
