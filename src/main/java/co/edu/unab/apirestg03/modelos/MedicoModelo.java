package co.edu.unab.apirestg03.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicoModelo {
    @Id
    private String id;
    private long ndocumento;
    private String nombre;
    private String apellido;
    private String especialidad;    
}
