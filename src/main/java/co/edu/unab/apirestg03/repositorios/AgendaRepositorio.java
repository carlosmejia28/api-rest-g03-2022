package co.edu.unab.apirestg03.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestg03.modelos.AgendaModelo;

@Repository
public interface AgendaRepositorio extends MongoRepository<AgendaModelo, String>{
    
}
