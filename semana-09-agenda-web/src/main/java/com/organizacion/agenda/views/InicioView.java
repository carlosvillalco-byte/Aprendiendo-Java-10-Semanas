package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    public InicioView() 
    {
        H2 titulo = new H2("Bienvenido a tu Agenda");
        Paragraph descripcion = new Paragraph("Guarda y organiza tus contactos");
        add(titulo, descripcion);
    }
}