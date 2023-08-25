public class SortingAlgorithms {

    // sorts an array of strings using the selection sort algorithm
    public void selectionSort(String[] array){
        int length = array.length;  //  initialization

        // iterate through the array, considering each element as the potential minimum.
        for (int x = 0; x < length - 1; x++) {

            int minIndex = x;  // Assume the current index has the minimum value.

            // Search for a smaller element in the unsorted portion of the array.
            for (int y = x + 1; y < length; y++) {
                if (array[minIndex].compareTo(array[y]) > 0) {
                    minIndex = y;  // Update the index of the new minimum element found.
                }
            }  // end of second for loop

            // Swap the minimum element with the first element of the unsorted portion.
            if (minIndex != x) {
                String temp = array[x];
                array[x] = array[minIndex];
                array[minIndex] = temp;
            }  // end of if statement

        }  // end of first for loop

    }  // end of selectionSort method

    public void bubbleSort(String[] array){
        int length = array.length;
        for(int x = 0; x < length - 1; x++){
            for(int y = x + 1; y < length; y++){
                if(array[x].compareTo(array[y]) > 0){
                    String temp = array[x];
                    array[x] = array[y];
                    array[y] = temp;
                }
            }
        }
    }
}
