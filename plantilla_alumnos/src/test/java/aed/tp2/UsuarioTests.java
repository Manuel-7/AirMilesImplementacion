package aed.tp2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTests {
    
    @Test
    void crearUsuario() {
        Usuario us = new Usuario(1325);
        assertEquals(1325, us.ID());
        assertEquals(0, us.totales());
    }

    @Test
    void crearUsuarioConReferido() {
        Usuario us = new Usuario(1328, true);
        assertEquals(1328, us.ID());
        assertEquals(500, us.totales());        
        assertEquals(500, us.disponibles());
        assertEquals(0, us.canjeadas());
    }


    @Test
    void agregarMillas() {
        Usuario us = new Usuario(1325);
        assertEquals(1325, us.ID());
        assertEquals(0, us.totales());
        assertEquals(0, us.disponibles());
        
        us.acumularMillas(150);        
        assertEquals(150, us.totales());
        assertEquals(150, us.disponibles());

        us.canjearMillas(100);        
        assertEquals(150, us.totales());
        assertEquals(50, us.disponibles());
    }

    /*testear transferencias */

    /*testear pares trasnferidores exlusivos */

}
