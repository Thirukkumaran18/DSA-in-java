import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;

        System.out.println("Preorder: " + preorderTraversal(root));
        System.out.println("Inorder: " + inorderTraversal(root));
        System.out.println("Postorder: " + postorderTraversal(root));
        System.out.println("Level Order: " + levelOrderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public static void postorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            list.add(currLevel);
        }

        return list;
    }
}
