package Day3.Sorting;

import java.util.*;

public class SortColors {

    public static void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            } else {
                System.out.println("Invalid input detected. Array should contain only 0, 1, and 2.");
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};

        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
