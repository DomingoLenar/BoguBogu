public class SortingAlgorithms {
    void sortingProcess(int sortingType, String[] array)
    {
        int length = array.length;

        switch (sortingType)
        {
            case 1: // selection sort
                for (int x = 0; x < length - 1; x++) {
                    int minIndex = x;
                    for (int y = x + 1; y < length; y++) {
                        if (array[minIndex].compareTo(array[y]) > 0) minIndex = y;
                    }
                    if (minIndex != x) {
                        String temp = array[x];
                        array[x] = array[minIndex];
                        array[minIndex] = temp;
                    }
                }//End of selectionSort

            case 2: // bubble sort
                for (int x = 0; x < length - 1; x++) {
                    for (int y = x + 1; y < length; y++) {
                        if (array[x].compareTo(array[y]) > 0) {
                            String temp = array[x];
                            array[x] = array[y];
                            array[y] = temp;
                        }
                    }
                }//End of bubbleSort

            case 3: // insertion sort
                for (int i = 1; i < length; ++i) {
                    String key = array[i];
                    int j = i - 1;

                    while (j >= 0 && array[j].compareTo(key) > 0) {
                        array[j + 1] = array[j];
                        j = j - 1;
                    }
                    array[j + 1] = key;
                }//End of insertionSort
        }


    }
}
