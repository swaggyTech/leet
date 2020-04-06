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
    }
}
