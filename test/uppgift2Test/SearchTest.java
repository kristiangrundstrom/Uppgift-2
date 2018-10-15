package uppgift2Test;

import java.io.IOException;
import java.text.ParseException;
import junit.framework.TestCase;
import org.junit.Test;
import uppgift2.Search;

/**
 *
 * @author krist
 */
public class SearchTest {


@Test
public void isCurrentOrPreviousCustomer() throws IOException, ParseException{
    Search search = new Search();
    TestCase.assertNotNull(search.isCurrentOrPreviousCustomer("Bear", "Belle", ""));
    TestCase.assertNull(search.isCurrentOrPreviousCustomer("Blahablah", "Andersson", "55"));
}
}


