/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        		 //考虑太简单了，以为是一个环，没考虑内部含有环
//		 if(head==null)
//	            return false;
//	        
//	        ListNode node=new ListNode(head.val);
//	        node=head;
//	        while(node.next!=null){
//	            if(node.next==head)
//	                return true;
//	            node=node.next;
//	        }
//	        return false;

    //类似跑圈：一个快的和一个慢的总会相遇
    //设置俩指针，一个快 一个慢，快的一次走两步，慢的一次走一步，他们总会相遇，比如快的在i,慢的在i-1,则上一步一定是快的在i-2,慢的在i-2。
    //如果快的在i+2,慢的在i，则上一步快的在i,慢的在i-1 跟上面情况一样啦。
    if(head==null||head.next==null)
        return false;
    ListNode faster=head,slower=head;//定义两个快慢的指针
    
    while(faster.next!=null&&faster.next.next!=null){//一定要是&&，应为如果slow.next=null,faster.next.next=null则返回true了

        faster=faster.next.next;
        slower=slower.next;
        if(faster==slower)
            return true;
   }
   return false;
    }
}
       