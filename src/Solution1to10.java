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

    /**
     * 2.两数相加  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        boolean flag = false;
        ListNode tmp = new ListNode(-1);
        ListNode ret = tmp;
        while(l1 != null && l2 != null){
            int val = flag ? l1.val + l2.val + 1: l1.val + l2.val;
            flag = false;
            if(val >= 10){
                val -= 10;
                flag = true;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            if(flag){
                l1.val ++;
                if(l1.val >= 10){
                    l1.val -= 10;
                    flag = true;
                }else{
                    flag = false;
                }
            }
            tmp.next = l1;
            l1 = l1.next;
            tmp = tmp.next;
        }
        while(l2 != null){
            if(flag){
                l2.val ++;
                if(l2.val >= 10){
                    l2.val -= 10;
                    flag = true;
                }else{
                    flag = false;
                }
            }
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }
        if(flag){
            tmp.next = new ListNode(1);
        }
        return ret.next;
    }
}
