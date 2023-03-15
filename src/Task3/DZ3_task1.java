package Task3;
//Реализовать алгоритм сортировки слиянием

import java.util.Random;

public class DZ3_task1 {
        public static void main(String args[]) {
                int[] sortArr = getRandomNums(8);
                printArr(sortArr);
                mergeSort(sortArr, 0, sortArr.length - 1);
                printArr(sortArr);
        }
        public static int[] getRandomNums(int size) {
                int[] nums = new int[size];
                for(int i = 0; i < size; i++) {
                     nums[i] = new Random().nextInt(0,10);
                }
                return nums;
        }
        public static void printArr(int[] arr) {
                for(int i = 0; i < arr.length; i++) {
                       System.out.print(arr[i]+" ");
                }
                System.out.println();
        }
        public static void merge(int[]arr, int left, int mid, int right){
                int aSize = mid - left + 1;
                int bSize = right - mid;
                int[] a = new int[aSize];
                int[] b = new int[bSize];
                for(int i = 0; i < aSize; i++) {
                        a[i] = arr[left + i];
                }
                for(int i = 0; i < bSize; i++) {
                        b[i] = arr[mid + 1 + i];
                }
                int aIndex = 0;
                int bIndex = 0;
                int resIndex = left;
                while (aIndex < aSize && bIndex < bSize) {
                        if(a[aIndex] >= b[bIndex]) {
                                arr[resIndex] = b[bIndex];
                                bIndex++;
                        }
                        else {
                                arr[resIndex] = a[aIndex];
                                aIndex++;
                        }
                        resIndex++;
                        }
                while (aIndex < aSize) {
                        arr[resIndex] = a[aIndex];
                        aIndex++;
                        resIndex++;
                }
                while (bIndex < bSize) {
                        arr[resIndex] = b[bIndex];
                        bIndex++;
                        resIndex++;
                }

        }
        public static void mergeSort(int[] arr, int begin, int end ) {
                if(begin >= end){
                        return;
                }
                int mid = begin + (end - begin) / 2;
                mergeSort(arr, begin, mid);
                mergeSort(arr, mid + 1, end);
                merge(arr, begin, mid, end);
        }

}