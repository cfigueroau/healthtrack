package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testActualizarPeso_DeberiaActualizarCorrectamente() {        
        Usuario usuario = new Usuario("Juan", 70.0);
        double nuevoPeso = 72.5;

        usuario.actualizarPeso(nuevoPeso);

        assertEquals(nuevoPeso, usuario.getPeso(), 0.01,
            "El peso del usuario no se actualizó correctamente. Se esperaba: " + nuevoPeso);
    }

    @Test
    void testMostrarInformacion() {
        Usuario usuario = new Usuario("Claudio", 70.5);
        usuario.actualizarPeso(75.0);
        assertEquals(75.0, usuario.getPeso(), 0.01);
    }

    @Test
    void testGettersYSetters() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ana");
        usuario.setPeso(65.0);

        assertEquals("Ana", usuario.getNombre());
        assertEquals(65.0, usuario.getPeso(), 0.01);
    }

    @Test
    void testToString_DeberiaIncluirNombreYPeso() {
        Usuario usuario = new Usuario("Claudio", 75.0);
        String resultado = usuario.toString();

        assertTrue(resultado.contains("Claudio"));
        assertTrue(resultado.contains("75.0"));
    }

    @Test
    void testActualizarPesoCero() {
        Usuario usuario = new Usuario("Ana", 60.0);
        usuario.actualizarPeso(0.0);
        assertEquals(0.0, usuario.getPeso(), 0.001);
    }

    @Test
    void testActualizarPesoNegativo() {
        Usuario usuario = new Usuario("Carlos", 70.0);
        usuario.actualizarPeso(-5.0);
        assertEquals(-5.0, usuario.getPeso(), 0.001);
    }

}
