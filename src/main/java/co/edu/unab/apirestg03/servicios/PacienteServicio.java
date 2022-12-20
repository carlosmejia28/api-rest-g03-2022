package co.edu.unab.apirestg03.servicios;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.PacienteModelo;
import co.edu.unab.apirestg03.repositorios.PacienteRepositorio;

@Service
public class PacienteServicio {
    @Autowired
    PacienteRepositorio pacienteRepositorio;

    public String guardarPaciente(PacienteModelo paciente) {
        paciente.setNombre(paciente.getNombre().toLowerCase());
        paciente.setApellido(paciente.getApellido().toLowerCase());
        boolean estado=paciente.getId() == null || !pacienteRepositorio.existsById(paciente.getId());
        pacienteRepositorio.save(paciente);
        if (estado) {
            return "Se Guardo El Paciente";
        } else {
            return "Se Actualizo el Paciente";
        }
    }

    public List<PacienteModelo> getListPacientesOrden() {
        List<PacienteModelo> listaPacientes = pacienteRepositorio.findAll();
        listaPacientes.sort(Comparator.comparing(PacienteModelo::getNombre));
        return listaPacientes;
    }

    public Optional<PacienteModelo> getPacienteById(String id) {
        return pacienteRepositorio.findById(id);
    }

    public List<PacienteModelo> getPacientesByApellido(String apellido){
        return pacienteRepositorio.findByApellido(apellido);
    }

    public List<PacienteModelo> pacientesByCiudad(String ciudad){
        return pacienteRepositorio.buscarPorCiudad(ciudad);
    }

    public List<PacienteModelo>pacientePorFechaMenor(LocalDate fecha){
        return pacienteRepositorio.buscarPacientesMenoresDeFecha(fecha);
    }

    public boolean existPacienteByID(long ndocumento){
        return pacienteRepositorio.existsByNdocumento(ndocumento);
    }

    public  Optional<PacienteModelo> pacientePorNdocumento(long ndocumento){
        return pacienteRepositorio.findByNdocumento(ndocumento);
    }

}
