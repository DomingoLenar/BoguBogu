abstract class SortingAlgorithms {
    void sortingProcess(int sortingType, String[] array) {
        int length = array.length;

        switch (sortingType) {
            case 1: // bubble Sort
                for (int x = 0; x < length - 1; x++) {
                    for (int y = 0; y < length - x - 1; y++) {
                        if (array[y].compareTo(array[y + 1]) > 0) {
                            // swap elements if they are in the wrong order
                            String temp = array[y];
                            array[y] = array[y + 1];
                            array[y + 1] = temp;
                        }
                    }
                }
                break; // end of bubble sort

            case 2: // selection sort
                for (int x = 0; x < length - 1; x++) {
                    int minIndex = x;
                    for (int y = x + 1; y < length; y++) {
                        if (array[y].compareTo(array[minIndex]) < 0) {
                            minIndex = y;
                        }
                    }
                    if (minIndex != x) {
                        // swap elements to move the minimum element to the correct position
                        String temp = array[x];
                        array[x] = array[minIndex];
                        array[minIndex] = temp;
                    }
                }
                break; // end of selection sort

            case 3: // insertion Sort
                for (int i = 1; i < length; ++i) {
                    String key = array[i];
                    int j = i - 1;

                    // shift elements greater than the key to the right
                    while (j >= 0 && array[j].compareTo(key) > 0) {
                        array[j + 1] = array[j];
                        j = j - 1;
                    }
                    array[j + 1] = key;
                }
                break; // end of insertion sort
        }  // end of switch-case
    }  // end of sortingProcess method
}  // end of SortingAlgorithms class