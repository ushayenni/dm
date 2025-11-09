import java.util.HashSet; 
import java.util.Random; 
import java.util.Set; 
 
// Class to represent a single data instance 
class DataInstance { 
    private int id; 
    private String name; 
 
    public DataInstance(int id, String name) { 
        this.id = id; 
        this.name = name; 
    } 
 
    public int getId() { 
        return id; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    @Override 
    public String toString() { 
        return "DataInstance [id=" + id + ", name=" + name + "]"; 
    } 
 
    @Override 
    public boolean equals(Object obj) { 
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        DataInstance other = (DataInstance) obj; 
        return id == other.id; 
    } 
 
    @Override 
    public int hashCode() { 
        return Integer.hashCode(id); 
    } 
} 
 
// Main class to generate and display unique data set 
public class UniqueDataSetGenerator { 
    public static void main(String[] args) { 
        int dataSize = 10; // number of data instances to generate 
 
        Set<DataInstance> uniqueDataSet = generateUniqueData(dataSize); 
 
        System.out.println("Generated Unique Data Set:"); 
        for (DataInstance instance : uniqueDataSet) { 
            System.out.println(instance); 
        } 
    } 
 
 
 
    // Method to generate a set of unique DataInstance objects 
    public static Set<DataInstance> generateUniqueData(int size) { 
        Set<DataInstance> dataSet = new HashSet<>(); 
        Random random = new Random(); 
 
        String[] possibleNames = { 
            "Alice", "Bob", "Charlie", "David", "Eve",  
            "Frank", "Grace", "Heidi" 
        }; 
 
        for (int i = 0; i < size; i++) { 
            int id = i + 1; // unique ID 
            String name = possibleNames[random.nextInt(possibleNames.length)]; 
            DataInstance newInstance = new DataInstance(id, name); 
            dataSet.add(newInstance); 
        } 
 
        return dataSet; 
    } 
} 
