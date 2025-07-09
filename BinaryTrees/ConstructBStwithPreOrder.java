
import java.util.HashMap;


class Main {
    
    
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        int in[] = {1, 6, 8, 7};
        int pre[] = {1, 6, 7, 8};
        buildTree(in, pre);

        // Traverse and see the node will be deleted
        
    }
    public TreeNode traverse(int[] pre, int min, int max){

        if(index >= pre.length || pre[index] < min || pre[index] > max )return null;

        TreeNode node = new TreeNode(pre[index]);
        index++ ;

        node.left = traverse(pre, min, node.val-1);
        node.right = traverse(pre, node.val+1, max);

        return node ;
    }

    
   
}
