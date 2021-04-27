import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName rangeSumBST
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/27 9:26
 * @Version 1.0
 */

public class rangeSumBST20210427 {
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
        rangeSumBST20210427 test = new rangeSumBST20210427();
        test.rangeSumBST1(new TreeNode(1),0,1);

    }

//  中序遍历直接进行数组内求解
    /*
    public int rangeSumBST1(TreeNode root, int low, int high) {
        List<Integer> res = new ArrayList<>();
        midOrder(root,res);
        int sum =0;
        for(int num:res){
            if(num >= low && num <= high){
                sum += num;
            }
        }
        return sum;
    }

    public void midOrder(TreeNode root,List<Integer> res){
        if(root == null) return;
        midOrder(root.left,res);
        res.add(root.val);
        midOrder(root.right,res);
    }
     */

    //方法二：采用深度优先搜索，利用二叉搜索树的特性进行深度遍历。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val > high){
            return rangeSumBST(root.left,low,high);
        }
        if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }

        return root.val + rangeSumBST(root.left,low,high)+ rangeSumBST(root.right,low,high);
    }

}
