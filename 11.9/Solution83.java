package solution;

public class Solution83 {
	 public class ListNode {
	     int val;
	     ListNode next;
         ListNode(int x) { val = x; }
	 }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ln = head;
        //���û�нڵ��ֻ��һ���ڵ㣬ֱ�ӷ���
        if(ln==null){
        	return ln;
        }
        ListNode next=ln.next;
        if(next==null){
        	return ln;
        }
        //�����������һ���ڵ㣬����һ���ڵ��ln��ֵ��ͬ�����������������ͬ����ln��ָ��next��next����
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
        //�������ڵ㣬��ln��next��ͬ��������ln������������ͬ��ln����һ�ڵ�ָ��next
        if(ln.val==next.val){
        	ln.next=null;
        }else{
        	ln.next = next;
        }
        return head;
    }
}
