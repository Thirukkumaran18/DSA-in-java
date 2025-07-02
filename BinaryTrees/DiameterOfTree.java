
class Main {
    static int diam = 0;
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(diameter(root));
        
    }
    public static int diameter(TreeNode root) {
        // Your code here
        traversal(root);
        
        return diam;
    }
    public static int traversal(TreeNode node){
        
        if(node == null)return 0;
        
        int left = traversal(node.left);
        int right = traversal(node.right);
        
        diam = Math.max(diam, left+right);
        return 1 + Math.max(left, right);
    }

   
}
