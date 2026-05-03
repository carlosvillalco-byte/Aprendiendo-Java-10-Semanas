package com.organizacion.agenda.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {

        H2 titulo =new H2("Agenda de Contactos");

        MenuBar menu =new MenuBar();

        RouterLink linkInicio = new RouterLink( "Inicio", InicioView.class);

        RouterLink linkContactos = new RouterLink( "Contactos", ContactosView.class);

        RouterLink linkEventos =new RouterLink("Eventos",EventosView.class);

        menu.addItem(linkInicio);
        menu.addItem(linkContactos);
        menu.addItem(linkEventos);
        HorizontalLayout barra =new HorizontalLayout(titulo, menu);

        barra.setWidthFull();
        barra.expand(titulo);
        addToNavbar(barra);
    }
}