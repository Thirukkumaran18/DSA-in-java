
class Main {
    
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        int key = 15 ;
        traverse(root, key);

        // Traverse and see the node will be deleted
        
    }
    public static TreeNode traverse(TreeNode node, int key){

        if(node == null)return null;

        if(node.val == key){
            
            if(node.left == null){
                return node.right;
            }
            TreeNode deepRight = getDeepRight(node.left);
            deepRight.right = node.right;
            return node.left;
        }

        
        if(node.val > key){
            node.left = traverse(node.left, key);
        }else{
            node.right = traverse(node.right, key);
        }

        return node;

    }
    public static TreeNode getDeepRight(TreeNode node){
        TreeNode curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr;
    }

   
}
