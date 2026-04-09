package Day3.Sorting;

import java.util.Arrays;

public class MergeSort {
    static void sort(int[] arr, int l, int h){
        if(l<h){
            int m = l + (h-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,h);
            merge(arr,l,m,h);
        }
    }

    private static void merge(int[] arr, int l, int m, int h) {
        int n1 = m-l+1;
        int n2 = h-m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i = 0, j = 0, k = l;
        while(i<n1)left[i++] = arr[l++];
        while(j<n2)right[j++] = arr[l++];

        i = 0;
        j = 0;

        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i<n1){
            arr[k++] = left[i++];
        }

        while(j<n2){
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {78,45,90,32,67,88};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}