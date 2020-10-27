package LearnByDoing;

import java.util.Arrays;

/***********************************************************************************
 *   Given an array, find the sum of all contiguous subarrays of size ‘K’ in it
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
                    // Get the average for each subarray
                    result = sum;
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
                    // calculate the average
                    maxSum = windowSum;
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
        int K = 5;
        // Brute force solution
        int result = SumOfAllSubarrayOfSizeK.findSum(K, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Brute Solution: \nK = "+ K + "\nSum of subarrays of size K: " + result);

        // Optimal solution
        int optimalResult = SumOfSubarrayOfSizeKOptimal.findSum(K, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Optimal Solution: \nK = "+ K + "\nSum of subarrays of size K: " + optimalResult);

    }
}