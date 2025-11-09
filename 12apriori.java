import java.util.*; 
public class Apriori { 
    private List<Set<String>> transactions; 
    private double minSupport; 
    public Apriori(List<Set<String>> transactions, double minSupport) { 
        this.transactions = transactions; 
        this.minSupport = minSupport; 
    } 
    public List<Set<String>> findFrequentItemsets() { 
        List<Set<String>> frequentItemsets = new ArrayList<>(); 
        Set<String> items = new HashSet<>(); 
        for (Set<String> transaction : transactions) { 
            items.addAll(transaction); 
        } 
        List<Set<String>> candidates = new ArrayList<>(); 
        for (String item : items) { 
            candidates.add(new HashSet<>(Collections.singletonList(item))); 
        } 
        while (!candidates.isEmpty()) { 
            List<Set<String>> frequent = new ArrayList<>(); 
            for (Set<String> candidate : candidates) { 
                int count = 0; 
                for (Set<String> transaction : transactions) { 
                    if (transaction.containsAll(candidate)) { 
                        count++; 
                    } 
                } 
                double support = (double) count / transactions.size(); 
                if (support >= minSupport) { 
                    frequent.add(candidate); 
                    frequentItemsets.add(candidate); 
                } 
            } 
            candidates = generateNextCandidates(frequent); 
        } 
        return frequentItemsets; 
    } 
    private List<Set<String>> generateNextCandidates(List<Set<String>> prevFrequent) { 
        List<Set<String>> nextCandidates = new ArrayList<>(); 
        int size = prevFrequent.size(); 
        for (int i = 0; i < size; i++) { 
            for (int j = i + 1; j < size; j++) { 
                Set<String> union = new HashSet<>(prevFrequent.get(i)); 
                union.addAll(prevFrequent.get(j)); 
                if (union.size() == prevFrequent.get(i).size() + 1) { 
                    nextCandidates.add(union); 
                } 
            } 
        } 
        return nextCandidates; 
    } 
    public static void main(String[] args) { 
        List<Set<String>> transactions = Arrays.asList( 
            Set.of("milk", "bread"), 
            Set.of("milk", "diaper", "beer", "bread"), 
            Set.of("milk", "diaper", "beer", "cola"), 
            Set.of("diaper", "beer", "bread"), 
            Set.of("milk", "diaper", "bread", "beer") 
        ); 
        Apriori apriori = new Apriori(transactions, 0.6); 
        List<Set<String>> result = apriori.findFrequentItemsets(); 
        System.out.println("Frequent Itemsets:"); 
        for (Set<String> itemset : result) { 
            System.out.println(itemset); 
        } 
}
}
