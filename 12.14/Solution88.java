package solution;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	/*int len1 = m;
        int len2 = n;
        int array1 = 0;
        int array2 = 0;
        while(array2<len2){
        	if(nums1[array1]<nums2[array2]){
        		array1++;
        	}else{
    	        int count = 0;//记录有几个在nums2中连续比nums1中小的数，可以将他们一次全部加入nums1
        		while(nums1[array1]>nums2[array2]){
        			count++;
        			array2++;
        		}
        		int i = len1-1;
        		while(i>=array1){
        			nums1[i+count]=nums1[i];
        			i--;
        		}
        		len1=len1+count;
        		
        		int j = count;
        		array1=array1+count;
        		while(j>0){
        			nums1[array1-j]=nums2[array2-j];
        			j--;
        		}
        	}
        }*/
    	int len1 = m-1;
    	int len2 = n-1;
    	int merge = m+n-1;
    	while(len1 >= 0 && len2 >= 0){
        	//从后向前比较，如果1中元素大于2，就把1中元素移到m+n-1的位置
    		if(nums1[len1] > nums2[len2]){
    			nums1[merge--]=nums1[len1--];
    		}else{//否则，就移动2的元素到1的m+n-1的位置
    			nums1[merge--]=nums2[len2--];
    		}
    	}
    	//如果1中元素全部移完，把2中没有遍历到的元素填到1中。
    	while(len2>=0){
    		nums1[merge--]=nums2[len2--];
    	}
    }
}
