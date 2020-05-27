import lista.MyList;
import lista.PosicionInvalida;
import listaenlazada.MyLinkedList;
import stack.MyStack;

public class Principal {


    public int buscarPrimerNumeroPar(MyList miLista) throws PosicionInvalida {
        int posicion = -1;
        boolean encontre = false;
        Integer i = 0;

        while (!encontre && i < miLista.size()) {

            if ( (Integer) miLista.get(i) % 2 == 0) {
                encontre = true;
                posicion = i;
            }

            i++;
        }


        return posicion;
    }


    public static void main(String[] args) {
        Integer value = 2;

        MyStack<Integer> stack = new MyLinkedList<>(); // Stack de Integer y solo puedo colocar Integer
        MyStack<String> otroStack = new MyLinkedList<>(); // Stack de String y solo puedo colocar String
        MyStack stackGeneral = new MyLinkedList(); // Stack de Object y puedo colocar cualquier cosa


        stack.push(value);
        stack.push(4);

        otroStack.push("Hola");

        stackGeneral.push(10);
        stackGeneral.push("Hola 10");

        Integer topValue = stack.pop();

        String cosa = (String) stackGeneral.pop(); // en el tope de la pila hay un String ("Hola 10")
        Integer cosa2 = (Integer) stackGeneral.pop(); // en el top de la pila esta el valor 10
    }

}
