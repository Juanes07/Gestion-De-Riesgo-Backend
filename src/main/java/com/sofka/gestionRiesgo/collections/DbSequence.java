package com.sofka.gestionRiesgo.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @coleccion secuencia id
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {
    @Id
    private String  id;
    private int seq;

}
