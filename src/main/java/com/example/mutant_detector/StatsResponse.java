package com.example.mutant_detector;

import lombok.*;

/**
 * DTO para la respuesta de estadísticas.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
public class StatsResponse {
    private long countMutantDna; // Número de ADN mutantes
    private long countHumanDna;  // Número de ADN humanos
    private double ratio;        // Proporción de mutantes a humanos
}