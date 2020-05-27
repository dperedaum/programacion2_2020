package tree;

public class TreeNode<Key, Value> {

    private Key key;

    private Value value;

    private TreeNode<Key, Value> left;

    private TreeNode<Key, Value> right;

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public TreeNode<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<Key, Value> left) {
        this.left = left;
    }

    public TreeNode<Key, Value> getRight() {
        return right;
    }

    public void setRight(TreeNode<Key, Value> right) {
        this.right = right;
    }
}
