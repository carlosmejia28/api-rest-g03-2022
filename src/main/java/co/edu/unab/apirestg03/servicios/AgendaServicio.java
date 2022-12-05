package co.edu.unab.apirestg03.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.AgendaModelo;
import co.edu.unab.apirestg03.modelos.MedicoModelo;
import co.edu.unab.apirestg03.repositorios.AgendaRepositorio;
import co.edu.unab.apirestg03.repositorios.MedicoRepositorio;

@Service
public class AgendaServicio {
    @Autowired
    AgendaRepositorio agendaRepositorio;
    @Autowired
    MedicoRepositorio medicoRepositorio;

    public Optional <AgendaModelo> getAgendaById(String id){
        Optional <AgendaModelo> agenda= agendaRepositorio.findById(id);
        Optional <MedicoModelo> medico = medicoRepositorio.findById(agenda.get().getId_medico());
        agenda.get().setNombremedico(medico.get().getNombre());
        agenda.get().setEspecialidad(medico.get().getEspecialidad());
        return agenda;
    }
    public AgendaModelo saveAgenda(AgendaModelo agenda){
        return agendaRepositorio.save(agenda);
    }
    
}
