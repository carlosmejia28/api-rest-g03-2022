package co.edu.unab.apirestg03.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.AgendaModelo;
import co.edu.unab.apirestg03.repositorios.AgendaRepositorio;

@Service
public class AgendaServicio {
    @Autowired
    AgendaRepositorio agendaRepositorio;

    public AgendaModelo saveAgenda(AgendaModelo agenda){
        return agendaRepositorio.save(agenda);
    }

    
}
