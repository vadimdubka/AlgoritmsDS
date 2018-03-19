package wf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Task from java sert. WF*/
public class Rare {
    public static int nthMostRare(int[] elements, int n) {
        Map<Integer, Integer> map = new HashMap<>(elements.length);
        for (Integer key : elements) {
            boolean isContain = map.containsKey(key);
            if (!isContain) {
                map.put(key, 1);
            } else {
                int count = map.get(key);
                map.put(key, ++count);
            }
        }
    
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int value = list.get(n-1);
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int x = nthMostRare(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5}, 2);
        System.out.println(x);
    }
}