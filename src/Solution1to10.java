import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 3.无重复字符最长子串 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s){
        if("".equals(s)){
            return 0;
        }
        if(s.trim().length() == 0) {
            return 1;
        }
        if(s.length() == 1){
            return 1;
        }
        int ret = 0;
        for(int i = 0;i < s.length() - 1;i++){
            Set<Character> set = new HashSet<>();
            char start = s.charAt(i);
            set.add(start);
            int tmp = 1;
            for(int j = i + 1;j < s.length();j++){
                char end = s.charAt(j);
                if(set.contains(end)){
                    ret = Math.max(ret,tmp);
                    break;
                }else{
                    set.add(end);
                    tmp++;
                    ret = Math.max(ret,tmp);
                }
            }
        }
        return ret;
    }
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map = new HashMap<>((int)Math.ceil(s.length() * 5 / 4.0));
        int ans = 0;
        for(int i = 0,j = 0;j < s.length(); j ++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j - i + 1);
            map.put(s.charAt(j),j + 1);
        }
        return ans;
    }

    /**
     * 4. 寻找两个有序数组的中位数 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArray(int[] nums1,int[] nums2){
        int len1 = nums1.length,len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int l1 = 0,l2 = 0;
        int l = 0;

        while(l1 < nums1.length && l2 < nums2.length){
            if(nums1[l1] < nums2[l2]){
                nums[l++] = nums1[l1++];
            }else{
                nums[l++] = nums2[l2++];
            }
        }
        if(l1 == nums1.length){
            while(l < nums.length){
                nums[l++] = nums2[l2++];
            }
        }
        if(l2 == nums2.length){
            while(l < nums.length){
                nums[l++] = nums1[l1++];
            }
        }
        if(nums.length % 2 == 0){
            return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        }else{
            return (double)nums[nums.length / 2] / 1.0;
        }

    }


}
