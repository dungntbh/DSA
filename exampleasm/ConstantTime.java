package exampleasm;

public class ConstantTime {
    public static void printFirstElement(int[] arr) {
        System.out.println(arr[0]);  // Accessing a fixed element in the array, independent of its size
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printFirstElement(arr);  // Outputs: 1
    }
}
// Time complexity is O(1) because we are accessing a specific element in the array.
