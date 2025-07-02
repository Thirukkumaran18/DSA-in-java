
class Main {
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(isBalanced(root));
        
    }
    public static boolean isBalanced(TreeNode root) {
        // code here
        return traversal(root)!= -1;
    }
    public static int traversal(TreeNode node){
        
        if(node == null)return 0;
        
        int left = traversal(node.left);
        if(left == -1)return -1;
        
        int right = traversal(node.right);
        if(right == -1) return -1;
        
        if(Math.abs(left-right) >1)return -1;
        
        return 1+Math.max(left, right);
    }

   
}
