import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class FileHandling {
    public String[] fileRead(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner reader = new Scanner(file);

    }

    public int countLines(String fileName)throws FileNotFoundException{
        Scanner counter = new Scanner(fileName);
        int count = 0;
        while(counter.hasNext()){
           counter.nextLine();
           count++;
        }
        counter.close();
        return count;
    }
}
