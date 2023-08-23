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

    public void insertionSort(String[] arr)
    {
        //do smth..
    }
}
