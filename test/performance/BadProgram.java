package performance;

import lista.MyList;
import listaenlazada.MyLinkedList;

public class BadProgram {

    public static void badAlgorithm() {

        MyList<Integer> values = new MyLinkedList<>();

        for(int i = 0; i < 1000000; i++) {

            values.add(i);

        }

    }

    public static void badAlgorithm2() {

        MyList<Long> values = new MyLinkedList<>();

        while (true) {

            values.add(System.currentTimeMillis());

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {

        // Verificar tiempo de carga

        long start = 0, stop = 0;

        start = System.currentTimeMillis();

        badAlgorithm();

        stop = System.currentTimeMillis();

        System.out.println("Tiempo: " + (stop - start) + " ms.");


        // Verificar consumo de memoria y cpu

        badAlgorithm2();

    }

}
