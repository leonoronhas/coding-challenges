package LearnByDoing;

import java.util.Arrays;

/***********************************************************************************
 *   Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *   Efficiency:
 *   Brute force solution -> O(n^2)
 *   Optimal solution -> O(n)
 ***********************************************************************************/
public class AverageOfAllContiguousSubarrays {

    /******************************************************************************
     * Brute force solution
     * ***************************************************************************/
    static class AverageOfSubarrayOfSizeK {
        public static double[] findAverages(int K, int[] arr) {
            // Array of size arr.length(9) - K(5) + 1 = 5;
            double[] result = new double[arr.length - K + 1];

            // Get the first K elements
            for (int i = 0; i <= arr.length - K; i++) {
                // Reset sum for each subarray count
                double sum = 0;
                // Get the next K elements
                for (int j = i; j < i + K; j++) {
                    sum += arr[j];
                    // Get the average for each subarray
                    result[i] = sum / K;
                }
            }

            return result;
        }
    }

    /******************************************************************************
     * Optimal solution
     * ***************************************************************************/
    static class AverageOfSubarrayOfSizeKOptimal {
        public static double[] findAverages(int K, int[] arr) {
            // Array of size arr.length(9) - K(5) + 1 = 5;
            double[] result = new double[arr.length - K + 1];

            double windowSum = 0;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                // add the next element
                windowSum += arr[windowEnd];
                // slide the window, we don't need to slide if we've not hit the required window size of 'k'
                if (windowEnd >= K - 1) {
                    // calculate the average
                    result[windowStart] = windowSum / K;
                    // subtract the element going out
                    windowSum -= arr[windowStart];
                    // slide the window ahead
                    windowStart++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        // Brute force solution
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Brute Solution: Averages of subarrays of size K: " + Arrays.toString(result));

        // Optimal solution
        double[] optimalResult = AverageOfSubarrayOfSizeKOptimal.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Optimal Solution: Averages of subarrays of size K: " + Arrays.toString(optimalResult));

    }
}
