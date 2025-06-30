public class CommonTree {
    public static TreeNode root;

    static {
        /*
                  10
                 /  \
                5    15
               / \     \
              3   7     18
        */
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
    }
}
