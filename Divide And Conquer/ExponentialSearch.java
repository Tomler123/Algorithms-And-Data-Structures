/**
20. Exponential search

Given a sorted array of n integers and a target value,
determine if the target exists in the array or not in logarithmic time.
If the target exists in the array, return the index of it.

Input: A[] = [2, 3, 5, 7, 9]
target = 7
Output: Element found at index 3

Input: A[] = [1, 4, 5, 8, 9]
target = 2
Output: Element not found

You can find a solution with Binary Search in Binary.java for such problem
This time, let's solve it with Exponential Search.

The exponential search takes O(log(i)) time, where i is the target’s
position in the array when the target is in the array or position
where the target should be if it isn’t in the array.

*/

public class ExponentialSearch {
    private static int binarySearch(int[] A, int left, int right, int x){
        if(left > right) return -1;

        int mid = (left + right) / 2;

        if(x == A[mid]) return mid;

        else if(x < A[mid]) return binarySearch(A, left, mid - 1, x);
        
        else return binarySearch(A, mid + 1, right, x);

    }
    public static int exponentialSearch(int[] A, int x){
        if(A == null || A.length == 0){
            return -1;
        }

        int bound = 1;

        while(bound < A.length && A[bound] < x)
            bound *= 2;

        return binarySearch(A, bound/2, Integer.min(bound, A.length - 1), x);
    }
    // Exponential search algorithm
    public static void main(String[] args)
    {
        int[] A = {2, 5, 6, 8, 9, 10};
        int key = 9;
 
        int index = exponentialSearch(A, key);
 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}
