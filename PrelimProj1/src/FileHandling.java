import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class FileHandling {
    public String[] fileRead(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        int size = countLines(file);
        String[] data = new String[size];
        for(int x = 0; x < size; x++){
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
}
