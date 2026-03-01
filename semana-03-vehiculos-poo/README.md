# Gestión de Vehículos – POO

Este proyecto es un sistema en consola que permite gestionar una flota de vehículos
de distintos tipos. El objetivo es demostrar el uso de herencia, clases abstractas,
polimorfismo e interfaces en Java, aplicados en un caso práctico.

---

## Diagrama de clases

[Vehiculo] (abstract)
   |
   +-------+--------+
   |       |        |
 [Auto]  [Moto]  [Camion]
   |        |
[AutoElectrico] [MotoElectrica]
   |
<<Electrico>> (interface)

---

## Decisiones de diseño

La clase Vehiculo se definió como abstracta porque representa un concepto general
y no debe instanciarse directamente. Cada tipo de vehículo implementa su propio
comportamiento del método acelerar().

La interfaz Electrico se utilizó para definir un contrato común para los vehículos
eléctricos, permitiendo que distintas clases implementen los mismos métodos sin
necesidad de una jerarquía adicional.

---

## Cómo compilar y ejecutar

Desde la carpeta semana-03-vehiculos-poo:

javac Main.java
java Main

---

## Ejemplo de salida

== acelerar() en toda la flota ==
Toyota (auto) acelera.
Honda (moto) acelera ligero.
Volvo (camion, 24.0t) acelera despacio.
Tesla (electrico) acelera. Bateria: 75%
NIU (moto electrica) acelera. Bateria: 57%

=== GESTION DE VEHICULOS ===
1. Listar todos
2. Filtrar por tipo
3. Ver electricos y baterias
4. Cargar baterias bajas
5. Demostrar polimorfismo
6. Estadisticas
7. Salir