package uppgift2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author krist
 */
public class Workout {
        private final Path filePath = Paths.get("src/uppgift2/workoutHistory.txt");
        
    public Workout() {
    }
    
    public void registerWorkout(Customer customer) throws IOException { 
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        try (BufferedWriter writeWorkoutHistoryToFile = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writeWorkoutHistoryToFile.write(customer.getFirstName() + " " + customer.getLastName() + " "
                    + customer.getPersonalIdNumber() + " " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
            writeWorkoutHistoryToFile.flush();
        }
        catch (IOException e) {
            System.out.println("Problem med filen! Programmet avslutas");
            System.exit(0);
        }   
    }
}
