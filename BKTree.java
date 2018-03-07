import java.util.*;

/**
 * Created by jeanlee on 2017/9/30.
 */
public class BKTree {
    private int size;
    private Node root;
    private LevenDistance levenDistance;

    public BKTree() {
        this.size = 0;
        this.root = null;
        this.levenDistance = new LevenDistance();
    }

    public int getSize() {
        return size;
    }

    public void add(String word){
        if (root == null){
            root = new Node(word);
            size++;
        }else {
            root.addChildren(word);
        }
    }

    public Set<String> match(String target, int maxdistance){
        Set<String> matches = new HashSet<>();
        root.search(target,maxdistance,matches);
        return matches;
    }



}
