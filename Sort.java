import java.util.*;

class Sort{
    public int[] sortByBits(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        
        // Convert int[] to Integer[]
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        // Sort using custom comparator
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;   // sort by number value
            }
            
            return countA - countB;  // sort by bit count
        });
        
        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    }

    // PSVM (Main Method)
    public static void main(String[] args) {
        Sort sor = new Sort();
        
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        
        int[] result = sor.sortByBits(arr);
        
        System.out.println("Sorted array by number of 1 bits:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}