import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jeanlee on 2017/9/29.
 */
public class Node {
    private String word;
    private Map<Integer,Node> childrenNodes = new TreeMap<>();

    public Node() {
    }

    public Node(String word) {
        this.word = word;
        childrenNodes = new TreeMap<Integer,Node>();
    }

    public void addChildren(String child){
        LevenDistance levenDistance = new LevenDistance();
        int distance = levenDistance.getDistance(child,this.word);
        Node children = childrenNodes.get(distance);
        if (children != null){
            children.addChildren(child);
        }else {
            childrenNodes.put(distance,new Node(child));
        }
    }
    public void search(String word, int maxDistance,Set<String> words){
        LevenDistance levenDistance = new LevenDistance();
        int distance = levenDistance.getDistance(word,this.word);
        if (distance <= maxDistance){
            words.add(this.word);
        }
        for (int i = distance - maxDistance; i <= distance + maxDistance;i++){
            if (i >0){
                Node child = childrenNodes.get(i);
                if (child != null){
                    child.search(word,maxDistance,words);
                }
            }
        }
    }


}
