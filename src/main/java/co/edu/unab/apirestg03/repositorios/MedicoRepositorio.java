package co.edu.unab.apirestg03.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestg03.modelos.MedicoModelo;

@Repository
public interface MedicoRepositorio extends MongoRepository <MedicoModelo, String>{
    
}
