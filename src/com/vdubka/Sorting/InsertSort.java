package com.vdubka.Sorting;

import java.util.Arrays;


/* input
10
1 8 4 2 3 7 5 6 9 0*/
public class InsertSort {
    public static void main(String[] args) {
        try (com.vdubka.IO.Scanner in = com.vdubka.IO.newScanner(); com.vdubka.IO.Printer out = com.vdubka.IO.newPrinter()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            
            System.out.println(Arrays.toString(arr)); // печать исходного массива
            
            for (int i = 1; i < size; i++) {
                int key = arr[i];
                int k = i - 1;
                while (k >= 0 && arr[k] > key) {
                    arr[k + 1] = arr[k--];
                }
                arr[k + 1] = key;
            }
            
            System.out.println(Arrays.toString(arr)); // print sorted array
            
        }
    }
}
