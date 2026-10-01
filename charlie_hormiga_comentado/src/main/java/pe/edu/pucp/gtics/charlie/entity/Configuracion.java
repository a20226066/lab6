package pe.edu.pucp.gtics.charlie.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TABLA PADRE: configuracion.
 * Guarda los datos principales solicitados para la Isla del Capricho.
 */
@Entity
@Table(name = "configuracion")
public class Configuracion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK autogenerada.

    private int filas;              // Alto inicial del terreno.
    private int columnas;           // Ancho inicial del terreno.
    private int aumentoVision;      // Cuántas unidades aumenta el terreno al llegar al límite.
    private int posicionFila;       // Fila inicial de Charlie.
    private int posicionColumna;    // Columna inicial de Charlie.
    private String direccionInicial;// R=derecha, L=izquierda, U=arriba, D=abajo.

    /**
     * RELACIÓN 1:N.
     * Una configuración puede tener muchas visualizaciones de turistas.
     * mappedBy="configuracion" significa que la FK está en VisualizacionTurista.
     * cascade ALL hace que las operaciones del padre puedan propagarse a los hijos.
     */
    @OneToMany(mappedBy = "configuracion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisualizacionTurista> visualizaciones = new ArrayList<>();

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public int getFilas(){return filas;} public void setFilas(int v){filas=v;}
    public int getColumnas(){return columnas;} public void setColumnas(int v){columnas=v;}
    public int getAumentoVision(){return aumentoVision;} public void setAumentoVision(int v){aumentoVision=v;}
    public int getPosicionFila(){return posicionFila;} public void setPosicionFila(int v){posicionFila=v;}
    public int getPosicionColumna(){return posicionColumna;} public void setPosicionColumna(int v){posicionColumna=v;}
    public String getDireccionInicial(){return direccionInicial;} public void setDireccionInicial(String v){direccionInicial=v;}
    public List<VisualizacionTurista> getVisualizaciones(){return visualizaciones;}
    public void setVisualizaciones(List<VisualizacionTurista> v){visualizaciones=v;}
}
