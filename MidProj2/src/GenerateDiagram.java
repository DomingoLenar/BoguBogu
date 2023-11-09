
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.IOException;

public class GenerateDiagram {
    public static void main(String[] args) {
        GenerateDiagram program = new GenerateDiagram();
    }

    public void run(TreeNode huffman) throws IOException{
        Parser parser = new Parser();
        StringBuilder dotString = new StringBuilder("digraph {  ");
        huffmanToDotSetUpNodes(huffman, dotString,-1);
        setNodeLinks(huffman, dotString, -1, 0);

        MutableGraph g = parser.read(dotString.append("}").toString());

        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("MidProj2/src/tree.png"));

    }

    private int setNodeLinks(TreeNode node, StringBuilder dotString, int nodeCount, int rootNode){
        if(node!=null){
            nodeCount += 1;
            int curNode = nodeCount;
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

    private int huffmanToDotSetUpNodes(TreeNode node, StringBuilder dotString, int nodeCount){
        if(node != null){
            nodeCount+=1;
            if(node.getSymbol() == '-'){
                dotString.append("Node"+nodeCount+"[label="+node.getCount()+"]\n");

            }else{
                String symbol = String.valueOf(node.getSymbol());
                if(symbol.equals("\s")){
                    dotString.append("Node"+nodeCount+"[label="+node.getCount()+" xlabel=space"+"]\n");
                }else {
                    dotString.append("Node" + nodeCount + "[label=" + node.getCount() + " xlabel=" + symbol + "]\n");
                }
            }
            //evaluate left
            nodeCount = huffmanToDotSetUpNodes(node.getLeft(), dotString, nodeCount);
            //evaluate right
            nodeCount = huffmanToDotSetUpNodes(node.getRight(), dotString, nodeCount);
        }
        return nodeCount;
    }



    private String setLinkString(String root, String child){
        String linkString = root +"->"+child+"\n";
        return linkString;
    }

}
