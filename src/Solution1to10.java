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
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums.length <= 1) {
            return ret;
        }
        //ceil向上取整 floor向下取整 round四舍五入
        Map<Integer, Integer> map = new HashMap<>((int) Math.ceil(nums.length * 4 / 3.0));
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
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
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean flag = false;
        ListNode tmp = new ListNode(-1);
        ListNode ret = tmp;
        while (l1 != null && l2 != null) {
            int val = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            flag = false;
            if (val >= 10) {
                val -= 10;
                flag = true;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (flag) {
                l1.val++;
                if (l1.val >= 10) {
                    l1.val -= 10;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            tmp.next = l1;
            l1 = l1.next;
            tmp = tmp.next;
        }
        while (l2 != null) {
            if (flag) {
                l2.val++;
                if (l2.val >= 10) {
                    l2.val -= 10;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next = new ListNode(1);
        }
        return ret.next;
    }

    /**
     * 3.无重复字符最长子串 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.trim().length() == 0) {
            return 1;
        }
        if (s.length() == 1) {
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Set<Character> set = new HashSet<>();
            char start = s.charAt(i);
            set.add(start);
            int tmp = 1;
            for (int j = i + 1; j < s.length(); j++) {
                char end = s.charAt(j);
                if (set.contains(end)) {
                    ret = Math.max(ret, tmp);
                    break;
                } else {
                    set.add(end);
                    tmp++;
                    ret = Math.max(ret, tmp);
                }
            }
        }
        return ret;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>((int) Math.ceil(s.length() * 5 / 4.0));
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 4. 寻找两个有序数组的中位数 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int l1 = 0, l2 = 0;
        int l = 0;

        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] < nums2[l2]) {
                nums[l++] = nums1[l1++];
            } else {
                nums[l++] = nums2[l2++];
            }
        }
        if (l1 == nums1.length) {
            while (l < nums.length) {
                nums[l++] = nums2[l2++];
            }
        }
        if (l2 == nums2.length) {
            while (l < nums.length) {
                nums[l++] = nums1[l1++];
            }
        }
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            return (double) nums[nums.length / 2] / 1.0;
        }

    }

    /**
     * 5.最长回文子串，给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String ret = "";
        int max = -1;

        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 1; i <= j; i++) {
                if (s.charAt(j - 1) == s.charAt(i - 1) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 >= max) {
                        max = j - i + 1;
                        ret = s.substring(i - 1, j);
                    }
                }
            }
        }
        return ret;
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        //         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        //         定位中间部分的最后一个字符
        int ans = high;
        //         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    /**
     * 6.Z字形转换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public static String convert(String s, int rowNums) {
        if (rowNums == 1) {
            return s;
        }
        int[] rowIdx = new int[rowNums];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = rowNums * 2 - 2;
        int burketNum = chars.length / burketSize;
        int rem = chars.length % burketSize;
        for (int i = 1; i < rowNums; i++) {
            int flag = i == 1 ? 1 : 2;
            n = flag * burketNum + (rem >= i ? (1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
            rowIdx[i] = rowIdx[i - 1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            chars[rowIdx[curRow]] = c;
            rowIdx[curRow] = rowIdx[curRow] + 1;
            if (curRow == 0 || curRow == rowNums - 1) {
                flag = -flag;
            }
            curRow += flag;
        }
        return new String(chars);
    }

    /**
     * 7.整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static int reverse(int x){
        boolean flag = true;
        if(x < 0){
            flag = false;
        }
        if(!flag){
            x = -x;
        }
        int ret = 0;
        while(x > 0){
            if(ret > 2147483647 / 10){
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return flag ? ret : -ret;
    }

    /**
     * 8.字符串转换整数(atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     */
    public static int myAtoi(String str){
        String s = str.trim();
        int len = s.length();
        if(len == 0 || len == 1 && "-".equals(s)){
            return 0;
        }
        char[] c = s.toCharArray();
        if((c[0] < '0' || c[0] > '9') && c[0] != '-' && c[0] != '+'){
            return 0;
        }
        boolean flag = false;
        boolean out = false;
        int start = 0;
        if(c[0] == '-'){
            flag = true;
            start = 1;
        }
        if(c[0] == '+'){
            flag = false;
            start = 1;
        }
        int ret = 0;
        for(int i = start;i < len;i++){
            if(c[i] < '0' || c[i] > '9'){
                break;
            }
            int tmp = (int) (c[i] - '0');
            if(ret > ((Integer.MAX_VALUE - tmp) / 10)){
                //本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                //但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                out = true;
                break;
            }
            ret = ret * 10 + tmp;
        }
        if(out){
            if(flag){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }else{
            if(flag){
                return -ret;
            }else{
                return ret;
            }
        }
    }

    /**
     * 9.回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int tmp = x;
        int compare = 0;
        while(tmp > 0){
            compare = compare * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == compare;
    }
}
