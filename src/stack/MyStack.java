package stack;

public interface MyStack<TipoNadaCosa> extends Iterable<TipoNadaCosa>  {

    void push(TipoNadaCosa element);

    TipoNadaCosa pop();

    TipoNadaCosa top();

    int size();

}
