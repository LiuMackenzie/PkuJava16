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
        		 //����̫���ˣ���Ϊ��һ������û�����ڲ����л�
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

    //������Ȧ��һ����ĺ�һ�������ܻ�����
    //������ָ�룬һ���� һ���������һ��������������һ����һ���������ܻ���������������i,������i-1,����һ��һ���ǿ����i-2,������i-2��
    //��������i+2,������i������һ�������i,������i-1 ���������һ������
    if(head==null||head.next==null)
        return false;
    ListNode faster=head,slower=head;//��������������ָ��
    
    while(faster.next!=null&&faster.next.next!=null){//һ��Ҫ��&&��ӦΪ���slow.next=null,faster.next.next=null�򷵻�true��

        faster=faster.next.next;
        slower=slower.next;
        if(faster==slower)
            return true;
   }
   return false;
    }
}
       