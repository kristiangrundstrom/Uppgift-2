package uppgift2Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import uppgift2.Customer;

/**
 *
 * @author krist
 */
public class CustomerTest {

@Test
    public void isEntryARealCustomerWithAnActiveMembership() {
        Customer customer = new Customer("Nahema", "Ninsson", "7805211234", LocalDate.of(2018, 01, 04), true, false);
        TestCase.assertTrue(customer.getActiveMembership());
        
        Customer customer2 = new Customer("Ture", "Sventon", "0123456789", LocalDate.of(2000, 01, 12), false, false);
        TestCase.assertFalse(customer2.getActiveMembership());
        
    }

   

}


