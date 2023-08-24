import java.io.FileNotFoundException;
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
    }

    public ArrayList<String[]> processFile(){
        boolean valid = true;
        ArrayList<String[]> data = new ArrayList<>();
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String fileName = input.nextLine();
            try {
                fileHandler.fileRead(fileName, data);
                valid = true;
            }catch(FileNotFoundException fileException){
                valid = false;
            }
        }while(!valid);
        return data;
    }



}
