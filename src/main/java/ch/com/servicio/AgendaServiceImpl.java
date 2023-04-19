package ch.com.servicio;

import java.util.List;
import ch.com.dao.AgendaDao;
import ch.com.domain.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    private AgendaDao agendaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Agenda> listarAgenda() {
        return (List<Agenda>) agendaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Agenda agenda) {
       agendaDao.save(agenda);
    }

    @Override
    @Transactional
    public void eliminar(Agenda agenda) {
        agendaDao.delete(agenda);
    }

    @Override
    @Transactional(readOnly = true)
    public Agenda encontrarAgenda(Agenda agenda) {
      return agendaDao.findById(agenda.getIdAgenda()).orElse(null);
    }
    
}
