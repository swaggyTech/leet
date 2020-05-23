import java.util.Arrays;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/6 15:22
 */
public class Main {
    public static void main(String[] args) {

        //1.twoSum
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(Solution1to10.twoSum(nums, target)));

        //2.addTwoNumbers
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ret = Solution1to10.addTwoNumbers(l1,l2);
        while(ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }

        //3.lengthOfLongestSubstring
        String s = "au";
        System.out.println("第三题"+Solution1to10.lengthOfLongestSubstring(s));

        //4.findMedianSortedArray
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println("第四题"+Solution1to10.findMedianSortedArray(nums1,nums2));

        //5.longestPalindrome
        String s4 = "babad";
        System.out.println("第五题"+Solution1to10.longestPalindrome(s4));

        //6.convert
        String s6 = "akapualakapaulakapaul";
        System.out.println("第六题"+Solution1to10.convert(s6,3));

        //7.reverse
        int x7 = 321;
        System.out.println("第七题" + Solution1to10.reverse(x7));

        //8.atoi
        /**String str1 = "42";
        String str2 = "    -42";
        String str3 = "4193 with words";
        String str4 = "words and 987";
        String str5 = "-91283472332";
        System.out.println("str1 " + Solution1to10.myAtoi(str1));
        System.out.println("str2 " + Solution1to10.myAtoi(str2));
        System.out.println("str3 " + Solution1to10.myAtoi(str3));
        System.out.println("str4 " + Solution1to10.myAtoi(str4));
        System.out.println("str5 " + Solution1to10.myAtoi(str5));*/
        String str5 = "2147483646";
        System.out.println("str5 " + Solution1to10.myAtoi(str5));

        //9.回文数
        int x = 121;
        System.out.println("第9题 " + Solution1to10.isPalindrome(x));

        //11.盛水最多的容器
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("第11题" + Solution11to20.maxArea(height));
        System.out.println("第11题" + Solution11to20.maxArea1(height));

        //12.数字转罗马数字[贪心算法]
        int num = 3;
        System.out.println("第12题" + Solution11to20.intToRoman(num));

        //13.罗马数字转整数
        String s13 = "MCMXCIV";
        System.out.println("第13题" + Solution11to20.romanToInt(s13));

        //14.最长公共前缀
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("第14题" + Solution11to20.longestCommonPrefix(strs));

        //15.三数之和
        int[] nums15 = {-1, 0, 1, 2, -1, -4};
        System.out.println("第15题" + Solution11to20.threeSum(nums15));

        //16.最接近的三数之和
        int[] nums16 = {1, 1, 1, 0};
        int target16 = -100;
        System.out.println("第16题" + Solution11to20.threeSumClosest(nums16, target16));

        //17。电话号码的字母组合
        String digits = "23";
        System.out.println("第17题" + Solution11to20.letterCombination(digits));

    }
}
