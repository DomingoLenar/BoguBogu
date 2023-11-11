
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GenerateDiagram {

    /**
     * Main method: creates a new GenerateDiagram object and calls its run() method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GenerateDiagram program = new GenerateDiagram();
    }

    /**
     * Generates a diagram of a Huffman tree from the given root node.
     *
     * @param huffman The root node of the Huffman tree.
     * @throws IOException If an error occurs while writing the diagram to a file.
     */
    public void run(TreeNode huffman) throws IOException{
        Parser parser = new Parser(); // Create a Parser
        StringBuilder dotString = new StringBuilder("digraph {  "); // Create a StringBuilder.
        huffmanToDotSetUpNodes(huffman, dotString,-1); // Recursively generate the Dot string for the Huffman tree.
        setNodeLinks(huffman, dotString, -1, 0); // Recursively set the node links.

        MutableGraph g = parser.read(dotString.append("}").toString()); // Append the closing curly brace to the DOT string.

        File output = new File("MidProj2/src/tree.png");
        if(output.exists()){
            output.delete();
        }
        try {
            // Create a FileOutputStream for the desired output file
            try (OutputStream outputStream = new FileOutputStream("MidProj2/src/tree.png")) {
                // Render the Graphviz graph to a PNG image and save it to the file `tree.png`
                Graphviz.fromGraph(g).render(Format.PNG).toOutputStream(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } // Render the Graphviz graph to a PNG image and save it to the file `tree.png`.

    }

    /**
     * This method recursively sets the node links in the DOT string for the given Huffman tree, starting at the given node.
     *
     * @param node The root node of the Huffman tree.
     * @param dotString The StringBuilder to store the DOT string in.
     * @param nodeCount The current node count.
     * @return The updated node count.
     */
    private int setNodeLinks(TreeNode node, StringBuilder dotString, int nodeCount, int rootNode){
        if(node!=null){
            nodeCount += 1; // Increment the node count.
            int curNode = nodeCount; // Get the current node's index.
            // If the current node is not the root node, add a link from the root node to the current node.
            if(nodeCount!=0) {
                dotString.append(setLinkString("Node" + rootNode, "Node" + nodeCount));
                //Evaluate left
                nodeCount = setNodeLinks(node.getLeft(), dotString, nodeCount, curNode);
                //Evaluate right
                nodeCount = setNodeLinks(node.getRight(), dotString, nodeCount, curNode);
            }else{
                //Evaluate left
                nodeCount = setNodeLinks(node.getLeft(), dotString, nodeCount, curNode);
                //Evaluate right
                nodeCount = setNodeLinks(node.getRight(), dotString, nodeCount, curNode);
            }
        }
        return nodeCount;
    }

    /**
     * Sets up the nodes in the DOT diagram for the given Huffman tree.
     *
     * @param node the Huffman tree node
     * @param dotString the StringBuilder containing the DOT diagram
     * @param nodeCount the current node count
     *
     * @return the new node count
     */
    private int huffmanToDotSetUpNodes(TreeNode node, StringBuilder dotString, int nodeCount){
        if(node != null){ // Check if the current node is not null.
            nodeCount+=1;
            if(node.getSymbol() == '-'){ // Check if the current node represents an internal node (symbol is '-').
                dotString.append("Node"+nodeCount+"[label="+node.getCount()+"]\n"); // If the node is an internal node, label it with its count.

            }else{ // If the node is a leaf node, label it with its count and symbol.
                String symbol = String.valueOf(node.getSymbol());  // Get the symbol of the current node.
                if(symbol.equals("\s")){ // Check if the symbol is a space character.
                    dotString.append("Node"+nodeCount+"[label="+node.getCount()+" xlabel=space"+"]\n");
                }else {
                    dotString.append("Node" + nodeCount + "[label=" + node.getCount() + " xlabel=" + symbol + "]\n");
                }
            }
            // Recursively add the node's left and right children to the DOT string.
            //evaluate left
            nodeCount = huffmanToDotSetUpNodes(node.getLeft(), dotString, nodeCount);
            //evaluate right
            nodeCount = huffmanToDotSetUpNodes(node.getRight(), dotString, nodeCount);
        }
        return nodeCount;
    }

    /**
     * Creates a link string between two nodes.
     *
     * @param root
     * @param child
     * @return
     */
    private String setLinkString(String root, String child){
        String linkString = root +"->"+child+"\n";
        return linkString;
    }

}
