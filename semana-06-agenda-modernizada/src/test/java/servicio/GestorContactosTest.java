package servicio;

import modelo.Contacto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GestorContactosTest {

    private AgendaContactos agenda;

    @BeforeEach
    void setUp() {

        agenda = new AgendaContactos();

        // limpiar lista para pruebas
        agenda.listarTodos().clear();

        agenda.agregar(new Contacto("1","Ana Lopez","7654321","","","Amigos"));
        agenda.agregar(new Contacto("2","Carlos Rios","7111223","","","Trabajo"));
        agenda.agregar(new Contacto("3","Beatriz Vega","6888123","","","Trabajo"));
    }

    // ✅ T1
    @Test
    void buscarPorNombreDevuelveOptionalPresente() {

        Optional<Contacto> r = agenda.buscarPorNombreExacto("Ana Lopez");

        assertTrue(r.isPresent());
    }

    // ✅ T2
    @Test
    void buscarPorNombreDevuelveOptionalVacio() {

        Optional<Contacto> r = agenda.buscarPorNombreExacto("No existe");

        assertFalse(r.isPresent());
    }

    // ✅ T3
    @Test
    void filtrarPorCategoriaCorrecto() {

        var lista = agenda.filtrarPorCategoria("Trabajo");

        assertEquals(2, lista.size());
    }

    // ✅ T4
    @Test
    void obtenerNombresCorrecto() {

        var nombres = agenda.obtenerNombres();

        assertTrue(nombres.contains("Ana Lopez"));
    }

    // ✅ T5
    @Test
    void contarPorCategoriaCorrecto() {

        long total = agenda.contarPorCategoria("Trabajo");

        assertEquals(2, total);
    }

    // ✅ T6
    @Test
    void agregarDuplicadoLanzaExcepcion() {

        assertThrows(RuntimeException.class, () -> {
            agenda.agregar(new Contacto("4","Ana Lopez","9999999","","","Amigos"));
        });
    }
}