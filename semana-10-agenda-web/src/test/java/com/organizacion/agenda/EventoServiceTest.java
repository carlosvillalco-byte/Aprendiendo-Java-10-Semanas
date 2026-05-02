package com.organizacion.agenda;

import com.organizacion.agenda.modelo.Evento;
import com.organizacion.agenda.service.EventoService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventoServiceTest {

    @Test
    public void testCrearEvento() {

        Evento evento =
                new Evento(
                        "Reunion",
                        "2025-06-10",
                        "Proyecto"
                );

        assertEquals(
                "Reunion",
                evento.getTitulo()
        );
    }

    @Test
    public void testServicioExiste() {

        EventoService servicio =
                new EventoService();

        assertNotNull(servicio);
    }
}