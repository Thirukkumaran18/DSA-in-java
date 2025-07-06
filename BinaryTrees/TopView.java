
import java.util.*;

class Pair {

    TreeNode node;
    int line;

    Pair(TreeNode node, int line) {
        this.node = node;
        this.line = line;
    }
}

class Main {

    public static void main(String[] args) {
        TreeNode root = CommonTree.root;
        System.out.println(topView(root));

    }

    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int line = curr.line;

            if (!map.containsKey(line)) {
                map.put(line, node.val);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }
}
