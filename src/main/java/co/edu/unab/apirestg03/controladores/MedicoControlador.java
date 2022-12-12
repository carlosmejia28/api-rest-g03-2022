package co.edu.unab.apirestg03.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestg03.modelos.MedicoModelo;
import co.edu.unab.apirestg03.servicios.MedicoServicio;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "*" , methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class MedicoControlador {
    @Autowired
    MedicoServicio medicoServicio;

    @GetMapping()
    public List<MedicoModelo> getAllMedicos(){
       return medicoServicio.getAllMedicos();
    }

    @PostMapping()
    public MedicoModelo saveMedico(@RequestBody MedicoModelo medico){
        return medicoServicio.saveMedico(medico);
    }
}
