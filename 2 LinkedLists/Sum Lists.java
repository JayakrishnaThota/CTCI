//O(n) time and space
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0, sum=0;
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        while(l1!=null || l2!=null || carry!=0){
            int a = (l1==null)?0:l1.val;
            int b = (l2==null)?0:l2.val;
            sum = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            iter.next = new ListNode(sum);
            l1 = (l1==null)?l1:l1.next;
            l2 = (l2==null)?l2:l2.next;
            iter = iter.next;
        }
        return dummy.next;
    }
}
