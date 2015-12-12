public class Solution {
    public boolean isAnagram(String s, String t) {
        //分析：
        /*解这个问题有两种思路，
        第一种思路：由于题目限定字符串中只包含小写字母，那么分别计算两个字符串中每个字母出现次数，然后再比较即可。
        第二种思路：把字符串看作字符数组，将两个字符数组分别排序，所得结果若相同，则说明两个字符串互为变位词。*/
        char[] sArr = s.toCharArray();  
        char[] tArr = t.toCharArray();  
          
        Arrays.sort(sArr);  
        Arrays.sort(tArr);  
          
        //return sArr==tArr; //错误
        return Arrays.equals(sArr,tArr);//注意数组如何比较相等
    }
}