
class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(maxPathSum(root));
        
    }
    public static int maxPathSum(TreeNode root) {
        traversal(root);
        return max ;
    }
    public static int traversal(TreeNode node){
        if(node == null)return 0;

        int l = traversal(node.left);
        int r = traversal(node.right);

        if(l<0)l=0; if(r<0)r=0;
        max = Math.max(max, (l+r+node.val));
        return node.val + Math.max(l, r);
    }
   

   
}
