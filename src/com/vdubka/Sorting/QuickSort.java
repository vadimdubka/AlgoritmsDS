package com.vdubka.Sorting;// Created by sky-vd on 22.09.2017.

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a4 = new int[]{4, 10, 7, 1, 9, 3, 7};
        int[] a3 = new int[]{4, 10, 7, 1, 9, 7, 3, 18, 1, 8, 7, 5, 4, 2, 3, 11};
        int[] a2 = new int[]{1, 4, 5, 3, 2};
        int[] a5 = new int[]{1, 6, 7, 4, 6, 3, 6, 2, 6, 7, 6, 5, 6};
        System.out.println(Arrays.toString(a5));
        QuickSort quicksort = new QuickSort();
        quicksort.quickSort(a5);
        System.out.println(Arrays.toString(a5));
    }

    private int[] arr;

    private void quickSort(int[] arr) {
        // check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }

        this.arr = arr;

//        partition(0, arr.length - 1); // для стандартной сортировки
        partitionEquals(0, arr.length - 1); // для сортировки массива с повторяющимися элементами
    }

    private void partition(int start, int end) {
        int left = start;
        int right = end;

        // опорный элемент выбирается случайным образом
//        Random rnd = new Random(100); // Инициализируем генератор
//        int number = left + rnd.nextInt(right - left + 1); // Получаем случайное число в диапазоне от left до right (включительно)
        // опорный элемент выбирается средний элемент
        int number = (left + right) / 2;

        int pivotElem = arr[number]; // значение опорного элемента по случайному индексу

        System.out.print("BE ");
        print(arr, left, right, number, start, end);

        // Divide into two lists. Располагаем все элементы меньше опорного в левой части, больше опорного - в правой части. Идем с двух концов массива
        while (left <= right) {
            // If the current value from the left list is smaller than the pivot element then get the next element from the left list
            while (arr[left] < pivotElem) {
                ++left;
            }
            // If the current value from the right list is larger than the pivot element then get the next element from the right list
            while (arr[right] > pivotElem) {
                --right;
            }
            // If we have found a value in the left list which is larger than the pivot element and if we have found a value in the right list which is smaller than the pivot element then we exchange the values.
            if (left <= right) {
                exchange(left, right);
                // As we are done we can increase i and j
                ++left;
                --right;
            }

        }

        System.out.print("AF ");
        print(arr, left, right, left, start, end);
        System.out.println();

        // Recursion
        if (start < right) {
            partition(start, right);
        }
        if (left < end) {
            partition(left, end);
        }


    }

    private void exchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Method prints results of array partition. It is used for logging.
     */
    private void print(int[] arr, int left, int right, int partition, int start, int end) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < start; i++) {
            strB.append(arr[i] + " ");
        }
        strB.append("[");
        for (int i = start; i < partition; i++) {
            strB.append(arr[i] + " ");
        }

        strB.append("/" + arr[partition] + "\\ ");

        for (int i = partition + 1; i <= end; i++) {
            strB.append(arr[i] + " ");
        }
        strB.deleteCharAt(strB.length() - 1);
        strB.append("] ");

        for (int i = end + 1; i < arr.length; i++) {
            strB.append(arr[i] + " ");
        }
        System.out.print(strB.toString());
    }

    /**
     * Метод формирует массив из заданного числа элементов, при котором quickSort при выборе в качестве опорного элемента элемент по середине теряет свою эффективность и работает за время O(n^2).
     */
    static int[] antiQuickSort(int arraySize) {
        int[] arr = new int[arraySize];

        // для массивов меньше 3 элементов
        switch (arraySize) {
            case (1):
                return new int[]{1};
            case (2):
                return new int[]{1, 2};
        }

        arr[0] = 1;
        arr[1] = 2;

        System.out.println(Arrays.toString(arr));

        // Для каждого из плученных на предыдущем этапе массивов элемент по середине добавляем в конец массива, а на его место вставляем элемент, равный индексу последнего элемента увеличенного массива
        for (int i = 2; i < arraySize; i++) {
            int middle = i / 2;
            arr[i] = arr[middle];
            arr[middle] = i + 1;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * Метод оптимизирует работу алгоритми при наличии одинаковых элементов в массиве
     */
    private void partitionEquals(int start, int end) {
        int left = start;
        int right = end;

        int l = start;
        int r = end;

        // опорный элемент выбирается средний элемент
        int number = (left + right) / 2;

        int pivotElem = arr[number]; // значение опорного элемента по случайному индексу

        System.out.print("BE ");
        print(arr, left, right, number, start, end);

        while (left <= right) {
            // If the current value from the left list is smaller than the pivot element then get the next element from the left list
            while (arr[left] < pivotElem) {
                ++left;
            }
            // If the current value from the right list is larger than the pivot element then get the next element from the right list
            while (arr[right] > pivotElem) {
                --right;
            }
            // If we have found a value in the left list which is larger than the pivot element and if we have found a value in the right list which is smaller than the pivot element then we exchange the values.
            if (left <= right) {
                if (left == right) {
                    ++left;
                    --right;
                } else {
                    if (arr[left] != arr[right]) {
                        exchange(left, right);
                    }

                    if (arr[left] == pivotElem) {
                        exchange(left, l);
                        ++l;
                    }
                    if (arr[right] == pivotElem) {
                        exchange(right, r);
                        --r;
                    }

                    ++left;
                    --right;
                }

            }

        }

        int equalElementsLeft = l - start;
        int equalElementsRight = end - r;

        if (equalElementsLeft > 0) {
            System.arraycopy(arr, l, arr, start, right - l + 1);
        }
        if (equalElementsRight > 0) {
            System.arraycopy(arr, left, arr, left + equalElementsRight, r - left + 1);
        }

        left += equalElementsRight;
        right -= equalElementsLeft;

        for (int i = right + 1; i < left; i++) {
            arr[i] = pivotElem;
        }


        System.out.print("AF ");
        print(arr, left, right, left - 1, start, end);
        System.out.println();

        // Recursion
        if (start < right) {
            partitionEquals(start, right);
        }
        if (left < end) {
            partitionEquals(left, end);
        }


    }
}
