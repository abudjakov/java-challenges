package binarytree;

import java.util.*;
import java.util.stream.Collectors;


/*
* Find all nodes at distance K
* */
public class AllNodesDistanceK {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);

        System.out.println("Nodes with 2 distance are: " + solution(root, root.left(), 2)); // 1, 8, 5
        System.out.println("Nodes with 2 distance are: " + solution(root, root.right(), 2)); // 7, 4
        System.out.println("Nodes with 3 distance are: " + solution(root, root.right(), 3)); // 3, 6
    }

    private static void populateParents(Map<TreeNode<Integer>, TreeNode<Integer>> parents, TreeNode<Integer> root, TreeNode<Integer> parent) {
        if (root == null) return;

        parents.put(root, parent);

        populateParents(parents, root.left(), root);
        populateParents(parents, root.right(), root);
    }

    public static List<Integer> solution(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        if (root == null || target == null || k < 0) return Collections.emptyList();

        Map<TreeNode<Integer>, TreeNode<Integer>> parents = new HashMap<>();
        populateParents(parents, root, null);

        int level = 0;

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(target);

        Set<TreeNode> marked = new HashSet<>();
        marked.add(target);

        while (!queue.isEmpty()) {

            if (level == k) {
                return queue.stream().map(TreeNode::data).collect(Collectors.toList());
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();

                if (node.left() != null && !marked.contains(node.left())) {
                    marked.add(node.left());
                    queue.offer(node.left());
                }

                if (node.right() != null && !marked.contains(node.right())) {
                    marked.add(node.right());
                    queue.offer(node.right());
                }

                TreeNode<Integer> parent = parents.get(node);
                if (parent != null && !marked.contains(parent)) {
                    marked.add(parent);
                    queue.offer(parent);
                }
            }

            level++;
        }

        return Collections.emptyList();
    }

    private static TreeNode<Integer> test() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(5);
        TreeNode<Integer> n21 = new TreeNode<>(3);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n23 = new TreeNode<>(9);
        TreeNode<Integer> n31 = new TreeNode<>(1);
        TreeNode<Integer> n32 = new TreeNode<>(8);
        TreeNode<Integer> n33 = new TreeNode<>(4);

        root.left(n11);
        root.right(n12);

        n11.left(n21);
        n11.right(n22);

        n12.right(n23);
        n22.left(n31);
        n22.right(n32);

        n23.left(n33);

        return root;
    }
}
