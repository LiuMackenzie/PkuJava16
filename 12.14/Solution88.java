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
    	        int count = 0;//��¼�м�����nums2��������nums1��С���������Խ�����һ��ȫ������nums1
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
        	//�Ӻ���ǰ�Ƚϣ����1��Ԫ�ش���2���Ͱ�1��Ԫ���Ƶ�m+n-1��λ��
    		if(nums1[len1] > nums2[len2]){
    			nums1[merge--]=nums1[len1--];
    		}else{//���򣬾��ƶ�2��Ԫ�ص�1��m+n-1��λ��
    			nums1[merge--]=nums2[len2--];
    		}
    	}
    	//���1��Ԫ��ȫ�����꣬��2��û�б�������Ԫ���1�С�
    	while(len2>=0){
    		nums1[merge--]=nums2[len2--];
    	}
    }
}
