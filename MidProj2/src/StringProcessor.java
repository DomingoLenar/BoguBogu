import java.util.*;

public class StringProcessor {
    public String[][] getFrequency(String text){
        int length = text.length();
        LinkedList<customNode> characterFrequency = new LinkedList<>();
        for(int x = 0; x < length; x++){
                if(characterFrequency.isEmpty()){
                    customNode newNode = new customNode(String.valueOf(text.charAt(x)), 1);
                    characterFrequency.add(newNode);
            }
        }

        return frequency;
    }

    public int search(String searchKey, LinkedList<customNode> linkedList){
       int outerSize = arrayList.size();
       for(int x = 0; x < outerSize; x++){
           if(arrayList.get(x)[0].equals(searchKey)){
               return x;
           }
       }
       return -1;
    }
}

class customNode{
    private String character;
    private int frequency;
    public customNode(String c, int f){
        character = c;
        frequency = f;
    }
    public String getCharac(){
        return character;
    }

    public void setCharac(String c){
        character = c;
    }

    public int getFrequency(){
        return frequency;
    }

    public void setFrequency(int f){
        frequency = f;
    }
}
