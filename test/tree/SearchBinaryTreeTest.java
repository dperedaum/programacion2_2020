package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchBinaryTreeTest {

    @Test
    void testInsert() {
        SearchBinaryTree<Long, Estudiante> myTreeEstudiantesXCedula = new MySearchBinaryTree<>();

        Estudiante est1 = new Estudiante(1234, 456, "Daniel", "Pereda");
        Estudiante est2 = new Estudiante(678, 1234, "Patricio", "Carrau");
        Estudiante est3 = new Estudiante(987, 123, "Juan", "Blanco");

        myTreeEstudiantesXCedula.insert(est1.getCedula(), est1);
        myTreeEstudiantesXCedula.insert(est2.getCedula(), est2);
        myTreeEstudiantesXCedula.insert(est3.getCedula(), est3);

        assertTrue(myTreeEstudiantesXCedula.contains(678l));

        // Realizar busquedas eficientes por pasaporte.... ???
        SearchBinaryTree<Long, Estudiante> myTreeEstudiantesXPasaporte = new MySearchBinaryTree<>();
        myTreeEstudiantesXPasaporte.insert(est1.getPasaporte(), est1);
        myTreeEstudiantesXPasaporte.insert(est2.getPasaporte(), est2);
        myTreeEstudiantesXPasaporte.insert(est3.getPasaporte(), est3);

        assertTrue(myTreeEstudiantesXPasaporte.contains(1234l));
    }

    @Test
    void testToStringEstudiante() {
        Estudiante est1 = new Estudiante(1234, 456, "Daniel", "Pereda");
        Estudiante est2 = new Estudiante(678, 1234, "Patricio", "Carrau");

        System.out.println("Docente: " + est1);
        System.out.println("Estudiante: " + est2.toString());


        Integer[] arrayInteger = new Integer[10];

        arrayInteger[2] = 5;

        arrayInteger[2] = 6;

    }

    @Test
    void testDelete() {
        SearchBinaryTree<Long, Estudiante> myTreeEstudiantesXCedula = new MySearchBinaryTree<>();

        Estudiante est1 = new Estudiante(1234, 456, "Daniel", "Pereda");
        Estudiante est2 = new Estudiante(678, 1234, "Patricio", "Carrau");
        Estudiante est3 = new Estudiante(987, 123, "Juan", "Blanco");

        myTreeEstudiantesXCedula.insert(est1.getCedula(), est1);
        myTreeEstudiantesXCedula.insert(est2.getCedula(), est2);
        myTreeEstudiantesXCedula.insert(est3.getCedula(), est3);

        assertTrue(myTreeEstudiantesXCedula.contains(1234l));

        myTreeEstudiantesXCedula.delete(1234l);

        assertFalse(myTreeEstudiantesXCedula.contains(1234l));

        assertTrue(myTreeEstudiantesXCedula.contains(678l));

        myTreeEstudiantesXCedula.delete(678l);

        assertFalse(myTreeEstudiantesXCedula.contains(678l));

        assertTrue(myTreeEstudiantesXCedula.contains(987l));

        myTreeEstudiantesXCedula.delete(987l);

        assertFalse(myTreeEstudiantesXCedula.contains(987l));

    }

}