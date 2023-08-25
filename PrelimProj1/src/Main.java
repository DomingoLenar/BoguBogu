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
        int columnIndex = 0;
        int sortingType = 0;

        ArrayList<String[]> data = processFile();
        String[] toSearch = new String[data.size()];
        promptMessage(columnIndex, sortingType);
        populateSubArray(data, toSearch, 2);

    }

    private void promptMessage(int columnIndex, int sortingType) {
        do {
            System.out.println("Enter the column to be sort");
            columnIndex =   kInput.nextInt();
            System.out.println("Enter the sorting algorithm to be apply in data: 1. Bubble Sort | 2. Selection Sort | 3. Insertion Sort");
            sortingType = kInput.nextInt();

            if (columnIndex < 0); // add another layer of verification
        } while (false); // loop if not valid otherwise break


    }

    public ArrayList<String[]> processFile(){
        boolean valid;
        ArrayList<String[]> data = new ArrayList<>();
        do {
            System.out.print("Enter file name: ");
            String fileName = kInput.nextLine();
            try {
                fileHandler.fileRead(fileName, data);
                valid = true;
            }catch(FileNotFoundException fileException){
                valid = false;
            }
        }while(!valid);
        return data;
    }

    public void printArray(String[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    }

    public void populateSubArray(ArrayList<String[]> arrayList, String[] arrayToPopulate, int columnIndex){
        for(int x = 0; x < arrayList.size(); x++){
            arrayToPopulate[x] = arrayList.get(x)[columnIndex];
        }
    }



}
