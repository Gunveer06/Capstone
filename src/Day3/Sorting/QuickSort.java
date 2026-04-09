package Day3.Sorting;

public class QuickSort {
    static int partition(int[] arr, int low , int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = 0; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    static void sort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr,low,high);

            sort(arr,low,pi - 1);
            sort(arr , pi +1 , high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {78,45,90,32,67,88};
        sort(nums,0, nums.length);
    }
}
