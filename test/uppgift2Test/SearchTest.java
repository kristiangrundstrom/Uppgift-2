package uppgift2Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import junit.framework.TestCase;
import org.junit.Test;
import uppgift2.Customer;
import uppgift2.Search;

/**
 *
 * @author krist
 */
public class SearchTest {
    
    @Test    
    public void isCustomerARegisteredMember() throws IOException, ParseException {
        Search search = new Search();
        
        String p1FirstName = "Bo";
        String p1LastName = "Johnsson";
        String p1PersonalIdNumber = "9090909090";
        TestCase.assertNull(search.isCustomerRegisteredMember(p1FirstName, p1LastName, p1PersonalIdNumber));
        
        String p2FirstName = "Hilme";
        String p2LastName = "Heur";
        String p2PersonalIdNumber = "5711121234";
        TestCase.assertNotNull(search.isCustomerRegisteredMember(p2FirstName, p2LastName, p2PersonalIdNumber));
    }
}
