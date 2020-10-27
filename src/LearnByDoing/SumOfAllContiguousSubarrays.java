package LearnByDoing;

import java.util.Arrays;

/***********************************************************************************
 *   Given an array of positive numbers and a positive number ‘k’, find the maximum
 *   sum of any contiguous subarray of size ‘k’.
 *   Efficiency:
 *   Brute force solution -> O(n^2)
 *   Optimal solution -> O(n)
 ***********************************************************************************/
public class SumOfAllContiguousSubarrays {
    /******************************************************************************
     * Brute force solution
     * ***************************************************************************/
    static class SumOfAllSubarrayOfSizeK {
        public static int findSum(int K, int[] arr) {
            int result = 0;

            // Get the first K elements
            for (int i = 0; i <= arr.length - K; i++) {
                // Reset sum for each subarray count
                int sum = 0;
                // Get the next K elements
                for (int j = i; j < i + K; j++) {
                    sum += arr[j];
                    // Get the Max sum for each subarray
                    result = Math.max(result, sum);
                }
            }

            return result;
        }
    }

    /******************************************************************************
     * Optimal solution
     * ***************************************************************************/
    static class SumOfSubarrayOfSizeKOptimal {
        public static int findSum(int K, int[] arr) {
            int maxSum = 0;
            int windowSum = 0;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                // add the next element
                windowSum += arr[windowEnd];
                // slide the window, we don't need to slide if we've not hit the required window size of 'k'
                if (windowEnd >= K - 1) {
                    // Get the Max sum for each subarray
                    maxSum = Math.max(maxSum, windowSum);
                    // subtract the element going out
                    windowSum -= arr[windowStart];
                    // slide the window ahead
                    windowStart++;
                }
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        int K = 2;
        int[] arr = {2, 1, 5, 1, 3, 2};
        // Brute force solution
        int result = SumOfAllSubarrayOfSizeK.findSum(K, arr);
        System.out.println("Brute Solution: \nK = " + K + "\nSum of subarrays of size K: " + result);

        // Optimal solution
        int optimalResult = SumOfSubarrayOfSizeKOptimal.findSum(K, arr);
        System.out.println("Optimal Solution: \nK = " + K + "\nSum of subarrays of size K: " + optimalResult);

    }
}
