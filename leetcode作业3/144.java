
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //方法类似于中序遍历，利用stack记录待遍历的元素。。。
        //先序：根->左孩子->右孩子
        
        List<Integer> list=new ArrayList<Integer>();//存返回结果
        Stack<TreeNode> stack=new Stack<TreeNode>();//存待遍历的元素
        
        while(!(stack.size()==0&&root==null)){
            //add根，遍历左孩子
            while(root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            //逐一处理stack中元素的右孩子
            while(stack.size()>0&&root==null)
            {
                root=stack.pop();
                root=root.right;
            }
        }
        return list;
    }
}