@Service
public class MutantService {

    @Autowired
    private DnaRepository dnaRepository;

    public boolean isMutant(String[] dna) {
        String sequence = String.join(",", dna);
        Optional<Dna> existingDna = dnaRepository.findById(sequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = countMutantSequences(dna) > 1;
        dnaRepository.save(new Dna(sequence, isMutant));
        return isMutant;
    }

    public StatsResponse getStats() {
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        double ratio = countHumanDna > 0 ? (double) countMutantDna / countHumanDna : 0;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }

    private int countMutantSequences(String[] dna) {
        int n = dna.length;
        int count = 0;

        // Check rows
        for (String row : dna) {
            count += countSequences(row);
            if (count > 1) return count;
        }

        // Check columns
        for (int col = 0; col < n; col++) {
            StringBuilder columnSequence = new StringBuilder();
            for (String row : dna) {
                columnSequence.append(row.charAt(col));
            }
            count += countSequences(columnSequence.toString());
            if (count > 1) return count;
        }

        // Check diagonals
        count += checkDiagonals(dna, n);
        
        return count;
    }

    private int checkDiagonals(String[] dna, int n) {
        int count = 0;

        // Primary diagonals
        for (int i = 0; i <= n - 4; i++) {
            StringBuilder diag1 = new StringBuilder();
            StringBuilder diag2 = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                if (i + j < n && j < n) {
                    diag1.append(dna[j].charAt(i + j));
                    diag2.append(dna[i + j].charAt(j));
                }
            }
            count += countSequences(diag1.toString());
            count += countSequences(diag2.toString());
            if (count > 1) return count;
        }

        return count;
    }

    private int countSequences(String sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length() - 3; i++) {
            if (sequence.charAt(i) == sequence.charAt(i + 1) &&
                sequence.charAt(i) == sequence.charAt(i + 2) &&
                sequence.charAt(i) == sequence.charAt(i + 3)) {
                count++;
                if (count > 1) return count;
            }
        }
        return count;
    }
}
