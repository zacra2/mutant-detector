
INSERT INTO Dna (sequence, isMutant)
SELECT 'ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG', true
WHERE NOT EXISTS (
    SELECT 1 FROM Dna WHERE sequence = 'ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG'
);
