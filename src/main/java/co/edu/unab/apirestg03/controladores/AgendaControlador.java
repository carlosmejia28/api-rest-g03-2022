package co.edu.unab.apirestg03.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestg03.modelos.AgendaModelo;
import co.edu.unab.apirestg03.servicios.AgendaServicio;

@RestController
@RequestMapping("/agendas")
public class AgendaControlador {
    @Autowired
    AgendaServicio agendaServicio;

    @PostMapping()
    public AgendaModelo saveAgenda(@RequestBody AgendaModelo agenda){
        return agendaServicio.saveAgenda(agenda);
    }
}
