import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName rob3
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/15 10:46
 * @Version 1.0
 */

public class rob3 {
    public static void main(String[] args) {
        rob3 test = new rob3();
        System.out.println(test.rob(new TreeNode(1)));
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

    Map<TreeNode,Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int rob_it = root.val
                +(root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                +(root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_rob = rob(root.left) + rob(root.right);

        int res = Math.max(rob_it,not_rob);

        memo.put(root, res);
        return res;
    }


}
