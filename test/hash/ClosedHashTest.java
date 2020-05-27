package hash;

import org.junit.jupiter.api.Test;
import tree.Estudiante;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClosedHashTest {

    @Test
    public void testMyHash() {
        Estudiante est1 = new Estudiante(1234, 456, "Daniel", "Pereda");
        Estudiante est2 = new Estudiante(678, 1234, "Patricio", "Carrau");

        MyHash<Long, Estudiante> hashEstudiante = new ClosedHashImpl<>(20);

        hashEstudiante.put(est1.getCedula(), est1);
        hashEstudiante.put(est2.getCedula(), est2);

        assertEquals(2, hashEstudiante.size());
        assertEquals("Daniel", hashEstudiante.get(1234l).getNombre());
        assertEquals("Patricio", hashEstudiante.get(678l).getNombre());
        assertNull(hashEstudiante.get(3455l));
    }
}
