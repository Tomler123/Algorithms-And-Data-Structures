/**
Find the number of rotations in a circularly sorted array

Given a circularly sorted integer array, find the total number
of times the array is rotated. Assume there are no duplicates in
the array, and the rotation is in the anti-clockwise direction.

Example:

Input:  nums = [8, 9, 10, 2, 5, 6]
Output: The array is rotated 3 times

Input:  nums = [2, 5, 6, 8, 9, 10]
Output: The array is rotated 0 times


We can easily solve this problem in O(log(n)) time by modifying the binary search algorithm.

*/
public class RotationCount {
    public static int findRotationCount(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            if(nums[left] <= nums[right]){
                return left;
            }

            int mid = (left + right)/2;
    
            // % nums.length is needed to stay in array length bounds
            int next = (mid + 1) % nums.length;
            int prev = (mid - 1 + nums.length) % nums.length;
    
            // if the element is less than its next and previous elements,
            // it is the smallest element in the circular array
            if(nums[mid] < nums[next] && nums[mid] < nums[prev]){
                return mid;
            }
            else if(nums[mid] <= nums[right]){
                right = mid - 1;
            }
            else if(nums[mid] >= nums[left]){
                left = mid + 1;
            }
        }

        // invalid input
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {8,9,10,1,2,3,4,5,6,7};

        System.out.println("Array is rotated " + findRotationCount(nums) + " times");
    }
}
