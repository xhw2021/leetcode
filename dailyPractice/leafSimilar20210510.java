import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * @ClassName leafSimilar20210510
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/10 9:28
 * @Version 1.0
 */

public class leafSimilar20210510 {

    public static void main(String[] args) {
        leafSimilar20210510 test = new leafSimilar20210510();
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        System.out.println(test.leafSimilar(root1,root2));

    }

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();

        leafValue(root1,ans1);
        leafValue(root2,ans2);

        // if(ans1.size() != ans2.size()){
        //     return false;
        // }else{
        //     for(int i = 0;i< ans1.size();i++){
        //         if(ans1.get(i) != ans2.get(i)){
        //             return false;
        //         }
        //     }
        //     return true;
        // }
        return ans1.equals(ans2);

    }

    public void leafValue(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            arr.add(root.val);
            return;
        }
        leafValue(root.left,arr);
        leafValue(root.right,arr);
    }
}
