import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
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
    private int countLines(File file)throws FileNotFoundException{
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
