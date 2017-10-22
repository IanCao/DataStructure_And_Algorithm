package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args){
        int[] nums = {};
    }
    public static int[] twoSum(int[] nums,int target){
        int[] res = new int[2];
        if(nums == null || nums.length <2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return null;
     }
}
