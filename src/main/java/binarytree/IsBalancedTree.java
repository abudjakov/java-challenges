package binarytree;

public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);
        System.out.println("Height: " + height(root) + " Is Balanced: " + isBalanced(root)); // 4 true
    }

    public static boolean isBalanced(TreeNode<Integer> root) {
        if (root == null) return true;

        return Math.abs(height(root.left()) - height(root.right())) <= 1 &&
                isBalanced(root.left()) &&
                isBalanced(root.right());
    }

    public static int height(TreeNode<Integer> node) {
        if (node == null) return 0;

        return Math.max(height(node.left()), height(node.right())) + 1;
    }

    private static TreeNode<Integer> test() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(5);
        TreeNode<Integer> n21 = new TreeNode<>(3);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n23 = new TreeNode<>(9);
        TreeNode<Integer> n24 = new TreeNode<>(9);
        TreeNode<Integer> n31 = new TreeNode<>(1);
        TreeNode<Integer> n32 = new TreeNode<>(8);
        TreeNode<Integer> n33 = new TreeNode<>(4);

        root.left(n11);
        root.right(n12);

        n11.left(n21);
        n11.right(n22);

        n12.left(n24);
        n12.right(n23);
        n22.left(n31);
        n22.right(n32);

        n23.left(n33);

        return root;
    }
}
