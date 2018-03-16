package wf;

import java.util.HashMap;
import java.util.Map;

/*https://www.testdome.com/d/java-interview-questions/4 #4*/
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        if (list == null || list.length < 2) {
            return null;
        }
        int                   size            = list.length;
        Map<Integer, Integer> toFindValuesMap = new HashMap<>();
        for (int i = 0; i < size - 1; i++) {
            int iEl = list[i];
            if (toFindValuesMap.containsKey(iEl)) {
                return new int[]{i, toFindValuesMap.get(iEl)};
            }
            int diff = sum - iEl;
            toFindValuesMap.put(diff, i);
        }
        return null;
    }
    
    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[]{1, 3, 1, 3, 5, 7, 9}, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}