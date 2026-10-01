package pe.edu.pucp.gtics.charlie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pucp.gtics.charlie.entity.Configuracion;
// Repository: Spring genera automáticamente guardar, buscar, eliminar, etc.
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {}
