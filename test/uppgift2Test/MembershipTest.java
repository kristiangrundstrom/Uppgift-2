package uppgift2Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.junit.Test;
import uppgift2.Customer;
import uppgift2.Membership;

/**
 *
 * @author krist
 */
public class MembershipTest {

    @Test(expected = NoSuchElementException.class)
    public void testIfMemberDoesNotHaveAWorkoutHistory() throws IOException {
        Membership member = new Membership();
        Customer customer = new Customer("Kadine", "Karlsson", "4604151234", LocalDate.of(2017, 1, 9), false, true);
        member.printStatus(customer);
    }

}
