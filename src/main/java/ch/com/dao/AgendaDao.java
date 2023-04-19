package ch.com.dao;

import ch.com.domain.Agenda;
import org.springframework.data.repository.CrudRepository;

public interface AgendaDao extends CrudRepository<Agenda, Long>{
    
}
