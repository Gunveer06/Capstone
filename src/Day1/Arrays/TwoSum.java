package Day1.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] TwoSum(int[] arr , int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans  = {-1,-1};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                ans[1] = i;
                ans[0] = map.get(diff);
            }
            else{
                map.put(arr[i] , i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(TwoSum(nums,target)));
    }
}
