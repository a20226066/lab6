package pe.edu.pucp.gtics.charlie.dto;
/** DTO del segundo nivel: recibe turista + movimientos + ID del padre. */
public class VisualizacionTuristaDTO {
    private Long configuracionId;
    private String nombreTurista;
    private int numeroMovimientos;
    public Long getConfiguracionId(){return configuracionId;} public void setConfiguracionId(Long v){configuracionId=v;}
    public String getNombreTurista(){return nombreTurista;} public void setNombreTurista(String v){nombreTurista=v;}
    public int getNumeroMovimientos(){return numeroMovimientos;} public void setNumeroMovimientos(int v){numeroMovimientos=v;}
}
