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
    }//End of main method

    public void run(){

        ArrayList<String[]> data = processFile();
        int verticalSize = data.size();
        String[] toSearch = new String[verticalSize];
        populateArray(data, toSearch, 2);
    }//End of run method

    /**
     * Method for checking the file with exception handling
     * @return data
     */
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
    }//End of processFile method

    /**
     * Method for printing an array
     * @param array
     */
    public void printArray(ArrayList array){
        for (Object o : array) {
            System.out.println(o);
        }
    }//End of printArray method

    /**
     * Method for populating an array
     * @param arrayList
     * @param arrayToPopu
     * @param horizontalIndex
     */
    public void populateArray(ArrayList<String[]> arrayList, String[] arrayToPopu, int horizontalIndex){
        for(int x = 0; x < arrayList.size(); x++){
            arrayToPopu[x] = arrayList.get(x)[horizontalIndex];
        }
    }//End of populateArray method



}//End of main class
