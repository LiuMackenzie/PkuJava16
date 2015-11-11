package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	//����һ��ʹ�õݹ�ķ�����ÿ�α�������ͷa��β��b���м��ƶ����м���cһ�α���ͷβ�м�����֣�
    	//�������͵���0�򷵻أ������Ϊ��͵ݹ���������������ͷ��β���ı�����м��ƶ�һ��λ�ã���ȡ���������Ϊ
    	//�ݹ���õĴ���ֵ����leetcode�ϲ��ԣ���������ֱȽ��ٵĻ����������гɹ��������ֶ�Ļ��ͻᳬʱ��
    	Arrays.sort(nums);
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	int a,b,c;
    	int len = nums.length;
    	if (len<=2){
    		return ll;
    	}
    	a = 0;
    	c = len-1;
        if(nums[a]+nums[c]>=0){
        	b=a+1;
        	if(nums[a]>0 && nums[c]>0){
        		return null;
        	}
        	if(nums[a]+nums[c]>Math.abs(nums[a])){
        		return null;
        	}
        	while(b<len-1 && nums[b]<=0){
            	List<Integer> ls = new ArrayList<Integer>();
        		if(nums[a]+nums[b]+nums[c]==0){
        			ls.add(nums[a]);
        			ls.add(nums[b]);
        			ls.add(nums[c]);
        			if(!ll.contains(ls)){
        				ll.add(ls);
        			}else{
        				ls.clear();
        			}
        			List<List<Integer>> temp1 = threeSum(Arrays.copyOfRange(nums, a+1, c+1));
        			if(temp1!=null){
        				for(Iterator<List<Integer>> i = temp1.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			List<List<Integer>> temp2 = threeSum(Arrays.copyOfRange(nums, a, c));
        			if(temp2!=null){
        				for(Iterator<List<Integer>> i = temp2.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			return ll;
        		}
        		b++;
        	}
        	if (b<len-1 && nums[b]>0){
        		return null;
        	}
        }
        if(nums[a]+nums[c]<0){
        	b=c-1;
        	if(nums[a]<0 && nums[c]<0){
        		return null;
        	}
        	if(Math.abs(nums[a]+nums[c])>Math.abs(nums[c])){
        		return null;
        	}
        	while(b<len-1 && nums[b]>0){
            	List<Integer> ls = new ArrayList<Integer>();
        		if(nums[a]+nums[b]+nums[c]==0){
        			ls.add(nums[a]);
        			ls.add(nums[b]);
        			ls.add(nums[c]);
        			if(!ll.contains(ls)){
        				ll.add(ls);
        			}else{
        				ls.clear();
        			}
        			//������ݹ����a�����λ֮������飬�����뱾�ε��õĽ������
        			List<List<Integer>> temp1 = threeSum(Arrays.copyOfRange(nums, a+1, c+1));
        			if(temp1!=null){
        				for(Iterator<List<Integer>> i = temp1.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			//������ݹ����c��ǰ��λ֮������飬�����뱾�ε��õĽ������
        			List<List<Integer>> temp2 = threeSum(Arrays.copyOfRange(nums, a, c));
        			if(temp2!=null){
        				for(Iterator<List<Integer>> i = temp2.listIterator();i.hasNext();){
        					List<Integer> tm=i.next();
        					if(!ll.contains(tm)){
        						ll.add((List<Integer>) tm);
        					}
        				}
        			}
        			return ll;
        		}
        		b++;
        	}
        	if (b<len-1 && nums[b]<0){
        		return null;
        	}
        }
		return null;
    	//����2���������ʹ�õıȽ������뵽������������������ѭ��Ƕ�ף����α�������ӡ����������������Լ�������ʱ��
		//���統�����������ڵ�����ʱ��ֱ������ѭ������δ������ύ��ʱ����ʾ��ʱ������ʱ��������run code�в���ʱ����
		//���г���������Һ���վ�ϸ��������н��һ�¡����������ͼ��
    	Arrays.sort(nums);
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	if (nums.length<=2){
    		return ll;
    	}
    	int mid=1;
    	int end = nums.length-1;
    	for(;end>0 && nums[end]>=0;end--){
    		int front = 0;
    		for(;nums[front]<=0 && front<nums.length-2 ;front++){
    			for(mid=front+1;mid<end;mid++){
    				if((nums[front]>=0 && nums[mid]>0 && nums[end]>0)||(nums[front]<0 && nums[mid]<0 && nums[end]<=0)){
    					break;
    				}
    				if(nums[front]+nums[mid]+nums[end]==0){
    					List<Integer> li = new ArrayList<Integer>();
    					li.add(nums[front]);
    					li.add(nums[mid]);
    					li.add(nums[end]);
    					if(!ll.contains(li)){
    						ll.add(li);
    					}
    					break;
    				}
    			}
    		}
    	}
    	return ll;*/
    }
}








