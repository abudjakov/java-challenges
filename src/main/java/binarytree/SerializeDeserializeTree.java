package binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized); // 2,7,3,X,X,6,5,X,X,8,X,X,5,X,9,4,X,X,X,
        TreeNode<Integer> deserialized = deserialize(serialized);
        System.out.println("Deserialized:");
        BTreePrinter.print(deserialized);
    }

    // pre-order
    public static String serialize(TreeNode<Integer> node) {
        if (node == null) {
            return "X,";
        }

        String left = serialize(node.left());
        String right = serialize(node.right());

        return node.data() + "," + left + right;
    }

    public static TreeNode<Integer> deserialize(String s) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(s.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode<Integer> deserializeHelper(Queue<String> queue) {
        String node = queue.poll();
        if (node == null || node.equals("X")) {
            return null;
        }

        TreeNode<Integer> treeNode = new TreeNode<>(Integer.valueOf(node));
        treeNode.left(deserializeHelper(queue));
        treeNode.right(deserializeHelper(queue));

        return treeNode;
    }

    private static TreeNode<Integer> test() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(5);
        TreeNode<Integer> n21 = new TreeNode<>(3);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n23 = new TreeNode<>(9);
        TreeNode<Integer> n31 = new TreeNode<>(5);
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
