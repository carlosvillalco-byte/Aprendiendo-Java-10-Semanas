package com.organizacion.app.views;

import com.organizacion.app.modelo.Contacto;
import com.organizacion.app.ui.MainLayout;
import com.organizacion.app.ui.TarjetaContacto;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {
    private Binder<Contacto> binder = new Binder<>(Contacto.class);

    public ContactosView() 
    {
        setSizeFull();
        setPadding(true);
        H2 titulo = new H2("Contactos");
        Paragraph descripcion = new Paragraph("Gestiona todos tus contactos en un solo lugar");
        H3 subtitulo = new H3("Mis Contactos");
        TextField campoNombre = new TextField("Nombre completo");
        EmailField campoEmail = new EmailField("Correo electronico");
        NumberField campoTelefono = new NumberField("Telefono");
        campoNombre.setPlaceholder("Ej: Ana Quispe");
        campoEmail.setPlaceholder("Ej: ana@correo.com");
        campoTelefono.setPlaceholder("Ej: 71234567");
        campoNombre.setWidthFull();
        campoEmail.setWidthFull();
        campoTelefono.setWidthFull();
        configurarBinder(campoNombre, campoEmail, campoTelefono);
        FormLayout formulario = new FormLayout();
        formulario.add(campoNombre, campoEmail, campoTelefono);
        formulario.setColspan(campoNombre, 2);
        formulario.setWidthFull();
        FlexLayout cuadricula = new FlexLayout();
        cuadricula.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        cuadricula.setWidthFull();
        cuadricula.add(
            new TarjetaContacto("Ana Martinez","71234567","ana@email.com"),
            new TarjetaContacto("Carlos Quispe","78901234","carlos@email.com"),
            new TarjetaContacto("Lucia Flores","69876543","lucia@email.com"),
            new TarjetaContacto("Roberto Vargas","72345678","roberto@email.com")
        );
        VerticalLayout contenido = new VerticalLayout(
                titulo,
                descripcion,
                formulario,   
                subtitulo,
                cuadricula
        );
        contenido.setPadding(false);
        Div footer = new Div(new Span("Agenda de Contactos v1.0"));
        footer.setWidthFull();
        add(contenido, footer);
        expand(contenido);
    }
    private void configurarBinder(TextField campoNombre, EmailField campoEmail, NumberField campoTelefono) 
    {
        binder.forField(campoNombre)
                .asRequired("El nombre no puede estar vacio") // VALIDACIÓN
                .bind(Contacto::getNombre, Contacto::setNombre);
        binder.forField(campoEmail)
                .bind(Contacto::getEmail, Contacto::setEmail);
        binder.forField(campoTelefono)
                .withConverter
                (
                        v -> v == null ? "" : String.valueOf(v.intValue()),
                        t -> t == null || t.isEmpty() ? null : Double.valueOf(t)
                )
                .bind(Contacto::getTelefono, Contacto::setTelefono);
    }
}