package uppgift2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Search {

    private String firstName, lastName, personalIdNumber;
    private String[] idAndNameArray;
    private LocalDate dateOfMembershipPurchase;
    private final LocalDate now = LocalDate.now();
    private Period period;
    private Customer customer;
    private final Path customerTextFilePath = Paths.get("src/uppgift2/customers.txt");
    private boolean activeMembership = false;
    private boolean previousMembership = true;
    private boolean searchWithId = true;
    
    
    public Search() {

    }

    public Customer isCurrentOrPreviousCustomer(String firstName, String lastName, String personalIdNumber) throws IOException, ParseException, NullPointerException {
        
        searchWithId = !personalIdNumber.equals("");

        try (Scanner sc = new Scanner(customerTextFilePath);) {

            while (sc.hasNext()) {
                idAndNameArray = sc.nextLine().split(", ");
                String[] nameArr = idAndNameArray[1].split(" ");
                dateOfMembershipPurchase = LocalDate.parse(sc.nextLine());
                period = Period.between(now, dateOfMembershipPurchase);

                if (!searchWithId) {
                    firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
                    lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
                }

                if (idAndNameArray[0].equals(personalIdNumber) || idAndNameArray[1].equals(firstName + " " + lastName)) {

                    if (period.getYears() == 0) {
                        activeMembership = true;
                        previousMembership = false;
                    }

                    if (searchWithId) {

                        firstName = nameArr[0].substring(0, 1).toUpperCase() + nameArr[0].substring(1).toLowerCase();
                        lastName = nameArr[1].substring(0, 1).toUpperCase() + nameArr[1].substring(1).toLowerCase();
                    }
                    
                    
                    
                    customer = new Customer(firstName, lastName, idAndNameArray[0], dateOfMembershipPurchase, activeMembership, previousMembership);
                    
                    Path payingCustomerFilePath = Paths.get("src/uppgift2/" + idAndNameArray[1] + ".txt");

                    if (!Files.exists(payingCustomerFilePath)) {
                        Files.createFile(payingCustomerFilePath);
                    }

                    try (
                        BufferedWriter writeWorkoutHistoryToFile = Files.newBufferedWriter(payingCustomerFilePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                        writeWorkoutHistoryToFile.write(customer.getFirstName() + " " + customer.getLastName() + " " + 
                                customer.getPersonalIdNumber() + " " + now.toString() + "\n");
                        writeWorkoutHistoryToFile.flush();
                    }

                    return customer;
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"Tom söksträng.");
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Ingen fil hittad!");
            System.exit(0);

        } catch (NoSuchElementException e) {
            System.out.println("Tom rad i fil hittad!");
            System.exit(0);
        }

        return null;
    }
}
