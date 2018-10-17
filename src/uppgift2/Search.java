package uppgift2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class Search {

    private final Path allCustomersList = Paths.get("src/uppgift2/customers.txt");

    public Customer isCustomerRegisteredMember(String firstName, String lastName, String personalIdNumber) throws IOException, ParseException, NullPointerException {
        boolean searchWithId = !personalIdNumber.equals("");
        boolean activeMembership = false;
        boolean previousMembership = true;

        try (Scanner sc = new Scanner(allCustomersList);) {

            while (sc.hasNext()) {
                String[] idAndNameArray = sc.nextLine().trim().split(", ");
                String[] nameArr = idAndNameArray[1].split(" ");
                LocalDate dateOfMembershipPurchase = LocalDate.parse(sc.nextLine());
                Period period = Period.between(LocalDate.now(), dateOfMembershipPurchase);

                if (!searchWithId) {
                    firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
                    lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
                }

                if (idAndNameArray[0].equals(personalIdNumber) || idAndNameArray[1].equals(firstName + " " + lastName)) {

                    if (period.getYears() == 0) {
                        activeMembership = true;
                        previousMembership = false;
                    }

                    firstName = nameArr[0].substring(0, 1).toUpperCase() + nameArr[0].substring(1).toLowerCase();
                    lastName = nameArr[1].substring(0, 1).toUpperCase() + nameArr[1].substring(1).toLowerCase();
                    Customer customer = new Customer(firstName, lastName, idAndNameArray[0], dateOfMembershipPurchase, activeMembership, previousMembership);

                    return customer;
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Tom söksträng.");
            System.exit(0);

        } catch (NoSuchElementException e) {
            System.out.println("Tom rad i fil hittad!");
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Ingen fil hittad!");
            System.exit(0);

        } catch (Exception e) {
            System.out.println("Okänt fel inträffat!");
            System.exit(0);
        }

        return null;
    }

}
