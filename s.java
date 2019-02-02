/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode sortedList = null;
        if(head == null || head.next == null){
            return head;
        }else{
            ListNode mid = findmid(head);
            ListNode firstHalf = sortList(head);
            ListNode secondHalf = sortList(mid);
            sortedList = merge(firstHalf, secondHalf);
        }
        return sortedList;
    }
    
    public ListNode findmid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode  prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
    
    public ListNode merge(ListNode firstHalf, ListNode secondHalf){
        ListNode firstCurr = firstHalf;
        ListNode secondCurr = secondHalf;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        
        
        while(firstCurr != null && secondCurr != null ){
            if(firstCurr.val < secondCurr.val){
                curr.next = firstCurr;
                curr = curr.next;
                firstCurr = firstCurr.next;
            }else{
                curr.next = secondCurr;
                curr = curr.next;
                secondCurr = secondCurr.next;
            }
        } 
        
        if( firstCurr != null){
            curr.next = firstCurr;
        }else{
            curr.next = secondCurr;
        }
        
        return newHead.next;
        
    }
}