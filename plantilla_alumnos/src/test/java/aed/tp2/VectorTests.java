package aed.tp2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTests {


    @Test
    void crearVector() {
        Vector vec = new Vector();
        assertTrue(vec.vacia());
        assertEquals(0, vec.longitud());
    }

    @Test
    void agregarElementos() {
        Vector vec = new Vector();

        Usuario us1 = new Usuario(1);
        vec.agregarAdelante(us1);

        assertFalse(vec.vacia());
        assertEquals(us1, vec.obtener(0));
        
        Usuario us2 = new Usuario(2);
        vec.agregarAtras(us2);
        assertEquals(2, vec.longitud());
        assertEquals(us1, vec.obtener(0));
        assertEquals(us2, vec.obtener(1));
        

        Usuario us3 = new Usuario(3);
        vec.agregarAtras(us3);

        assertEquals(us1, vec.obtener(0));
        assertEquals(us2, vec.obtener(1));
        assertEquals(us3, vec.obtener(2));

        vec.eliminar(1);
        assertEquals(us1, vec.obtener(0));       
        assertEquals(us1, vec.primero());
        assertEquals(us3, vec.obtener(1)); 
        assertEquals(us3, vec.ultimo());        
        assertEquals(2, vec.longitud());
        
    }

}
