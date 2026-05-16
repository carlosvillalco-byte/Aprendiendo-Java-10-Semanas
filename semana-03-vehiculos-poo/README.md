# Gestión de Vehículos – POO - Semana 3

## 1.-Descripción

Este proyecto es un sistema en consola que permite gestionar una flota de vehículos
de distintos tipos. El objetivo es demostrar el uso de herencia, clases abstractas,
polimorfismo e interfaces en Java, aplicados en un caso práctico.

---

## 2.-Diagrama de clases

```
       [Vehiculo] (abstract)
           |
   +-------+--------+
   |       |        |
 [Auto]  [Moto]  [Camion]
   |        |
[AutoElectrico] [MotoElectrica]
   |                 |
   +--------+--------+
            |
      <<Electrico>> (interface)

```

## 3.-Decisiones de diseño

La clase Vehiculo se definió como abstracta porque representa un concepto general
y no debe instanciarse directamente. Cada tipo de vehículo implementa su propio
comportamiento del método acelerar().

La interfaz Electrico se utilizó para definir un contrato común para los vehículos
eléctricos, permitiendo que distintas clases implementen los mismos métodos sin
necesidad de una jerarquía adicional.

---

## 4.-Cómo compilar y ejecutar

Desde la carpeta semana-03-vehiculos-poo:

javac Main.java
java Main

---

## 5.-Ejemplo de salida

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