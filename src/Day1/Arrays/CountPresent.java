package Day1.Arrays;

public class CountPresent {
    public static int Present(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1};
        System.out.println(Present(arr));
    }
}
