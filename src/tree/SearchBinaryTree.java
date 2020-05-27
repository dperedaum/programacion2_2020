package tree;

import lista.MyList;

public interface SearchBinaryTree<Key extends Comparable, Value> {

    void insert(Key key, Value value);

    boolean contains(Key p);

    void delete(Key p);

    MyList<Value> preOrderValues();

    MyList<Value> inOrderValues();

}
