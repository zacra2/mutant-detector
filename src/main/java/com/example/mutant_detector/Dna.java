package com.example.mutant_detector;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Entidad que representa una secuencia de ADN en la base de datos.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
public class Dna {
    @Id
    private String sequence; // Secuencia de ADN
    private boolean isMutant; // Indica si es mutante o no
}