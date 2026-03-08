# Sistema de Gestión de Estudiantes

Este programa es una aplicación desarrollada en Java que permite gestionar estudiantes mediante su carnet, nombre, carrera y promedio. El sistema permite registrar, buscar, actualizar y eliminar estudiantes, además de mostrar rankings, top 5, estadísticas generales y el historial de operaciones realizadas. El objetivo del proyecto es demostrar el uso de diferentes estructuras de datos de Java para resolver distintos problemas dentro de un mismo sistema.

## Tabla comparativa de estructuras utilizadas

| Colección | Rol en el sistema | Justificación |
|-----------|------------------|---------------|
| **HashMap<String, Estudiante>** | Búsqueda de estudiantes por carnet en **O(1)** | Permite acceso directo utilizando el carnet como clave |
| **TreeSet<Estudiante>** | Mantiene el **ranking automático por promedio** | Los estudiantes se mantienen ordenados automáticamente según su promedio |
| **ArrayList<String>** | Guarda el **historial de operaciones** del sistema | Permite registrar las acciones en el orden en que ocurren |

## Cómo compilar el proyecto

Ubicarse en la carpeta raíz del proyecto y ejecutar el siguiente comando:

javac modelo/Estudiante.java servicio/GestorEstudiantes.java Main.java

Este comando compilará los archivos del proyecto y generará los archivos .class necesarios para ejecutar el programa.

## Cómo ejecutar el programa

Después de compilar el proyecto ejecutar el siguiente comando:

java Main

## Ejemplo de salida del programa

=== SISTEMA DE ESTUDIANTES ===
1. Agregar estudiante
2. Buscar por carnet
3. Actualizar promedio
4. Eliminar estudiante
5. Ver ranking completo
6. Ver top 5
7. Filtrar por carrera
8. Ver historial
9. Ver estadísticas
0. Salir

Opcion: 5

=== Ranking de estudiantes ===
1. [2021006] Pedro Vargas         Sistemas        55.0
2. [2021004] Luis Mamani          Civil           61.0
3. [2021010] Diego Arce           Civil           67.5
4. [2021008] Hugo Espejo          Industrial      70.0
5. [2021001] Ana Torres           Sistemas        75.5
6. [2021005] Rosa Flores          Industrial      79.5
7. [2021007] Silvia Choque        Civil           83.5
8. [2021002] Carlos Quispe        Industrial      88.0
9. [2021003] Maria Condori        Sistemas        92.3
10. [2021009] Patricia Lima       Sistemas        95.0