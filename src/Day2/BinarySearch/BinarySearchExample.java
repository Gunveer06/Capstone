package Day2.BinarySearch;

public class BinarySearchExample {
    public static int search(int[] arr , int target){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14};
        int target = 10;
        System.out.println(search(arr,target));
    }
}
