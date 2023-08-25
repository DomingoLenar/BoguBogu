public class SortingAlgorithms {
    public void selectionSort(String[] array){
        int length = array.length;
        for(int x = 0; x < length - 1; x++){
            int minIndex = x;
            for(int y = x + 1; y < length; y++){
                if(array[minIndex].compareTo(array[y])>0) minIndex = y;
            }
            if(minIndex != x){
                String temp = array[x];
                array[x] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    // Sorts an array of strings using the bubble sort algorithm
    public void bubbleSort(String[] array){

        int length = array.length; // Initializes the length of the array

        for(int x = 0; x < length - 1; x++){
            for(int y = x + 1; y < length; y++){

                // Compares the elements in the array indexed in x and y
                if(array[x].compareTo(array[y]) > 0){

                    // Swaps the array's element in index x with the element in index y
                    String temp = array[x];
                    array[x] = array[y];
                    array[y] = temp;

                } // End of if statement

            } // End of second for loop

        } // End of first for loop

    } // End of bubbleSort method
}
