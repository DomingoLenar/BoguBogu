import java.util.*;

public class StringProcessor {
    /**
     * 
     * This method gets the frequency of every character in a given text
     * and returns a linked list of custom node which stores the characters
     * and its respective frequencies
     * 
     * @param text
     * @return characterFrequency
     */
    public LinkedList<CustomNode> getFrequency(String text){
        int length = text.length();
        LinkedList<CustomNode> characterFrequency = new LinkedList<>();
        CustomNode pointer = null;
        for(int x = 0; x < length; x++){
            String character = String.valueOf(text.charAt(x));
            if(search(character, characterFrequency) == -1){
                CustomNode newNode = new CustomNode(String.valueOf(text.charAt(x)), 1);
                characterFrequency.add(newNode);
            }
            else if(search(character, characterFrequency) != -1){
                pointer = characterFrequency.get(search(character, characterFrequency));
                int i = pointer.getFrequency();
                i++;
                pointer.setFrequency(i);
            }
            else{
                throw new RuntimeException("Linked List error character");
            }
        }

        return characterFrequency;
    }

    //a custom search method to look into the character of the custom node and returns the index
    private int search(String searchKey, LinkedList<CustomNode> linkedList){
       int outerSize = linkedList.size();
       for(int x = 0; x < outerSize; x++){
           CustomNode curNode = linkedList.get(x);
           if(curNode.getCharac().equals(searchKey)){
               return x;
           }
       }
       return -1;
    }
}

class CustomNode{
    private String character;
    private int frequency;
    private CustomNode nextNode;
    public CustomNode(String c, int f){
        character = c;
        frequency = f;
        nextNode = null;
    }
    public String getCharac(){
        return character;
    }

    public void setCharac(String c){
        character = c;
    }

    public CustomNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(CustomNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getFrequency(){
        return frequency;
    }

    public void setFrequency(int f){
        frequency = f;
    }

    public String toString(){
        return character+","+frequency;
    }
}
