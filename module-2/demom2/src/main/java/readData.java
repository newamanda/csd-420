import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readData {
    public static void main(String[] args) {
        //filename 
        String fileName = "new_datafile.dat";

        //read data and print
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        //catch exception error
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
