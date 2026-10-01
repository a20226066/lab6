package pe.edu.pucp.gtics.charlie.dto;
/** DTO: transporta datos del formulario sin exponer directamente la entidad JPA. */
public class ConfiguracionDTO {
    private int filas=5, columnas=5, aumentoVision=4, posicionFila=2, posicionColumna=2;
    private String direccionInicial="R";
    public int getFilas(){return filas;} public void setFilas(int v){filas=v;}
    public int getColumnas(){return columnas;} public void setColumnas(int v){columnas=v;}
    public int getAumentoVision(){return aumentoVision;} public void setAumentoVision(int v){aumentoVision=v;}
    public int getPosicionFila(){return posicionFila;} public void setPosicionFila(int v){posicionFila=v;}
    public int getPosicionColumna(){return posicionColumna;} public void setPosicionColumna(int v){posicionColumna=v;}
    public String getDireccionInicial(){return direccionInicial;} public void setDireccionInicial(String v){direccionInicial=v;}
}
