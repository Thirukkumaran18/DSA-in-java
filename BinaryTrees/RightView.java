
import java.util.*;

class Pair {

    TreeNode node;
    int line;

    Pair(TreeNode node, int line) {
        this.node = node;
        this.line = line;
    }
}

class Main {

    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(rightSideView(root));

    }

    public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int levelSize = q.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode curr = q.poll();
            if (i == levelSize - 1) result.add(curr.val); // last node of level

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    return result;
}

}
