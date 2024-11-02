package com.example.mutant_detector;

import lombok.Data;

/**
 * DTO para la solicitud de detección de mutantes.
 */
@Data
public class DnaRequest {
    private String[] dna; // Secuencia de ADN a verificar
}