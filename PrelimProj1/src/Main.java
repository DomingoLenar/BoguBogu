import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main extends SortingAlgorithms implements Runnable {
    FileHandling fileHandler = new FileHandling(); // Create a FileHandling object for file operations
    Scanner kInput = new Scanner(System.in);
    ArrayList<String[]> data = new ArrayList<>(); // Store data from the file
    String[] toSearch; // Store a sub-array for sorting and searching


    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    } //End of main method

    @Override
    public void run() {

        data = processFile(); // Read and process data form a file
        int rows_data =  data.size();
        toSearch = new String[rows_data - 1]; // Create an array to sotre the column data for sorting
        promptMessage(); // Display prompts to the user
        printArray(toSearch); // Print the sorted data

    } //End of run method

    private void promptMessage() { // method binding (dynamic)
        System.out.println("Below are the categories for each datum in a data set");
        String[] arr_header = data.get(0); // Get header row
        data.remove(0); // remove header from data set
        for(int i = 0; i < arr_header.length; i++) // Display the available categories to the user
        {
            System.out.print(i + 1 + "." + arr_header[i] + "\t");

        }

        int category_number;
        int sortingType;
        do {
            System.out.println("\nPlease input the category number to be sort: ");
            category_number = kInput.nextInt();
            System.out.println("Enter the sorting algorithm to be apply in data: 1. Bubble Sort | 2. Selection Sort | 3. Insertion Sort");
            sortingType = kInput.nextInt();

            if (!(category_number > 0  && category_number <= arr_header.length) || !(sortingType > 0  && sortingType < 4)) // Validate user input
            {
                System.out.println("Please try again.");
            }
        } while (!(category_number > 0  && category_number <= arr_header.length) || !(sortingType > 0  && sortingType < 4));

        populateSubArray(data, toSearch, category_number - 1); // Extract the selected column for sorting
        sortingProcess(sortingType, toSearch); // Apply the selected sorting algorithm


    }

    /**
     * Method for checking the file with exception handling
     * Prompts the user to input a file name, reads and processes the file.
     * If the file is not found, it prompts the user to try again.
     * @return An ArrayList containing the processed data from the file.
     */
    private ArrayList<String[]> processFile(){
        boolean valid;
        ArrayList<String[]> data = new ArrayList<>();
        do {
            System.out.print("Enter file name: ");
            String fileName = kInput.nextLine();
            try {
                fileHandler.fileRead(fileName, data); // Read file and store data in the ArrayList
                valid = true;
            }catch(FileNotFoundException fileException){
                System.out.println("File not FOUND\n\n\n");
                valid = false;
            }
        }while(!valid);
        return data;
    } //End of processFile method

    /**
     * Method for printing an array
     * Prints each element in the provided array.
     * @param array The array to be printed.
     */
    private void printArray(String[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    } //End of printArray method

    /**
     * Method for populating an array.
     * Extracts data from a specific column of an ArrayList and populates an array.
     * @param arrayList The ArrayList containing the data.
     * @param arrayToPopulate The array to be populated,
     * @param columnIndex The index of the comun to extract data from.
     **/
    private void populateSubArray(ArrayList<String[]> arrayList, String[] arrayToPopulate, int columnIndex){
            for(int x = 0; x < arrayList.size(); x++){
                String[] data = arrayList.get(x);
                if(data == null || data.length == 0){
                    arrayToPopulate[x] = "Null";
                }else {
                    arrayToPopulate[x] = data[columnIndex];
                }
            }
    }
    } //End of populateArray method




