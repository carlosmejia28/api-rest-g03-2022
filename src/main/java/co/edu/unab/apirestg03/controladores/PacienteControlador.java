package co.edu.unab.apirestg03.controladores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestg03.modelos.PacienteModelo;
import co.edu.unab.apirestg03.servicios.PacienteServicio;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*" , methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class PacienteControlador {
    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping()
    public List<PacienteModelo> getAllPacientesOrden(){
        return pacienteServicio.getListPacientesOrden();
    }

    @GetMapping("/{id}")
    public Optional<PacienteModelo> findPacienteByID(@PathVariable("id") String id){
        return pacienteServicio.getPacienteById(id);
    }
    @GetMapping("/existe/query")
    public Boolean existePacienteById(@RequestParam("ndocumento") long ndocumento){
        return pacienteServicio.existPacienteByID(ndocumento);
    }

    @GetMapping("/query") // ejemplo: http://localhost:8080/pacientes/query?apellido=mejia
    public List<PacienteModelo> getPacientesByApellido(@RequestParam("apellido") String apellido){
        return pacienteServicio.getPacientesByApellido(apellido); 
    }

    @GetMapping("/fecha/query")
    public List<PacienteModelo> getPacienteByFechaMenor(@RequestParam("fecha") String fecha){
        LocalDate localDate = LocalDate.parse(fecha);
        return pacienteServicio.pacientePorFechaMenor(localDate);
    }
    @GetMapping("/ciudad/{ciudad}")
    public List<PacienteModelo> listPacientesCiudad(@PathVariable("ciudad") String ciudad){
        return pacienteServicio.pacientesByCiudad(ciudad);
    }

    @GetMapping("/ndocumento/{ndocumento}")
    public  Optional<PacienteModelo> findPacienteByNdocumento(@PathVariable("ndocumento") long ndocumento){
        return pacienteServicio.pacientePorNdocumento(ndocumento);
    }

    @PostMapping()
    public String savePaciente(@RequestBody PacienteModelo paciente){
        return pacienteServicio.guardarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id) {
        return pacienteServicio.deletePacientebyId(id);
    }

}
