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

    /*testeo transferencias */
    @Test
    void transferenciasVarias() {
        Usuario us1 = new Usuario(1328);
        Usuario us2 = new Usuario(1234);
        assertEquals(1328, us1.ID());
        /*chequero que los atributos esten bien */
        assertFalse(us1.esTransferidorExlusivo());        
        assertFalse(us1.esReceptorExlusivo()); 
        assertEquals(us1.ID(), us1.ultimoUsuarioTransferido());
        assertEquals(us1.ID(), us1.ultimoUsuarioRecibido());

        us1.acumularMillas(1000);
        us2.acumularMillas(1000);

        assertEquals(1000, us1.totales());
        assertEquals(1000, us2.totales());

        us1.transferencia(us2,150);

        assertEquals(850, us1.totales());
        assertEquals(850, us1.disponibles());
        assertEquals(150, us1.canjeadas());
        assertEquals(true, us1.esTransferidorExlusivo());
        assertEquals(us2.ID(), us1.ultimoUsuarioTransferido());
        assertEquals(false, us1.esReceptorExlusivo());
        assertEquals(us1.ID(), us1.ultimoUsuarioRecibido());

        assertEquals(1150, us2.totales());
        assertEquals(1150, us2.disponibles());
        assertEquals(0, us2.canjeadas());
        assertEquals(false, us2.esTransferidorExlusivo());
        assertEquals(us2.ID(), us2.ultimoUsuarioTransferido());
        assertEquals(true, us2.esReceptorExlusivo());
        assertEquals(us1.ID(), us2.ultimoUsuarioRecibido());        
    }

    /*testeo pares trasnferidores exlusivos */
    @Test
    void transferidoresExclusivos() {
        Usuario us1 = new Usuario(1328);
        Usuario us2 = new Usuario(1234);

        us1.acumularMillas(1000);
        us2.acumularMillas(1000);

        us1.transferencia(us2,150);

        assertFalse(us1.estaEnParejaTransferidoresExclusivos());
        assertFalse(us2.estaEnParejaTransferidoresExclusivos());
        
        us2.transferencia(us1,500);

        /*interaccion basica dos a dos */

        assertTrue(us1.estaEnParejaTransferidoresExclusivos());
        assertTrue(us2.estaEnParejaTransferidoresExclusivos());

        assertEquals(us2.ID(), us1.parejaTransferidoraExclusiva());
        assertEquals(us1.ID(), us2.parejaTransferidoraExclusiva());

        /*hay mas transferencias con terceros */

        Usuario us3 = new Usuario(4567,true);

        us3.transferencia(us1, 250);        

        assertFalse(us1.estaEnParejaTransferidoresExclusivos());
        assertFalse(us2.estaEnParejaTransferidoresExclusivos());
        assertFalse(us3.estaEnParejaTransferidoresExclusivos());        
    }

}

