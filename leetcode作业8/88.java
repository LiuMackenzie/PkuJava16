public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //方法一：
        /*
        for(int i=m;i<m+n;i++)
        {

            nums1[i]=nums2[i-m];
        }

       Arrays.sort(nums1);
        */
        
        //方法二：
        //nums1 {1,2,3}
        //nums2 {3,4,5}
        //从nums1,nums2尾部开始比较,
        //如果nums1[2]>nums1[2],则nums1[末尾]=nums1[2],指针往后移
        //否则，nums1[末尾]=nums2[2]，指针往后移
        
        int i=m-1;//nums1的尾
        int j=n-1;//nums2的尾
        int k=m+n-1; //nums1 融合后的尾
        
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