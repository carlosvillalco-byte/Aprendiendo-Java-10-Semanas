package com.organizacion.agenda;

import com.organizacion.agenda.modelo.Contacto;
import com.organizacion.agenda.service.ContactoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactoServiceTest {

    @Test
    public void testCrearContacto() {

        Contacto contacto =
                new Contacto( "Carlos", "71234567","carlos@correo.com");

        assertEquals( "Carlos",contacto.getNombre());
    }

    @Test
    public void testServicioExiste() {
        ContactoService servicio = new ContactoService();
        assertNotNull(servicio);
    }
}