package pe.edu.pucp.gtics.charlie.entity;

import jakarta.persistence.*;

/** TABLA HIJA: cada registro guarda el avance/configuración de un turista. */
@Entity
@Table(name = "visualizacion_turista")
public class VisualizacionTurista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreTurista;
    private int numeroMovimientos; // Número de movimientos que verá/ha guardado el turista.

    /**
     * RELACIÓN N:1: muchos turistas pueden apuntar a una configuración.
     * @JoinColumn crea la FK configuracion_id en esta tabla.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuracion_id", nullable = false)
    private Configuracion configuracion;

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNombreTurista(){return nombreTurista;} public void setNombreTurista(String v){nombreTurista=v;}
    public int getNumeroMovimientos(){return numeroMovimientos;} public void setNumeroMovimientos(int v){numeroMovimientos=v;}
    public Configuracion getConfiguracion(){return configuracion;} public void setConfiguracion(Configuracion v){configuracion=v;}
}
