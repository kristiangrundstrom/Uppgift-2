package uppgift2Test;

import java.io.IOException;
import java.time.LocalDate;
import junit.framework.TestCase;
import org.junit.Test;
import uppgift2.Customer;
import uppgift2.Membership;

/**
 *
 * @author krist
 */
public class MembershipTest {

    @Test
    public void hasMembershipWorkoutHistory() throws IOException {
        Membership membership = new Membership();
        
        Customer customer_true = new Customer("Bear", "Belle", "8104021234", LocalDate.of(2017, 12, 2), true, false);
        TestCase.assertTrue(membership.hasMembershipWorkoutHistory(customer_true));
        
        Customer customer_false = new Customer("Test-Agneta", "Svensson", "5201012122", LocalDate.of(1985, 1, 5), false, false);
        TestCase.assertFalse(membership.hasMembershipWorkoutHistory(customer_false));

    }
}
