package uppgift2Test;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.Test;
import uppgift2.Customer;
import uppgift2.Workout;

/**
 *
 * @author krist
 */
public class WorkoutTest {
    
    @Test
    public void isWorkoutHistoryRecorded() throws IOException {
        Workout workout = new Workout();
        String firstName = "Test-Erik";
        String lastName = "Eriksson";
        String personalIdNumber = "5657585960";
        LocalDate localDate = LocalDate.now();
        Customer customer = new Customer(firstName, lastName, personalIdNumber, localDate, false, false);
        
        workout.registerWorkout(customer);
    }
    
  
     
}
