/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;

        

        ListNode curr =head;
        while(curr!=null){
            size++;
            curr =curr.next;
        }

        if(size==n){
            return head.next;
        }

        int node = size-n;
        ListNode prev =head;
        for(int i=0;i<node-1;i++){
            prev = prev.next;
        }
        System.out.println(prev.val);

        prev.next =prev.next.next;

    return head;
    }
}
