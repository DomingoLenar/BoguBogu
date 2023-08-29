import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    public String[] fileRead(String fileName) throws FileNotFoundException{
        File file = new File(fileName); //creating a file object using the provided fileName.
        Scanner reader = new Scanner(file); //initializing a scanner to read a data from file
        int size = countLines(file); // Count the number of lines in the file using the countLines method.
        String[] data = new String[size]; // Create a string to store the read data, with the size calculated earlier.
        for(int x = 0; x < size; x++){  // Loop through each line of the file and store it in the data array.
            data[x] = reader.nextLine();
        }
        return data;// Return the array containing the read data.
    }
    public int countLines(File file)throws FileNotFoundException{
        Scanner counter = new Scanner(file); // Initialize a Scanner to read from the file for line counting.
        int count = 0; // Initialize a count to keep track of the number of lines.
        while(counter.hasNext()){ // Iterate through the file, reading each line to count the lines.
           counter.nextLine(); // Close the counter to release resources.
           count++;
        }
        counter.close(); // Close the counter to release resources.
        return count; // Return the total count of lines in the file.
    }

    public void fileRead(String fileName, ArrayList<String[]> arrayList) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner reader = new Scanner(file); //initializing a scanner to read a data from file
        while(reader.hasNext()){
            arrayList.add(reader.nextLine().split(","));
        }
    }
}
