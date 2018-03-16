package wf;

/*https://www.testdome.com/d/java-interview-questions/4 #6*/
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray == null) {
            return 0;
        }
        return binarySearch(sortedArray, 0, sortedArray.length - 1, lessThan);
    }
    
    public static int binarySearch(int[] sortedArray, int lInd, int rInd, int lessThan) {
        if (sortedArray[lInd] > lessThan) {
            return lInd;
        } else if (sortedArray[rInd] < lessThan) {
            return rInd + 1;
        }
        
        if (rInd - lInd < 3) {
            return processSmallArr(sortedArray, lInd, rInd, lessThan);
        }
        
        int mInd = (lInd + rInd) / 2;
        int mEl  = sortedArray[mInd];
        
        if (mEl > lessThan) {
            return binarySearch(sortedArray, lInd, mInd - 1, lessThan);
        } else {
            return binarySearch(sortedArray, mInd, rInd, lessThan);
        }
    }
    
    private static int processSmallArr(int[] sortedArray, int lInd, int rInd, int lessThan) {
        int count = 0;
        for (int i = lInd; i <= rInd; i++) {
            if (sortedArray[i] < lessThan) {
                count++;
            } else {
                break;
            }
        }
        return lInd + count;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 5, 7, 9, 15}, 7));
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}