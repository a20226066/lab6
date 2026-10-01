# Charlie la Hormiga - versión comentada

Proyecto educativo Spring Boot 3 / Java 17 con MVC + Thymeleaf + JPA + H2.

## Qué estudiar
1. `entity/Configuracion.java`: tabla PADRE.
2. `entity/VisualizacionTurista.java`: tabla HIJA y FK `configuracion_id`.
3. `dto/`: datos que viajan entre HTML y Controller.
4. `service/CharlieService.java`: mira `guardarTurista()`: ahí se crea la relación.
5. `controller/CharlieController.java`: rutas GET/POST.
6. `templates/fragments/formulario-turista.html`: fragmento Thymeleaf reutilizable.

## Relación
`configuracion (1) ---- (N) visualizacion_turista`

## Ejecutar
1. Abrir la carpeta como proyecto Maven en IntelliJ.
2. Usar Java 17 o superior.
3. Ejecutar `CharlieApplication.java`.
4. Abrir `http://localhost:8080`.

La BD H2 se crea automáticamente en la carpeta `data`. Para verla: `/h2-console`, JDBC URL `jdbc:h2:file:./data/charlie`, usuario `sa`, contraseña vacía.

IMPORTANTE: la relación de tablas es una propuesta de implementación para representar la configuración de segundo nivel/turistas; el PDF no exige explícitamente JPA ni nombres concretos de tablas.
