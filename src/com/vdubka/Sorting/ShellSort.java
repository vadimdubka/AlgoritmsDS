package com.vdubka.Sorting;

import com.vdubka.IO;

public class ShellSort {

//    private static StringBuilder stringBuilder = new StringBuilder();

    private static int[] arr;
    private static int k;
    private static int arrayLength;
    private static int lastIndex;

    private final static String YES = "YES";
    private final static String NO = "NO";

    public static void main(String[] args) {
        try (IO.Scanner in = IO.newScanner(); IO.Printer out = IO.newPrinter()) {

            arrayLength = in.nextInt();
            lastIndex = arrayLength - 1;
            k = in.nextInt();

            if (arrayLength == 1 || k == 1) {
                out.print(YES);
                return;
            }

            arr = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                arr[i] = in.nextInt();
            }
//            System.out.println(Arrays.toString(arr));

            if (arrayLength >= 100000) {
                shellSort(arr, k*10);
            }
            shellSort(arr, k);
//            System.out.println(Arrays.toString(arr));


            out.print(isSorted(arr));

//            for (int i = k - 1; i <= k2 - 1; i++) {
//                stringBuilder.append(arr[i]).append(" ");
//            }
//            out.print(stringBuilder);
        }
    }

    private static void shellSort(int[] arr, int step) {
        int currentInd;
        int currBackInd;
        for (int i = 0; i < step; i++) { // Запускаем сортировку step раз
            currentInd = i;
            for (int j = i + step; j < arrayLength; j += step) { // идем по массиву с шагом step
                if (arr[currentInd] > arr[j]) {
                    exchange(currentInd, j);
                    currBackInd = currentInd;
                    for (int k = currentInd - step; k >= 0; k -= step) { // идем по массиву с шагом step
                        if (arr[currBackInd] < arr[k]) {
                            exchange(currBackInd, k);
                            currBackInd = k;
                        } else {
                            break;
                        }

                    }
                }
                currentInd = j;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    private static void exchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String isSorted(int arr[]) {
        int current = arr[0];
        int next;
        for (int i = 1; i <= lastIndex; i++) {
            next = arr[i];
            if (current <= next) {
                current = next;
            } else return NO;
        }
        return YES;
    }
}
