package com.example.mutant_detector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que maneja las solicitudes HTTP relacionadas con la detección de mutantes.
 */
@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    /**
     * Verifica si una secuencia de ADN es mutante.
     *
     * @param dnaRequest la solicitud que contiene la secuencia de ADN.
     * @return un código de estado 200 si es mutante, 403 si no lo es.
     */
    @PostMapping("/")
    public ResponseEntity<Void> isMutant(@RequestBody DnaRequest dnaRequest) {
        boolean isMutant = mutantService.isMutant(dnaRequest.getDna());
        return isMutant ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    /**
     * Obtiene las estadísticas de mutantes y no mutantes.
     *
     * @return un objeto StatsResponse con las estadísticas.
     */
    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> getStats() {
        StatsResponse stats = mutantService.getStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}