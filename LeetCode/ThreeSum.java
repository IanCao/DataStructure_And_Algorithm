package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String args[]){
        int[] num = new int[]{-1, 0, 1, 2,-1, -4};
        List<List<Integer>> lists = threeSum(num);
        System.out.println();
    }

    private static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <=2){
            return res;
        }

        Arrays.sort(nums);

        for(int i = nums.length - 1;i>=2;i--){
            if(i< nums.length - 1 && nums[i] == nums[i +1])
                continue;

            List<List<Integer>> curRes = twoSum(nums,i-1,-nums[i]);

            for(int j = 0;j<curRes.size();j++){
                curRes.get(j).add(nums[i]);
            }
            res.addAll(curRes);
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] num,int end,int target){
        List<List<Integer>> res = new ArrayList<>();

        if(num == null || num.length <=1){
            return res;
        }

        int l = 0;
        int r = end;

        while(l < r){
            if(num[l] + num[r] == target){
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(num[l]);
                arrayList.add(num[r]);
                res.add(arrayList);
                l++;
                r--;

                while(l < r && num[l] == num[l+1]){
                    l++;
                }

                while (l < r && num[r] == num[r-1]){
                    r--;
                }
            }else if(num[l] + num[r] > target){
                r--;
            }else {
                l++;
            }
        }

        return res;
    }
}
