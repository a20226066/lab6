package pe.edu.pucp.gtics.charlie.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.gtics.charlie.dto.*;
import pe.edu.pucp.gtics.charlie.entity.Configuracion;
import pe.edu.pucp.gtics.charlie.service.CharlieService;

/** CONTROLLER: recibe peticiones del navegador y decide qué HTML mostrar. */
@Controller
public class CharlieController {
    private final CharlieService service;
    public CharlieController(CharlieService service){this.service=service;}

    // GET / -> abre el formulario inicial.
    @GetMapping("/")
    public String inicio(Model model){model.addAttribute("configuracionDTO",new ConfiguracionDTO());return "configuracion";}

    // POST /configurar -> recibe el DTO, lo guarda y redirige al detalle.
    @PostMapping("/configurar")
    public String configurar(@ModelAttribute ConfiguracionDTO dto){
        Configuracion guardada=service.guardarConfiguracion(dto);
        return "redirect:/configuracion/"+guardada.getId();
    }

    // GET /configuracion/{id} -> muestra padre, turistas y formulario fragmentado.
    @GetMapping("/configuracion/{id}")
    public String detalle(@PathVariable Long id, Model model){
        model.addAttribute("config",service.buscar(id));
        model.addAttribute("turistas",service.listarTuristas(id));
        VisualizacionTuristaDTO dto=new VisualizacionTuristaDTO(); dto.setConfiguracionId(id);
        model.addAttribute("turistaDTO",dto);
        return "simulacion";
    }

    // POST /turista/guardar -> crea el registro hijo relacionado con configuracion.
    @PostMapping("/turista/guardar")
    public String guardarTurista(@ModelAttribute VisualizacionTuristaDTO dto){
        service.guardarTurista(dto);
        return "redirect:/configuracion/"+dto.getConfiguracionId();
    }
}
