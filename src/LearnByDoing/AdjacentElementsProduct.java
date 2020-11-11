package LearnByDoing;

import java.util.Arrays;

public class AdjacentElementsProduct {

    public static int findSum(int[] inputArray) {
        int max = inputArray[0] * inputArray[1];
        for (int i = 1; i < inputArray.length - 1; i++) {
            if (inputArray[i] * inputArray[i + 1] > max)
                max = inputArray[i] * inputArray[i + 1];
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {3, 6, -2, -5, 7, 3};

        // Optimal solution
        int optimalResult = findSum(arr);
        System.out.println("Array: "+ Arrays.toString(arr) + "\nSum of pair of adjacent elements that has the largest product : " + optimalResult);

    }
}
