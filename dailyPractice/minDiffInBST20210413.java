import java.util.ArrayList;

/**
 * @ClassName minDiffInBST20210413
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/13 9:25
 * @Version 1.0
 */

public class minDiffInBST20210413 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }



    public static void main(String[] args) {
        TreeNode s = new TreeNode(4);
        minDiffInBST20210413 test = new minDiffInBST20210413();
        System.out.println(test.minDiffInBST1(s));
    }
//解法1：利用中序遍历 ，找到二叉搜索树的有序排列，求差分后找到最小值
    ArrayList tree = new ArrayList();

    public int minDiffInBST1(TreeNode root) {
        midTraversal(root);   //中序遍历
        int[] diff = new int[tree.size()-1];  //差分
        int min = Integer.MAX_VALUE;  //最小值
        for(int i = 1;i<tree.size();i++){
            diff[i-1] = ((Integer)tree.get(i)-(Integer)tree.get(i-1));
        }
        for(int num:diff){
            min = Math.min(num,min);
        }
        return min;
    }

    public void midTraversal(TreeNode root){
        if(root == null) return;
        midTraversal(root.left);
        tree.add(root.val);
        midTraversal(root.right);
    }

//解法2：解法1的改进，在一次遍历中求得最小值
/*
    public int lastValue = -1;
    public int minValue = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        midTraversal(root);
        return minValue;
    }

    public void midTraversal(TreeNode root){
        if(root == null) return;
        midTraversal(root.left);
        dealNodeValue(root.val);
        midTraversal(root.right);
    }

    public void dealNodeValue(int val){
        if(lastValue == -1){
            lastValue = val;
        } else{
            minValue = Math.min(minValue, val - lastValue);
            lastValue = val;
        }
    }
*/
}
