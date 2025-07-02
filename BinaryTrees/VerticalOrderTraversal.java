import java.util.*;
class Pair{
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row ;
        this.col = col;
    }
}

class Main {
    
    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(verticalTraversal(root));
        
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode currNode = curr.node;
            int x = curr.row;
            int y = curr.col;

            if(!map.containsKey(x))map.put(x, new TreeMap<>());
            if(!map.get(x).containsKey(y))map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).add(currNode.val);

            if(currNode.left!=null)q.add(new Pair(currNode.left, x-1, y+1));
            if(currNode.right!=null)q.add(new Pair(currNode.right, x+1, y+1));
        }
        List<List<Integer>> mainList = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()){
            List<Integer> list = new ArrayList<>();
            for( PriorityQueue<Integer> nodes : colMap.values()){
                while(!nodes.isEmpty()){
                    list.add(nodes.poll());
                }
            }
            mainList.add(list);
        }

        return mainList;
    }
}
