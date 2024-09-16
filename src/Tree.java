import java.util.ArrayList;

public class Tree {
    // TODO
    private Object root;
    private ArrayList<Tree> subtrees;

    public Tree(Object r, ArrayList<Tree> tree_list) {
        root = r;
        if (root == null) {
            subtrees = new ArrayList<Tree>();
        }
        subtrees = (ArrayList<Tree>) tree_list.clone();
    }
    public int len() {
        return 0;
    }
}
