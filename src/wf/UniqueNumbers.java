package wf;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 1, 3, 2, 3);
        Collection<Integer> uniqueColl = getUnique(collection);
        for (Integer integer : uniqueColl) {
            System.out.println(integer);
        }
        
    }
    
    private static Collection<Integer> getUnique(Collection<Integer> collection) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : collection) {
            set.add(integer);
        }
        return set;
    }
}
