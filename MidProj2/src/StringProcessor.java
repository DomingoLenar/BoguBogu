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
            if(character.equals("\s")){
                character = "space";
            }
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

    public String frequencyToDict(LinkedList<CustomNode> linkedList){
        String dict = "";
        CustomNode pointer = new CustomNode();
        int size = linkedList.size();
        pointer = linkedList.get(0);
        dict += '"'+ pointer.getCharac()+'"'+":"+'"'+ pointer.getFrequency()+'"';
        for(int x = 1; x < size; x++){
            pointer = linkedList.get(x);
            dict += ","+'"'+ pointer.getCharac()+'"'+":"+'"'+ pointer.getFrequency()+'"';
        }
        return dict;
    }

}

/**
 * Represents a node in a custom linked list used for storing characters and their frequencies.
 * Each node contains a character, a frequency, and a reference to the next node in the list.
 */
class CustomNode{
    private String character;  // The character associated with this node
    private int frequency; // The frequency of the character in the context of the application
    private CustomNode nextNode; // Reference to the next node in the linked list

    /**
     * Parameterized constructor to create a CustomNode with specified character and frequency.
     *
     * @param character The character associated with this node.
     * @param frequency The frequency of the character.
     */
    public CustomNode(String c, int f){
        character = c;
        frequency = f;
        nextNode = null;
    }

    /**
     * Default constructor initializes the node with null character, zero frequency, and null next node.
     */
    public CustomNode(){
        character = null;
        frequency = 0;
        nextNode = null;
    }
    
    /**
     * Get the character associated with this node.
     *
     * @return The character.
     */
    public String getCharac(){
        return character;
    }

    /**
     * Set the character associated with this node.
     *
     * @param character The character to be associated with this node.
     */
    public void setCharac(String c){
        character = c;
    }

    /**
     * Get the next node in the linked list.
     *
     * @return Reference to the next node.
     */
    public CustomNode getNextNode() {
        return nextNode;
    }

    /**
     * Set the next node in the linked list.
     *
     * @param nextNode Reference to the next node.
     */
    public void setNextNode(CustomNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Get the frequency of the character associated with this node.
     *
     * @return The frequency.
     */
    public int getFrequency(){
        return frequency;
    }

    /**
     * Set the frequency of the character associated with this node.
     *
     * @param frequency The frequency to be set.
     */
    public void setFrequency(int f){
        frequency = f;
    }

    /**
     * Get a string representation of the character and frequency of this node.
     *
     * @return A string containing the character and frequency.
     */
    public String toString(){
        return character+","+frequency;
    }
}
