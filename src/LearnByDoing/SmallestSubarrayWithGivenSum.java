package LearnByDoing;

/***********************************************************************************
 *   Given an array of positive numbers and a positive number ‘S’, find the length
 *   of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 *   Return 0, if no such subarray exists.
 *   Sliding Window pattern
 *   Efficiency:
 *   Optimal solution -> O(n)
 ***********************************************************************************/
public class SmallestSubarrayWithGivenSum {

    static class SmallestSubarrayWithSum {
        static int findSmallest(int s, int[] arr) {
            int windowSum = 0;
            int minLength = Integer.MAX_VALUE; // To infinity and beyond
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                // add the next element
                windowSum += arr[windowEnd];
                // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
                while (windowSum >= s) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    // subtract the element going out
                    windowSum -= arr[windowStart];
                    // slide the window ahead
                    windowStart++;
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }

    public static void main(String[] args) {
        int S = 7;
        int[] arr = {2, 1, 5, 2, 3, 2};
        // Optimal solution
        int optimalResult = SmallestSubarrayWithSum.findSmallest(S, arr);
        System.out.println("Optimal Solution: \nS = " + S + "\nSmallest subarray length: " + optimalResult);
    }
}
