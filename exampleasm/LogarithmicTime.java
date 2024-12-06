package ASM3;

// public class ConstantTime {
//     public static void main(String[] args) {
//         int[] array = {1, 2, 3, 4, 5};
//         // Accessing the first element - constant time operation
//         System.out.println(array[0]);
//     }
// }


// public class LinearTime {
//     public static void main(String[] args) {
//         int[] array = {1, 2, 3, 4, 5};
//         // Iterating through the array - linear time operation
//         for (int num : array) {
//             System.out.println(num);
//         }
//     }
// }


import java.util.Arrays;

public class LogarithmicTime {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        
        // Binary search to find the target
        int index = binarySearch(sortedArray, target);
        System.out.println("Index of " + target + ": " + index);
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
