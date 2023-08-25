import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class FileHandling {
    public String[] fileRead(String fileName) throws FileNotFoundException{
        File file = new File(fileName); //creating a file
        Scanner reader = new Scanner(file); //initializing a scanner to read a data from file
        int size = countLines(file); // Count the number of lines in the file using the countLines method.
        String[] data = new String[size]; // Create a string to store the read data, with the size calculated earlier.
        for(int x = 0; x < size; x++){  // Loop through each line of the file and store it in the data array.
            data[x] = reader.nextLine();
        }
        return data;
    }
    public int countLines(File file)throws FileNotFoundException{
        Scanner counter = new Scanner(file);
        int count = 0;
        while(counter.hasNext()){
           counter.nextLine();
           count++;
        }
        counter.close();
        return count;
    }

    public void fileRead(String fileName, ArrayList<String[]> arrayList) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        while(reader.hasNext()){
            arrayList.add(reader.nextLine().split(","));
        }
    }
}
