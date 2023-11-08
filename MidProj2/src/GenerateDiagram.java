
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
        huffmanToDotSetUpNodes(huffman, dotString,0);
        setNodeLinks(huffman, dotString, 0, 0);

        MutableGraph g = parser.read(dotString.append("}").toString());

        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("MidProj2/src/tree.png"));

    }

    public void setNodeLinks(TreeNode node, StringBuilder dotString, int nodeCount, int rootNode){
        if(nodeCount == 0){
            //evaluate left
            nodeCount += 1;
            setNodeLinks(node.getLeft(), dotString, nodeCount,0);
            //evaluate right
            nodeCount += 1;
            setNodeLinks(node.getRight(), dotString, nodeCount,0);
        }
        else if(node!=null){
            int curNode = nodeCount;
            dotString.append(setLinkString("Node"+rootNode,"Node"+curNode));
            //evaluate left
            nodeCount += 1;
            setNodeLinks(node.getLeft(), dotString, nodeCount,curNode);
            //evaluate right
            nodeCount += 1;
            setNodeLinks(node.getRight(), dotString, nodeCount,curNode);
        }
    }

    public void huffmanToDotSetUpNodes(TreeNode node, StringBuilder dotString, int nodeCount){
        if(node != null){
            if(node.getSymbol() == '-'){
                dotString.append("Node"+nodeCount+"[label="+node.getCount()+"]\n");
            }else{
                dotString.append("Node"+nodeCount+"[label="+node.getCount()+" xlabel="+node.getSymbol()+"]\n");
            }
            //evaluate left
            nodeCount += 1;
            huffmanToDotSetUpNodes(node.getLeft(), dotString, nodeCount);
            //evaluate right
            nodeCount +=1;
            huffmanToDotSetUpNodes(node.getRight(), dotString, nodeCount);
        }
    }

    public void huffmanToDotLinkNodes(TreeNode node, String dotString, int nodeCount, String root, String child){
        for(int x = 1; x <= nodeCount; x++){

        }
    }

    private String setLinkString(String root, String child){
        String linkString = root +"->"+child+"\n";
        return linkString;
    }

}
