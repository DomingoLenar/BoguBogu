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
        CustomNode pointer;

        CustomNode head = new CustomNode(String.valueOf(text.charAt(0)), 1);
        characterFrequency.add(head);

        for(int x = 1; x < length; x++){
            String character = String.valueOf(text.charAt(x));
            if (!characterFrequency.isEmpty()) {
                int pos = search(character, characterFrequency);
                if(pos != -1){ // character exist in linked list
                    pointer = characterFrequency.get(pos);
                    int i = pointer.getFrequency();
                    pointer.setFrequency(i+1);
                }
                else { // character does not exist in linked list
                    CustomNode newNode = new CustomNode(String.valueOf(text.charAt(x)), 1);

//                    if (head.getNextNode() == null) {
//                        head.setNextNode(newNode);
//                    } else {
//                        while (head.getNextNode() != null) {
//                            if (head.getNextNode() == null) {
//                                newNode.setNextNode(head);
//                                head.getNextNode().setNextNode(newNode);
//                            }
//                            head = head.getNextNode();
//                        }
//                    }
                    characterFrequency.add(newNode);
                }
            }
            else{
                throw new RuntimeException("Linked List error character");
            }
        }

        return characterFrequency;
    }

    // a custom search method to look into the character of the custom node and returns the index
    private int search(String searchKey, LinkedList<CustomNode> linkedList){
       int outerSize = linkedList.size();
       for(int x = 0; x < outerSize; x++){
           CustomNode curNode = linkedList.get(x);
           if(curNode.getCharacter().equals(searchKey)){
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
    public String getCharacter(){
        return character;
    }

    public void setCharacter(String c){
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
