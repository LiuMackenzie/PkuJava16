package solution;

public class Solution83 {
	 public class ListNode {
	     int val;
	     ListNode next;
         ListNode(int x) { val = x; }
	 }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ln = head;
        //如果没有节点或只有一个节点，直接返回
        if(ln==null){
        	return ln;
        }
        ListNode next=ln.next;
        if(next==null){
        	return ln;
        }
        //否则，则遍历下一个节点，若下一个节点和ln数值相同，则继续遍历；若不同，则将ln的指向next，next后移
        while(next.next!=null){
        	/*while(next.val==ln.val){
        		if( next.next!=null){
        			next = next.next;
        		}
        	}
        	if(next.next==null){
        		if(next.val==ln.val){
            		ln.next=null;
            		break;
        		}
        		break;
        	}
        	ln.next=next;
        	ln = next;
        	next = ln.next;*/
        	if(ln.val!=next.val){
        		ln.next = next;
        		ln=next;
        		next=ln.next;
        	}else{
        		next = next.next;
        	}
        }
        //处理最后节点，若ln和next相同，则链表到ln处结束；若不同则将ln的下一节点指向next
        if(ln.val==next.val){
        	ln.next=null;
        }else{
        	ln.next = next;
        }
        return head;
    }
}
