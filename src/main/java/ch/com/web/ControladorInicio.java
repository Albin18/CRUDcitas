package ch.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import ch.com.domain.Agenda;
import ch.com.servicio.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

@Autowired
private AgendaService agendaService;
    
@GetMapping ("/") 
    public String Inicio (Model model) {
        var citas = agendaService.listarAgenda();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("agendas", citas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Agenda agenda) {
        return "modificar";
        
    }
    
    @PostMapping("/guardar")
    public String guardar(Agenda agenda) {
        agendaService.guardar(agenda);
        return "redirect:/"; //Redireccion a la pagina de inicio
    }
    
    @GetMapping("/editar/{idAgenda}")
    public String editar (Agenda agenda, Model model) {
       agenda = agendaService.encontrarAgenda(agenda);
        model.addAttribute("agenda", agenda);
         return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar (Agenda agenda) {
        agendaService.eliminar(agenda);
        return "redirect:/";
    }
    
}
