package co.edu.unab.apirestg03.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestg03.modelos.PacienteModelo;
@Repository
public interface PacienteRepositorio extends MongoRepository<PacienteModelo, String> {
    
    List<PacienteModelo> findByApellido(String apellido); //keywords for query methods
    
    Boolean existsByNdocumento(long id);

    Optional<PacienteModelo> findByNdocumento(long ndocumento);

    @Query("{'direccion.ciudad':?0}")
    List<PacienteModelo> buscarPorCiudad(String ciudad);

    @Query("{fnacimiento:{$lt:?0}}")
    List<PacienteModelo>buscarPacientesMenoresDeFecha(LocalDate fecha);

    //List<PacienteModelo>findByFnacimientoBefore(LocalDate date);//keywords for query methods


}
