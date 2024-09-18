import java.util.ArrayList;

public class Tree {
    // TODO
    private Object root;
    private ArrayList<Tree> subtrees;

    public Tree(Object r, ArrayList<Tree> tree_list) {
        root = r;
        if (root == null) {
            subtrees = new ArrayList<Tree>();
        } else {
            subtrees = (ArrayList<Tree>) tree_list.clone();
        }
    }

    public boolean IsEmpty() {
        return root == null;
    }

    public int Len() {
        if (this.IsEmpty()) {
            return 0;
        }
        else {
            int size = 1;
            for (Tree t : subtrees) {
                size += t.Len();
            }
            return size;
        }
    }

    public int Count(int item) {
        if (this.IsEmpty()) {
            return 0;
        }
        else {
            int size = 1;
            for (Tree t : subtrees) {
                size += t.Count(item);
            }
            return size;
        }
    }

    public String toString() {
        return this.StringIndented(0);
    }

    private String StringIndented(int depth) {
        if (this.IsEmpty()) {
            return "";
        }
        else {
            StringBuilder s = new StringBuilder("    ".repeat(depth) + (String) this.root + "/n");
            for (Tree t : subtrees) {
                s.append(t.StringIndented(depth + 1));
            }
            return s.toString();
        }
    }

    public double Average() {
        if (this.IsEmpty()) {
            return 0.0;
        }
        else {
            int total = this.AverageHelper().getFirst();
            int count = this.AverageHelper().getLast();
            return (double) total / count;
        }
    }

    private ArrayList<Integer> AverageHelper() {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (this.IsEmpty()) {
            ret.add(0, 0);
            ret.add(1, 0);
            return ret;
        }
        else {
            Integer total = (Integer) this.root;
            Integer size = 1;
            for (Tree t : subtrees) {
                Integer subtree_total = (Integer) t.AverageHelper().getFirst();
                Integer subtree_size = (Integer) t.AverageHelper().getLast();
                total = total + subtree_total;
                size = size + subtree_size;
            }
            ret.add(total, size);
            return ret;
        }
    }

    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Tree t = (Tree) other;
        if (this.IsEmpty() && t.IsEmpty()){
            return true;
        } else if (this.IsEmpty() || t.IsEmpty()){
            return false;
        } else {
            if (this.root != t.root) {
                return false;
            }
            return this.subtrees.equals(t.subtrees);
        }
    }

    public boolean Contains(int item) {
        if (this.IsEmpty()) {
            return false;
        }
        else if (this.root.equals(item)) {
            return true;
        }
        else {
            for (Tree t : subtrees) {
                if (t.Contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ArrayList<Integer> Leaves() {
        if (this.IsEmpty()) {
            return null;
        } else if (this.subtrees.isEmpty()) {
            return (ArrayList<Integer>) this.root; // check cast
        }
    }
}
