package solution;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
 
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        boolean isCycle = false;
        //��û��ͷ��㣬�����޻�
        if(head==null){
        	return isCycle; 
        }
        ListNode first=head;
        ListNode second;
        //��ڶ���Node�ǵ�һ��Node����һ��
        if(first.next!=null){
            second=head.next;
        }else{
        	return isCycle;
        }
        if(first.next==first){
        	return true;
        }
        //ÿ�α���second��first����һ������������Node�غϼ�Ϊ�л�
        while(first!=second){
        	first=first.next;
        	if(second.next!=null && second.next.next!=null){
        		second = second.next.next;
        	}else{
        		return isCycle;
        	}
        }
        if(first==second){
        	isCycle=true;
            return isCycle;
        }
        return isCycle;
    }
}
