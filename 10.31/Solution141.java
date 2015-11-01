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
        //若没有头结点，返回无环
        if(head==null){
        	return isCycle; 
        }
        ListNode first=head;
        ListNode second;
        //设第二个Node是第一个Node的下一个
        if(first.next!=null){
            second=head.next;
        }else{
        	return isCycle;
        }
        if(first.next==first){
        	return true;
        }
        //每次遍历second比first多走一格，若最终两个Node重合即为有环
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
