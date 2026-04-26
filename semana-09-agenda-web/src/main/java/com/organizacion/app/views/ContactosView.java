package com.organizacion.app.views;

import com.organizacion.app.ui.MainLayout;
import com.organizacion.app.ui.TarjetaContacto;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {

    public ContactosView() {
        setSizeFull();
        setPadding(true);
        
        H2 titulo =new H2("Contactos");
        Paragraph descripcion =new Paragraph("Gestiona todos tus contactos en un solo lugar");
        H3 subtitulo =new H3("Mis Contactos");

        FlexLayout cuadricula =new FlexLayout();
        cuadricula.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        cuadricula.setWidthFull();
        cuadricula.add(
            new TarjetaContacto ("Ana Martinez","71234567","ana@email.com"),
            new TarjetaContacto ("Carlos Quispe","78901234","carlos@email.com"),
            new TarjetaContacto ("Lucia Flores","69876543","lucia@email.com"),
            new TarjetaContacto ("Roberto Vargas","72345678","roberto@email.com")
        );

         VerticalLayout contenido =new VerticalLayout(titulo,descripcion,subtitulo,cuadricula);
         contenido.setPadding(false);
         Div footer =new Div(new Span("Agenda de Contactos v1.0"));
         footer.setWidthFull();

        add(contenido,footer);
        expand(contenido);
    }
}