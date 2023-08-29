public class SortingAlgorithms {

    // Sorts the input array using the specified sorting algorithm

    void sortingProcess(int sortingType, String[] array)
    {
        int length = array.length;

        switch (sortingType) {
            case 1: // Selection Sort
                for (int x = 0; x < length - 1; x++) {
                    int minIndex = x;
                    for (int y = x + 1; y < length; y++) {
                        if (array[minIndex].compareTo(array[y]) > 0)
                            minIndex = y;
                    }
                    if (minIndex != x) {
                        // Swap elements
                        String temp = array[x];
                        array[x] = array[minIndex];
                        array[minIndex] = temp;
                    }
                }
                break; // Break to exit the case

            case 2: // bubble sort
                for (int x = 0; x < length - 1; x++) {
                    for (int y = x + 1; y < length; y++) {
                        if (array[x].compareTo(array[y]) > 0) {
                            String temp = array[x];
                            array[x] = array[y];
                            array[y] = temp;
                        }
                    }
                }
                break; // Break to exit the case

            case 3: // Insertion Sort
                for (int i = 1; i < length; ++i) {
                    String key = array[i];
                    int j = i - 1;

                    while (j >= 0 && array[j].compareTo(key) > 0) {
                        array[j + 1] = array[j];
                        j = j - 1;
                    }
                    array[j + 1] = key;
                }
        }


    }
}
