#  Agenda Web con Vaadin – Semana 9

## 1. Descripción del proyecto

Este proyecto es una aplicación web desarrollada con Vaadin y Spring Boot que permite gestionar contactos mediante un formulario. El usuario puede ingresar nombre, correo electrónico y teléfono, los cuales son validados antes de guardarse. La información se persiste en un archivo JSON para mantener los datos incluso después de reiniciar la aplicación.

---

## 2. Diagrama de paquetes (ASCII)


ContactosView
     |
     v
ContactoService    <- @Service
     |
     v
ManejadorJSON      <- lee/escribe contactos.json
     |
     v
contactos.json


---

## 3. ¿Por qué la vista no toca el JSON directamente?

La vista (*ContactosView) no accede directamente al archivo JSON porque se sigue el principio de **separación de responsabilidades*.

- La vista solo maneja la interfaz (formularios, botones, eventos).
- El servicio (*ContactoService*) contiene la lógica de negocio.
- El manejador (*ManejadorJSON*) se encarga de la persistencia.

### Ventajas:
- Código más organizado y mantenible  
- Fácil de modificar (por ejemplo, cambiar JSON por base de datos)  
- Evita acoplamiento entre interfaz y almacenamiento  

👉 En resumen: *la vista no debe saber cómo se guardan los datos, solo que se guardan.*

---

## 4. Cómo compilar y ejecutar

Requisitos:
- Java 17 o superior  
- Maven  

Ejecutar en la raíz del proyecto:


mvn spring-boot:run


Luego abrir en el navegador:


http://localhost:8080


---

## 5. Ejemplo del JSON generado

Después de agregar un contacto, el archivo contactos.json tendrá esta estructura:

json
[
  {
    "nombre": "Carlos Mamani",
    "email": "carlos@correo.com",
    "telefono": "79876543"
  }
]


# 📘 Agenda Web con Vaadin – Semana 9

## 1. Descripción del proyecto

Este proyecto es una aplicación web desarrollada con Vaadin y Spring Boot que permite gestionar contactos mediante un formulario. El usuario puede ingresar nombre, correo electrónico y teléfono, los cuales son validados antes de guardarse. La información se persiste en un archivo JSON para mantener los datos incluso después de reiniciar la aplicación.

---

## 2. Diagrama de paquetes (ASCII)


ContactosView
     |
     v
ContactoService    <- @Service
     |
     v
ManejadorJSON      <- lee/escribe contactos.json
     |
     v
contactos.json


---

## 3. ¿Por qué la vista no toca el JSON directamente?

La vista (ContactosView) no accede directamente al archivo JSON porque se sigue el principio de separación de responsabilidades*.

- La vista solo maneja la interfaz (formularios, botones, eventos).
- El servicio (*ContactoService*) contiene la lógica de negocio.
- El manejador (*ManejadorJSON*) se encarga de la persistencia.

### Ventajas:
- Código más organizado y mantenible  
- Fácil de modificar (por ejemplo, cambiar JSON por base de datos)  
- Evita acoplamiento entre interfaz y almacenamiento  


---

## 4. Cómo compilar y ejecutar

Requisitos:
- Java 17 o superior  
- Maven  

Ejecutar en la raíz del proyecto:


mvn spring-boot:run


Luego abrir en el navegador:


http://localhost:8080


---

## 5. Ejemplo del JSON generado

Después de agregar un contacto, el archivo contactos.json tendrá esta estructura:

json
[
  {
    "nombre": "Carlos Mamani",
    "email": "carlos@correo.com",
    "telefono": "79876543"
  }
]


