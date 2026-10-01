package pe.edu.pucp.gtics.charlie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pucp.gtics.charlie.entity.VisualizacionTurista;
import java.util.List;
public interface VisualizacionTuristaRepository extends JpaRepository<VisualizacionTurista, Long> {
    // Spring interpreta el nombre y genera: buscar turistas por configuracion_id.
    List<VisualizacionTurista> findByConfiguracionId(Long configuracionId);
}
