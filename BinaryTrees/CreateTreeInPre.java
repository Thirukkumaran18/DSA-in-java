
import java.util.HashMap;


class Main {
    
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        int in[] = {1, 6, 8, 7};
        int pre[] = {1, 6, 7, 8};
        buildTree(in, pre);

        // Traverse and see the node will be deleted
        
    }
    public static TreeNode buildTree(int in[], int pre[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i], i);
        }
        
        int inS = 0 , prS=0, inE = in.length-1, prE = pre.length-1;
        return traverse(in, inS, inE, pre, prS, prE, map);
    }
    public static TreeNode traverse(int[] in, int inS, int inE, int[] pre, int prS, int prE, HashMap<Integer, Integer> map){
        
        
        if(inS > inE || prS > prE)return null;
        
        TreeNode node  = new TreeNode(pre[prS]);
        // find the index of the node val in inorder
        
        int inPos = map.get(node.val);
        int numsLeft = inPos - inS ;
        
        node.left = traverse(in, inS, inPos-1, pre, prS+1, prS+numsLeft, map);
        node.right = traverse(in, inPos+1, inE, pre, prS+numsLeft+1, prE, map);
        
        return node ;
    }
   
}
