/**
1. Binary Search Algorithm – Iterative and Recursive Implementation

Given a sorted array of n integers and a target value, determine if the target exists in the array 
in logarithmic time using the binary search algorithm. If target exists in the array, print the index of it.

input: 
nums[] = [2, 3, 5, 7, 9]
target = 7
Output: Element found at index 3 
Input: 
nums[] = [1, 4, 5, 8, 9]
target = 2 
Output: Element not found
*/

/**

The time complexity of the binary search algorithm is O(log2n),
which is very efficient. The auxiliary space required by the program is O(1)
for iterative implementation and O(log2n) for recursive implementation due to call stack.

*/
public class Binary{
    // Iterative Implementation
    public static int binarySearchIterative(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(target == nums[mid])
            {
                return mid;
            }
            else if(target < nums[mid])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return -1;
    }

    // Recursive Implementation
    public static int binarySearchRecursive(int[] nums, int low, int high, int target){
        if (low > high)
        {
            return -1;
        }

        int mid = (low + high)/2;

        if(target == nums[mid])
        {
            return mid;
        }
        else if(target < nums[mid])
        {
            return binarySearchRecursive(nums, low, mid-1, target);
        }
        else
        {
            return binarySearchRecursive(nums, mid+1, high, target);
        }
    }

    public static void main(String[] args){
        int[] nums = { 2, 5, 6, 8, 9, 10 };
        int target = 5;
 
        // int index = binarySearchIterative(nums, target);
        int index = binarySearchRecursive(nums, 0, nums.length, target);
        
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}