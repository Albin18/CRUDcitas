package ch.com.servicio;

import java.util.List;
import ch.com.domain.Agenda;

public interface AgendaService {
    
    public List <Agenda> listarAgenda();
    
    public void guardar (Agenda agenda);
    
    public void eliminar (Agenda agenda);
    
    public Agenda encontrarAgenda (Agenda agenda);
    
}
