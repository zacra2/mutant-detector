-- Crear tabla Dna si no existe
CREATE TABLE IF NOT EXISTS Dna (
    sequence VARCHAR(255) PRIMARY KEY,
    isMutant BOOLEAN
);

-- Insertar secuencias de ejemplo
INSERT INTO Dna (sequence, isMutant) VALUES ('ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG', true);
INSERT INTO Dna (sequence, isMutant) VALUES ('ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG', false);
