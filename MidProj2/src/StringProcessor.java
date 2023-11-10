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

        // Get the length of the input text.
        int length = text.length();

        // Create a linked list to store character frequencies.
        LinkedList<CustomNode> characterFrequency = new LinkedList<>();

        // Create a pointer for manipulation.
        CustomNode pointer = null;

        // Iterate through each character in the text.
        for(int x = 0; x < length; x++){

            // Get the current character as a string.
            String character = String.valueOf(text.charAt(x));

            // Replace space character with "space" for better representation.
            if(character.equals("\s")){
                character = "space";
            }

            // Check if the character is not in the linked list.
            if(search(character, characterFrequency) == -1){

                // Create a new node and add it to the linked list.
                CustomNode newNode = new CustomNode(String.valueOf(text.charAt(x)), 1);
                characterFrequency.add(newNode);
            }

            // Check if the character is already in the linked list.
            else if(search(character, characterFrequency) != -1){

                // Update the frequency of the existing node.
                pointer = characterFrequency.get(search(character, characterFrequency));
                int i = pointer.getFrequency();
                i++;
                pointer.setFrequency(i);
            }

            // Throw an exception if an unexpected situation occurs.
            else{
                throw new RuntimeException("Linked List error character");
            }
        }
        // Return the linked list containing character frequencies.
        return characterFrequency;

    } // end of getFrequency method

    /**
     * A custom search method to look into the character of the custom node and return the index.
     *
     * @param searchKey The character to search for in the linked list.
     * @param linkedList The linked list to search in.
     * @return The index of the node containing the character, or -1 if not found.
     */
    private int search(String searchKey, LinkedList<CustomNode> linkedList){

        // Get the size of the linked list.
        int outerSize = linkedList.size();

        // Iterate through each node in the linked list.
        for(int x = 0; x < outerSize; x++){

            // Get the current node.
            CustomNode curNode = linkedList.get(x);

            // Check if the character in the current node matches the search key.
            if(curNode.getCharac().equals(searchKey)){

                // Return the index if a match is found.
                return x;
           }
       }
        // Return -1 if the search key is not found in the linked list.
        return -1;

    } // end of search method

    /**
     * Converts the linked list of custom nodes into a JSON-like string representation.
     *
     * @param linkedList The linked list to convert.
     * @return dict A string representation of the linked list in a key-value format.
     */
    public String frequencyToDict(LinkedList<CustomNode> linkedList){

        // Initialize an empty string to store the result.
        String dict = "";

        // Create a pointer for manipulation.
        CustomNode pointer = new CustomNode();

        // Get the size of the linked list.
        int size = linkedList.size();

        // Get the first node in the linked list.
        pointer = linkedList.get(0);

        // Append the first node's character and frequency to the result string.
        dict += '"'+ pointer.getCharac()+'"'+":"+'"'+ pointer.getFrequency()+'"';

        // Iterate through the remaining nodes in the linked list.
        for(int x = 1; x < size; x++){

            // Get the current node.
            pointer = linkedList.get(x);

            // Append the current node's character and frequency to the result string.
            dict += ","+'"'+ pointer.getCharac()+'"'+":"+'"'+ pointer.getFrequency()+'"';
        }
        // Return the final string representation.
        return dict;

    } // end of frequencyToDict method

} // end of StringProcessor class

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
