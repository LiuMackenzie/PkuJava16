public class Solution {
    public boolean isAnagram(String s, String t) {
        //������
        /*���������������˼·��
        ��һ��˼·��������Ŀ�޶��ַ�����ֻ����Сд��ĸ����ô�ֱ���������ַ�����ÿ����ĸ���ִ�����Ȼ���ٱȽϼ��ɡ�
        �ڶ���˼·�����ַ��������ַ����飬�������ַ�����ֱ��������ý������ͬ����˵�������ַ�����Ϊ��λ�ʡ�*/
        char[] sArr = s.toCharArray();  
        char[] tArr = t.toCharArray();  
          
        Arrays.sort(sArr);  
        Arrays.sort(tArr);  
          
        //return sArr==tArr; //����
        return Arrays.equals(sArr,tArr);//ע��������αȽ����
    }
}