/**
 * Algorithm:
 * The code below focuses on handling file input operations. It contains a class named "FileHandling'with three
 * methods for reading and processing data from files.
 */

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This part of the code input a 'fileName' string specifying the name of the file to be read and return the 'data'
 * array containing  the read lines after initializing a scanner, counting the number of lines, creating a string used for
 * storage and using a loop to iterate from 0 to 1.
 */
public class FileHandling {
    public String[] fileRead(String fileName) throws FileNotFoundException{
        File file = new File("/PrelimProj1/data/"+fileName); //creating a file object using the provided fileName.
        Scanner reader = new Scanner(file); //initializing a scanner to read a data from file
        int size = countLines(file); // Count the number of lines in the file using the countLines method.
        String[] data = new String[size]; // Create a string to store the read data, with the size calculated earlier.
        for(int x = 0; x < size; x++){  // Loop through each line of the file and store it in the data array.
            data[x] = reader.nextLine();
        }
        return data;// Return the array containing the read data.
    }

    /**
     *This part of the code input a 'File' object representing the file for which line count needs to be calculated and
     * returns an integer representing the number of lines in the file after initializing a scanner, initializing and integer
     * variable named 'count', using a loop and closing the 'counter' scanner.
     */
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

    /**
     * This part of the code input a "fileName' string specifying the name of the file to be read, and an "ArrayList" used to store the read
     * data. Next is that this method will create a 'File' object using the provided 'fileName' and initialize a scanner named 'reader'
     * to read data from the file. After it uses the loop it will close the 'reader' scanner.
     */
    public void fileRead(String fileName, ArrayList<String[]> arrayList) throws FileNotFoundException{
        File file = new File("PrelimProj1/data/"+fileName);
        Scanner reader = new Scanner(file); //initializing a scanner to read a data from file
        while(reader.hasNext()){
            arrayList.add(reader.nextLine().split(","));
        }
    }
}
