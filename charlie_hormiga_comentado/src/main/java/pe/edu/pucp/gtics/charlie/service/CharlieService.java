package pe.edu.pucp.gtics.charlie.service;
import org.springframework.stereotype.Service;
import pe.edu.pucp.gtics.charlie.dto.*;
import pe.edu.pucp.gtics.charlie.entity.*;
import pe.edu.pucp.gtics.charlie.repository.*;
import java.util.List;

/** SERVICE: aquí va la lógica; el Controller queda pequeño y fácil de leer. */
@Service
public class CharlieService {
    private final ConfiguracionRepository configuracionRepository;
    private final VisualizacionTuristaRepository turistaRepository;
    public CharlieService(ConfiguracionRepository c, VisualizacionTuristaRepository t){this.configuracionRepository=c;this.turistaRepository=t;}

    /** Convierte el DTO del formulario en entidad y lo guarda en la tabla configuracion. */
    public Configuracion guardarConfiguracion(ConfiguracionDTO dto){
        Configuracion c=new Configuracion();
        c.setFilas(dto.getFilas()); c.setColumnas(dto.getColumnas()); c.setAumentoVision(dto.getAumentoVision());
        c.setPosicionFila(dto.getPosicionFila()); c.setPosicionColumna(dto.getPosicionColumna()); c.setDireccionInicial(dto.getDireccionInicial());
        return configuracionRepository.save(c);
    }

    /** Aquí se crea exactamente la relación entre las dos tablas. */
    public VisualizacionTurista guardarTurista(VisualizacionTuristaDTO dto){
        // 1) Buscamos el PADRE usando el ID recibido en el DTO.
        Configuracion padre=configuracionRepository.findById(dto.getConfiguracionId())
                .orElseThrow(() -> new IllegalArgumentException("Configuración no encontrada"));
        // 2) Creamos la entidad HIJA.
        VisualizacionTurista hijo=new VisualizacionTurista();
        hijo.setNombreTurista(dto.getNombreTurista());
        hijo.setNumeroMovimientos(dto.getNumeroMovimientos());
        // 3) Esta línea establece la relación N:1 y llenará configuracion_id.
        hijo.setConfiguracion(padre);
        // 4) INSERT en visualizacion_turista.
        return turistaRepository.save(hijo);
    }
    public Configuracion buscar(Long id){return configuracionRepository.findById(id).orElseThrow();}
    public List<VisualizacionTurista> listarTuristas(Long id){return turistaRepository.findByConfiguracionId(id);}
}
