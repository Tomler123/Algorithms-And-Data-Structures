import java.util.Arrays;

/**
26. Quick Sort

Another Divide and Conquer algorithm. Like all this type of algorithms,
Quick Sort also divides large array into small subarrays and sorts them.
It involves three steps:
    1. Selecting Pivot: Pick random element from the array called Pivot
    (usually it is left most, right most or mid element, but it does not matter)
    2. Partition: Reorder the array such that all items with less value than pivot
    come before the pivot, and all the greate ones come after the pivot. In the end,
    pivot will be in its final position.
    3. Recur:Recursively apply above techniques to the subarray elements less than pivot
    and separately to the elements greater than pivot.

Base case of the recursion is subarray with size 1 (already sorted).
The worst-case time complexity of Quicksort is O(n2), where n is the size of the input.

The best-case time complexity of Quicksort is O(n.log(n)).
The best case happens when the pivot divides the array into two nearly equal pieces.
Now each recursive call processes a list of half the size.

So performance is depended on the Pivot element.
*/

public class QuickSort {
    // simple swap operation
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        int pIndex = start;

        for(int i = start; i < end; i++){
            if(arr[i] <= pivot){
                swap(arr, i, pIndex);
                pIndex++;
            }
        }

        swap(arr, end, pIndex);

        return pIndex;
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static void main(String[] args)
    {
        int[] arr = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
 
        quickSort(arr, 0, arr.length - 1);
 
        System.out.println(Arrays.toString(arr));
    }
}
