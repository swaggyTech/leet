import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/6 15:25
 */
public class Solution1to10 {

    /**
     * 1.两数之和，给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */
    public static int[] twoSum(int[] nums,int target){
        int[] ret = new int[2];
        if(nums.length <= 1) {
            return ret;
        }
        //ceil向上取整 floor向下取整 round四舍五入
        Map<Integer,Integer> map = new HashMap<>((int)Math.ceil(nums.length * 4 / 3.0));
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }else{
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
        }
        return ret;
    }
}
