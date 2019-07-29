package SortAlgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void shellsort(int[] array, int gap) {
        for(int i = array.length/gap; i > 0; i /= gap) {
            for(int j = i; j < array.length; j++) {
                int temp = array[j];
                int k;
                for(k = j-i; k >= 0 && array[k] < temp; k -= i) {
                    array[k+i] = array[k];
                }
                array[k+i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {2,5,6,2,9,1};
        System.out.println("Before: " + Arrays.toString(array));
        shellsort(array,2);
        System.out.println("After: " + Arrays.toString(array));
    }
}
