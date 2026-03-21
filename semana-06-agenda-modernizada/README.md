# Agenda de Contactos

## 1. Descripción del proyecto
Proyecto Java que implementa una agenda de contactos con persistencia en JSON. Permite agregar, buscar, listar y filtrar contactos por categoría, validando los datos ingresados. Incluye pruebas unitarias con JUnit para asegurar la correcta funcionalidad.

## 2. Métodos refactorizados con Streams
| Método | Antes | Después (Streams) |
|--------|-------|-----------------|
| buscarPorNombreExacto | Retornaba null si no encontraba contacto, con for tradicional | Devuelve Optional<Contacto> usando stream().filter(...).findFirst() |
| filtrarPorCategoria | Recorría ArrayList con for, agregando coincidencias manualmente | return contactos.stream().filter(c -> c.getCategoria().equalsIgnoreCase(categoria)).collect(Collectors.toCollection(ArrayList::new)) |
| obtenerNombres | Recorría ArrayList con for y añadía manualmente nombres | return contactos.stream().map(Contacto::getNombre).collect(Collectors.toCollection(ArrayList::new)) |
| contarPorCategoria | Usaba for y contador manual | return contactos.stream().filter(c -> c.getCategoria().equalsIgnoreCase(categoria)).count() |
## 3. Cómo Compilar y Ejecutar

Compilar el proyecto con Maven:

mvn clean compile

Ejecutar el programa principal:

mvn exec:java "-Dexec.mainClass=Main"

Ejecutar pruebas unitarias:

mvn test

## 4. Decisiones Tomadas
El método 'buscarPorNombreExacto' devuelve Optional<Contacto> en lugar de null
para evitar NullPointerException al buscar contactos no existentes.
Permite manejar los resultados de forma segura usando isPresent() o orElse().
Hace que el código sea más limpio y expresivo, especialmente al combinar con Streams.

## 5. Resultado de mvn test
```text
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running servicio.GestorContactosTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.234 s - in servicio.GestorContactosTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] BUILD SUCCESS
[INFO] -------------------------------------------------------


