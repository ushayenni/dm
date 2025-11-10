import java.util.*;

public class AprioriSimple {
    public static void main(String[] args) {
        // Step 1: Input - Transactions
        List<Set<String>> transactions = Arrays.asList(
            Set.of("milk", "bread"),
            Set.of("milk", "diaper", "beer", "bread"),
            Set.of("milk", "diaper", "beer", "cola"),
            Set.of("diaper", "beer", "bread"),
            Set.of("milk", "diaper", "bread", "beer")
        );

        double minSupport = 0.6; // Minimum support threshold
        List<Set<String>> frequentItemsets = new ArrayList<>();

        // Step 2: Collect all unique items
        Set<String> allItems = new HashSet<>();
        for (Set<String> t : transactions)
            allItems.addAll(t);

        // Step 3: Create initial candidate itemsets (C1)
        List<Set<String>> candidates = new ArrayList<>();
        for (String item : allItems)
            candidates.add(Set.of(item));

        // Step 4: Repeat until no new candidates
        while (!candidates.isEmpty()) {
            List<Set<String>> frequent = new ArrayList<>();

            // Step 5: Count support for each candidate
            for (Set<String> candidate : candidates) {
                int count = 0;
                for (Set<String> t : transactions)
                    if (t.containsAll(candidate)) count++;

                double support = (double) count / transactions.size();

                // Step 6: Check if frequent
                if (support >= minSupport) {
                    frequent.add(candidate);
                    frequentItemsets.add(candidate);
                }
            }

            // Step 7: Generate new candidates (join step)
            List<Set<String>> nextCandidates = new ArrayList<>();
            for (int i = 0; i < frequent.size(); i++) {
                for (int j = i + 1; j < frequent.size(); j++) {
                    Set<String> union = new HashSet<>(frequent.get(i));
                    union.addAll(frequent.get(j));
                    if (union.size() == frequent.get(i).size() + 1)
                        if (!nextCandidates.contains(union))
                            nextCandidates.add(union);
                }
            }
            candidates = nextCandidates;
        }

        // Step 8: Print all frequent itemsets
        System.out.println("Frequent Itemsets:");
        for (Set<String> s : frequentItemsets)
            System.out.println(s);
    }
}
