# Gestor de Tareas POO - Semana 2

## 1.-Descripción del Proyecto

Este proyecto es un sistema de gestión de tareas desarrollado en Java aplicando los fundamentos de Programación Orientada a Objetos (POO).

El programa permite administrar tareas mediante un menú interactivo en consola, utilizando clases, encapsulamiento, ArrayList y packages.

El objetivo principal es practicar:
- Clases y objetos
- Encapsulamiento
- Constructores
- Getters y Setters
- ArrayList de objetos
- Organización del código con packages

---

## 2.-Funcionalidades Implementadas

### Gestión de tareas
- Agregar nuevas tareas
- Listar todas las tareas
- Listar tareas pendientes
- Listar tareas completadas
- Marcar tareas como completadas
- Eliminar tareas por ID

### Estadísticas
- Mostrar total de tareas
- Mostrar cantidad de tareas pendientes
- Mostrar cantidad de tareas completadas
- Mostrar porcentaje de tareas completadas

### Validaciones
- El título no puede estar vacío
- La descripción no puede estar vacía
- No se puede completar una tarea ya completada
- No se puede eliminar una tarea inexistente
- Manejo de lista vacía

---


## 3.-Instrucciones de Compilación y Ejecución

### a.-Compilar el proyecto

Desde la carpeta raíz del proyecto ejecutar:

bash
javac Main.java modelo/*.java servicio/*.java


### b.-Ejecutar el programa

bash
java Main


---

## 4.-Diagrama Simple de Clases

```
+------------------+
|      Tarea       |
+------------------+
| - id:int         |
| - titulo:String  |
| - descripcion:String |
| - estado:String  |
+------------------+
| + completar()    |
| + mostrarInfo()  |
| + estaCompletada() |
| + getters/setters |
+------------------+

          |

          v

+----------------------+
|    GestorTareas      |
+----------------------+
| - tareas:ArrayList   |
| - proximoId:int      |
+----------------------+
| + agregar()          |
| + listar()           |
| + listarPendientes() |
| + listarCompletadas()|
| + completar()        |
| + eliminar()         |
| + buscar()           |
| + totalTareas()      |
| + totalPendientes()  |
| + totalCompletadas() |
+----------------------+


---