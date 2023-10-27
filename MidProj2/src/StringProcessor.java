import java.util.*;

public class StringProcessor {
    public String[][] getFrequency(String text){
        int length = text.length();
        ArrayList<String[]> frequency = new ArrayList<>();
        String[] toAdd = new String[2];
        for(int x = 0; x < length; x++){
            if(frequency.isEmpty()){
                toAdd[0] = String.valueOf(text.charAt(x));
                toAdd[1]
                frequency.add();
            }
        }

        return frequency;
    }

    public int search(String searchKey, ArrayList<String[]> arrayList){
       int outerSize = arrayList.size();
       for(int x = 0; x < outerSize; x++){
           if(arrayList.get(x)[0].equals(searchKey)){
               return x;
           }
       }
       return -1;
    }
}
