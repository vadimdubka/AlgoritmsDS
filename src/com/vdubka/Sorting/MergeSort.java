package com.vdubka.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        // Проверяем сортировку и слияние массивов.
//        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 77, 78, 900, 2100, 2200, 2300, 2400, 2500, 2600};
//        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 900, 1100, 1200, 3000, 5000};
//        int[] a3 = new int[]{5, 10, 7, 1, 12, 8, 3, 7};
//        System.out.println(Arrays.toString(merge(a1, a2)));
//        System.out.println(Arrays.toString(mergeSort(a3)));
        
        // Проверяем сортировку и слияние массивов не создавая дополнительные массивы при делении исходного массива на части.
        int[] a3 = new int[]{1, 8, 2, 1, 4, 7, 3, 2, 3, 6};
        System.out.println(Arrays.toString(mergeSort(a3, 0, a3.length - 1)));
        
        // Проверяем слияние списков.
//        Integer[] a1 = new Integer[]{21, 23, 24, 40, 75, 76, 77, 78, 900, 2100, 2200, 2300, 2400, 2500, 2600};
//        Integer[] a2 = new Integer[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 900, 1100, 1200, 3000, 5000};
//        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(a1)); // создание списка на основании массива
//        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(a2)); // создание списка на основании массива
//        System.out.println(list1);
//        System.out.println(list2);
//        merge(list1, list2);
//        System.out.println(list1);
    }

    /*
     * 2 вида оптимизации:
     * Код создает новый массив при каждом слиянии. Как можно обойтись одним дополнитленым массивом на всю программу.
     * Как можно обойтись без рекурсии. Вместо того, чтобы разбивать массивы,
     * можно пойти снизу вверх и объединять сразу кусочки размера 1, потом кусочки размера 2 и т.д.
     * Так будет немного быстрее, т.к. рекурсия может немного тормозить.
     */
    
    /**
     * Сортировка массива слиянием
     */
    static int[] mergeSort(int[] a) {
        if (a.length <= 1) { // если длина массива равна единице, он отсортирован и возвращаем исходный массив
            return a;
        } else { // иначе если в массиве 2 и больше элементов, делим массив на 2 половины.
            int middle = a.length / 2;
            int[] a1 = Arrays.copyOfRange(a, 0, middle); // делим массив на 2 половины
            int[] a2 = Arrays.copyOfRange(a, middle, a.length);
            a1 = mergeSort(a1); // сортируем каждую из половин рекурсивно сортировкой
            a2 = mergeSort(a2);
            
            return merge(a1, a2); // сливаем 2 отсортированных массива. Метод merge объединит и два массива длины 1;
        }
    }
    
    /**
     * Слияние двух отсортирванных массивов в новый отсортированный массив
     */
    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length]; // создаем новый массив, равный количеству элементов в исходных массивах
        int indexA = 0, indexB = 0, indexC = 0;
        
        while (indexA < a.length && indexB < b.length) { // пока не перенесутся все элементы из какого-либо массива
            c[indexC++] = (a[indexA] < b[indexB]) ? a[indexA++]
                                                  : b[indexB++]; // сравниваем первые элементы массивов и вставляем в новый массив меньший из элементов. Не забываем увеличивать индексы массивов, которые участвовали в операции
        }
        
        // когда один из массивов исчерпается, вставляем оставшуюся часть массива
        if (indexA < a.length) { // если элементы остались в 1 массиве, то исчерпался 2 массив
            System.arraycopy(a, indexA, c, indexC, a.length - indexA);
        } else { // иначе наоборот
            System.arraycopy(b, indexB, c, indexC, b.length - indexB);
        }
        
        return c;
    }
    
    /*****************************************************************************************************/
    
    /**
     * Сортировка массива слиянием не создавая дополнительные массивы при делении исходного массива
     * на части. Такая реализация позволяет подсчитать число инверсий в массиве.
     */
    static int[] mergeSort(int[] a, int left, int right) {
        if (left == right) {
            return a;
        } else {
            int middle = (right + left) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            
            return merge(a, left, middle, right);
        }
    }
    
    /**
     * Слияние двух отсортированных частей одного и того же массива
     */
    private static int[] merge(int[] a, int left, int middle, int right) {
        int[] c = new int[right - left + 1]; // создаем новый массив, равный количеству элементов в исходных массивах
        int indexA = left, indexB = middle + 1, indexC = 0;
        while (indexA <= middle && indexB <= right) { // пока не перенесутся все элементы из какой-либо части
            c[indexC++] = (a[indexA] < a[indexB])
                          ? a[indexA++]
                          : a[indexB++]; // сравниваем первые элементы массивов и вставляем в новый массив меньший из элементов. Не забываем увеличивать индексы массивов, которые участвовали в операции
        }
        
        if (indexA <= middle) {
            System.arraycopy(a, indexA, c, indexC, middle - indexA + 1);
        } else {
            System.arraycopy(a, indexB, c, indexC, right - indexB + 1);
        }
        
        // вставляем новый массив отсартированный массив в наш исходный массив с учетом диапазона
        for (int i = 0; i < c.length; i++) {
            a[left++] = c[i];
        }
        return a;
    }
    
    /*****************************************************************************************************/
    
    
    /**
     Expert Soft задача Merge function
     
     4 варианта задачи:
     - отсортировать массив сортировкой слияния. Сортировка слиянием подразумевает
     разбиение массива поровну до тех пор пока из одного массива не получится
     несколько мелких — размером не более одного элемента.
     - слить два отсортированных массива в третий.
     - отсортировать ArrayList сортировкой слияния.
     - слить два отсортированных ArrayList в первый
     
     
     ****************************************
     Вам нужно написать реализацию функции
     void merge(ArrayList a, ArrayList b) { // тело функции }
     
     Функция принимает два отсортированных от меньшего к большему ArrayList одинакового размера [a1, a2, ..., an], [b1, b2, ..., bn]. В результате выполнения функции в первом(!) ArrayList (в данном случае это А) должны содержаться элементы обоих ArrayList, также отсортированные от меньшего к большему. Второй ArrayList должен остаться неизменненным.
     Пример:
     Входные данные
     A [1,3,5]
     B [2,6,8]
     Результат
     A [1,2,3,5,6,8]
     B [2,6,8]
     
     Оцениваться будут следующие параметры:
     •	- код должен работать корректно
     •	- выполнять полезную функцию
     •	- иметь максимально возможную эффективность (задумайтесь, пожалуйста, над тем насколько эффективно написанная вами функция будет использовать память и процессорное время)
     
     FAQ
     •	- Написать нужно именно тело функции
     •	- Времени отводится 60 минут
     ****************************************
     */
    
    /**
     * Слияние двух отсортирванных ArrayList в 1 ArrayList, второй оставляем неизменным
     */
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> mergedArray = new ArrayList<>(a.size() + b.size());
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.size() && indexB < b.size()) {
            mergedArray.add(a.get(indexA) < b.get(indexB)
                            ? a.get(indexA++)
                            : b.get(indexB++));
        }
        
        ArrayList<Integer> lastPart;
        int lastInd;
        if (indexA < a.size()) {
            lastPart = a;
            lastInd = indexA;
        } else {
            lastPart = b;
            lastInd = indexB;
        }
        
        for (int i = lastInd; i < lastPart.size(); i++) {
            mergedArray.add(lastPart.get(i));
        }
        
        a.clear();
        a.addAll(mergedArray);
    }
}

