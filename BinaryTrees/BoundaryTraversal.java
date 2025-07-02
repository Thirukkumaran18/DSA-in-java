import java.util.*;
class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(boundaryTraversal(root));
        
    }
    public static ArrayList<Integer> boundaryTraversal(TreeNode node) {
        // code here
        ArrayList<Integer> mainList = new ArrayList<>();
        if(!isLeaf(node))mainList.add(node.val);
        addLeftBoundary(node, mainList);
        addBoundaries(node, mainList);
        addRightBoundary(node, mainList);
        
        return mainList;
        
    }
    public static void addLeftBoundary(TreeNode node, ArrayList<Integer> mainList){
        TreeNode curr = node.left;
        while(curr != null){
            
            if(!isLeaf(curr))mainList.add(curr.val);
            if(curr.left != null)curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addBoundaries(TreeNode node, ArrayList<Integer> mainList){
        if(isLeaf(node))mainList.add(node.val);
        if(node.left != null)addBoundaries(node.left, mainList);
        if(node.right != null)addBoundaries(node.right, mainList);
    }
    public static void addRightBoundary(TreeNode node, ArrayList<Integer> mainList){
        TreeNode curr = node.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr))temp.add(curr.val);
            if(curr.right != null)curr = curr.right;
            else curr = curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            mainList.add(temp.get(i));
        }
    }
    public static boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null)return true;
        return false;
    }
}
