package tree;

import lista.MyList;

import java.util.Iterator;

public class MySearchBinaryTree<Key extends Comparable<Key>, Value>
        implements SearchBinaryTree<Key, Value> {

    private TreeNode<Key, Value> root;

    public MySearchBinaryTree() {
        this.root = null;
    }

    @Override
    public void insert(Key key, Value value) {

        this.root = insert(key, value, this.root);
    }

    private TreeNode<Key, Value> insert(Key key, Value value, TreeNode<Key, Value> subTree) {

        if (subTree == null) {

            TreeNode<Key, Value> newNode = new TreeNode(key, value);
            subTree = newNode;

        } else {

            if (key.compareTo(subTree.getKey()) > 0) {

                subTree.setRight(insert(key, value, subTree.getRight()));

            } else if (key.compareTo(subTree.getKey()) < 0)  {

                subTree.setLeft(insert(key, value, subTree.getLeft()));

            } else {

                // El elemento ya esta insertado no se hace nada.

            }

        }

        return subTree;
    }

    @Override
    public void delete(Key p) {

        root = delete(p, root);

    }

    private TreeNode<Key, Value> delete(Key p, TreeNode<Key, Value> root) {
        TreeNode<Key, Value> returnTree = root;

        if (root.getKey().compareTo(p) == 0) {

            if (root.getLeft() == null && root.getRight() == null) {

                returnTree = null;

            } else if (root.getLeft() == null) {

                returnTree = root.getRight();

            } else if (root.getRight() == null) {

                returnTree = root.getLeft();

            } else {

                TreeNode<Key, Value>  min = getMax(root.getLeft());

                root.setKey(min.getKey());
                root.setValue(min.getValue());
                root.setLeft(delete(min.getKey(), root.getLeft()));

            }

        } else if (p.compareTo(root.getKey()) > 0) {

            root.setRight(delete(p, root.getRight()));

        } else {

            root.setLeft(delete(p, root.getLeft()));

        }

        return returnTree;
    }

    private TreeNode<Key, Value> getMax(TreeNode<Key, Value> root) {
        TreeNode<Key, Value> result = null;

        if (root != null) {

            if (root.getRight() == null) {

                result = root;

            } else {

                result = getMax(root.getRight());

            }

        }

        return result;
    }

    @Override
    public boolean contains(Key p) {
        return contains(p, this.root);
    }


    private boolean contains(Key p, TreeNode<Key, Value> subTree) {
        boolean result = false;

        if (subTree != null) {

            if (p.compareTo(subTree.getKey()) == 0) {

                result = true;

            } else if (p.compareTo(subTree.getKey()) > 0) {

                result = contains(p, subTree.getRight());

            } else {

                result = contains(p, subTree.getLeft());
            }

        }

        return result;
    }

    @Override
    public MyList<Value> preOrderValues() {
        // FIXME hacer
        return null;
    }

    @Override
    public MyList<Value> inOrderValues() {
        // FIXME Hacer
        return null;
    }

}
