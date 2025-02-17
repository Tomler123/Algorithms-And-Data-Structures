import java.util.Arrays;

/**
23. Iterative Merge Sort Algorithm (Bottom-up Merge Sort)

We have already discussed how the Merge Sort works in the MergeSort.java file

Now we can see how Iterative Merge Sort Algorithm works

We start by sorting all subarrays of 1 element; then merge results
into subarrays of 2 elements, then merge results into subarrays of 4 elements.
Likewise, perform successive merges until the array is completely sorted.

The worst-case time complexity of iterative merge sort remains the same
as the recursive implementation, i.e., O(n.log(n)) for an input containing n items.
However, it saves the auxiliary space required by the call stack.

Below you can see the code.
*/
public class IterativeMergeSort {
    public static void merge(int[] arr, int[] aux, int low, int mid, int high){
        int k = low, i = low, j = mid + 1;

        while(i <= mid && j <= high){
            // if(arr[i] < arr[j])
            //     aux[k++] = arr[i++];
            // else
            //     aux[k++] = arr[j++];
            aux[k++] = arr[i] < arr[j] ? aux[i++] : aux[j++];
        }

        while(i < arr.length && i <= mid)
            aux[k++] = arr[i++];

        for(i = low; i <= high; i++)
            arr[i] = aux[i];
    }

    public static void mergeSort(int[] arr){
        int low = 0, high = arr.length - 1;

        int[] aux = Arrays.copyOf(arr, arr.length);

        for(int m = 1; m <= high - low; m*=2){
            for(int i = low; i < high; i+=2){
                int from = i;
                int mid = i + m - 1;
                int to = Integer.min(i + 2*m - 1, high);

                merge(arr, aux, from, mid, to);
            }
        }
    }
    public static void main(String[] args)
    {
        int[] A = { 5, 7, -9, 3, -4, 2, 8 };
 
        System.out.println("Original array: " + Arrays.toString(A));
        mergeSort(A);
        System.out.println("Modified array: " + Arrays.toString(A));
    }
}
