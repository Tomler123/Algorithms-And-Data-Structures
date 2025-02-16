/**
11. Maximum Subarray Sum using Divide and Conquer

Given an integer array, find the maximum sum among all subarrays possible.

Example:

Input:  nums[] = [2, -4, 1, 9, -6, 7, -3]

Output: The maximum sum of the subarray is 11 (Marked in Green)


The idea is to use Divide and Conquer technique to find the maximum subarray sum. The algorithm works as follows:

1. Divide the array into two equal subarrays.
2. Recursively calculate the maximum subarray sum for the left subarray,
3. Recursively calculate the maximum subarray sum for the right subarray,
4. Find the maximum subarray sum that crosses the middle element.
5. Return the maximum of the above three sums.


The time complexity of the below divide-and-conquer solution is O(n.log(n)) as
for the given array of size n, we make two recursive calls on input size n/2
and finding the maximum subarray crosses midpoint takes O(n) time in the worst case.

*/
public class MaximumSum {
    public static int findMaximumSum(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        
        int mid = (left + right)/2;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = mid; i >= left; i--){
            sum += nums[i];
            if(sum > leftMax){
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        
        for(int i = mid + 1; i <= right; i++){
            sum += nums[i];
            if(sum > rightMax){
                rightMax = sum;
            }
        }

        int maxLeftRight = Integer.max(findMaximumSum(nums, left, mid), findMaximumSum(nums, mid + 1, right));

        return Integer.max(maxLeftRight, leftMax + rightMax);

        /**
         {2, -4, 1, 9, -6, 7, -3} -> {11}
         
         {2, -4, 1, 9} {-6, 7, -3} -> {10, 1} -> {11}
         
         {2, -4} {1, 9} {-6, 7} {-3} -> {-2, 10, 1, -3} -> {10, 1}
                                        
         {2} {-4} {1} {9} {-6} {7} {-3} 
        */
    }
    
    public static int findMaximumSum(int[] nums)
    {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
 
        return findMaximumSum(nums, 0, nums.length - 1);
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, -4, 1, 9, -6, 7, -3 };
 
        System.out.println("The maximum sum of the subarray is " +
                findMaximumSum(nums));
    }
}
