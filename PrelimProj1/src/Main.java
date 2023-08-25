import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    FileHandling fileHandler = new FileHandling();
    SortingAlgorithms sort = new SortingAlgorithms();
    Scanner kInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    public void run(){

        ArrayList<String[]> data = processFile();
        int verticalSize = data.size();
        String[] toSearch = new String[verticalSize];
        populateArray(data, toSearch, 2);
    }

    public ArrayList<String[]> processFile(){
        boolean valid = true;
        ArrayList<String[]> data = new ArrayList<>();
        do {
            System.out.print("Enter file name: ");
            String fileName = kInput.nextLine();
            try {
                fileHandler.fileRead(fileName, data);
                valid = true;
            }catch(FileNotFoundException fileException){
                System.out.println("File not FOUND\n\n\n");
                valid = false;
            }
        }while(!valid);
        return data;
    }

    public void printArray(ArrayList array){
        for (Object o : array) {
            System.out.println(o);
        }
    }


    public void populateArray(ArrayList<String[]> arrayList, String[] arrayToPopu, int horizontalIndex){
        for(int x = 0; x < arrayList.size(); x++){
            arrayToPopu[x] = arrayList.get(x)[horizontalIndex];
        }
    }



}
