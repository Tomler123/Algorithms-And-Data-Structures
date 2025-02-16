/**
15. Division of two numbers using binary search algorithm

This code will demonstrate the division of two numbers (integer or decimal)
using the binary search algorithm.

We can easily modify the binary search algorithm to perform the division of
two decimal numbers. We start by defining the range for our result as [0, INFINITY],
which is the initial low and high for the binary search algorithm.
Now we need to find a mid that satisfies x / y = mid or x = y × mid for given
two numbers, x and y, which will be our result.

Based on a comparison result between x and y × mid, either update low or high, or return mid if:

y × mid is almost equal to x, return mid.
y × mid is less than x, update low to mid.
y × mid is more than x, update high to mid.

We also need to take care of a few edge cases.

The time complexity of the below solution is O(log(n)), where n is equal to MAX_VAL.
*/

public class DivisionBinarySearch {
    public static double divide(double x, double y){
        if(y == 0){
            return Double.MAX_VALUE;
        }

        double left = 0.0, right = Double.MAX_VALUE;

        double precision = 0.001;

        // if x and y have different signs, our sign will be negative
        // otherwise positive
        int sign = x * y > 0 ? 1 : -1;

        while(true){
            double mid = left + ((right-left) / 2);

            // if y * mid is close to x, return mid
            if(Math.abs(y * mid - x) <= precision){
                return mid * sign;
            }
            if(y * mid < x)
            {
                left = mid;
            }
            else
            {
                right = mid;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(divide(22, 7));
    }
}
