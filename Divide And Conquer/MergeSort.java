import java.util.Arrays;

/**
22. Merge Sort Algorithm Implementation

Given an integer array, sort it using the merge sort algorithm.

Merge Sort Overview

Merge sort is an efficient sorting algorithm that produces a
stable sort, which means that if two elements have the same
value, they hold the same relative position in the sorted
sequence as they did in the input. In other words, the relative
order of elements with equal values is preserved in the sorted
sequence. Merge sort is a comparison sort, which means that it
can sort any input for which a less-than relation is defined.

Merge Sort is a Divide And Conquer algorithm. So like other
Divide And Conquer algorithms, merge sort also divides a large
array into smaller arrays and sorts the subarrays recursively.
So merge sort includes two steps:
    1. Divide entire array of size n to size 1 subarrays each
    2. Repeteadly merge subarrays to form new sorted subarrays
       until only 1 subarray is left (size of n and sorted)

Below you can see the code of the Merge Sort algorithm,
which consists of two parts:
    1. Merge
    2. Merge Sort

The worst-case time complexity of merge sort is O(n.log(n)),
where n is the size of the input.

*/

public class MergeSort {
    public static void merge(int[] arr, int[] aux, int low, int mid, int high){
        int k = low, i = low, j = mid + 1;

        while (i <= mid && j <= high){
            // add smaller element to the aux array and increase both indices
            if(arr[i] <= arr[j])
                aux[k++] = arr[i++];
            else
                aux[k++] = arr[j++];
        }

        // add the remanining elements of the array if any are left
        while(i <= mid)
            aux[k++] = arr[i++];

        // copy the aux array into the original array
        for(i = low; i <= high; i++)
            arr[i] = aux[i];

    }

    public static void mergeSort(int[] arr, int[] aux, int low, int high){
        if(high <= low) return;

        int mid = (low + ((high - low) >> 1));

        // here we are recursively dividing large array into
        // subarrays of size 1
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);

        // finally merge the divided subarrays
        merge(arr, aux, low, mid, high);
    }

    public static boolean isSorted(int[] arr){
        int i = 1;
        int max = arr.length-1;
        
        while(i < max){
            if(arr[i] < arr[i-1])
                return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = { 12, 3, 18, 24, 0, 5, -2 };
        int[] aux = Arrays.copyOf(arr, arr.length);

        // sort array `arr` using auxiliary array `aux`
        mergeSort(arr, aux, 0, arr.length - 1);
 
        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
