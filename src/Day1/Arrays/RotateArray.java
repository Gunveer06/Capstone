package Day1.Arrays;

import java.util.Arrays;

public class RotateArray {
    public static int[] Rotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        return arr;
    }
    public static void reverse(int[] arr , int start , int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,7,8,9,12,15};
        int k =3;
        System.out.println(Arrays.toString(Rotate(nums,k)));
    }
}
