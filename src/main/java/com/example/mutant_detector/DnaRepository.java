package com.example.mutant_detector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Dna.
 */
@Repository
public interface DnaRepository extends JpaRepository<Dna, String> {
    /**
     * Cuenta el número de secuencias de ADN que son mutantes o no mutantes.
     *
     * @param isMutant true si se quieren contar mutantes, false si se quieren contar humanos.
     * @return el número de secuencias de ADN que cumplen con el criterio.
     */
    long countByIsMutant(boolean isMutant);
}