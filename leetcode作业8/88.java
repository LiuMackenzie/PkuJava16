public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //����һ��
        /*
        for(int i=m;i<m+n;i++)
        {

            nums1[i]=nums2[i-m];
        }

       Arrays.sort(nums1);
        */
        
        //��������
        //nums1 {1,2,3}
        //nums2 {3,4,5}
        //��nums1,nums2β����ʼ�Ƚ�,
        //���nums1[2]>nums1[2],��nums1[ĩβ]=nums1[2],ָ��������
        //����nums1[ĩβ]=nums2[2]��ָ��������
        
        int i=m-1;//nums1��β
        int j=n-1;//nums2��β
        int k=m+n-1; //nums1 �ںϺ��β
        
        while(i>=0&&j>=0)
        {
            if(nums1[i]>nums2[j])
                nums1[k--]=nums1[i--];
            else
                nums1[k--]=nums2[j--];
        }
        
        while(j>=0)
        {
            nums1[k--]=nums2[j--];
        }
    }
}