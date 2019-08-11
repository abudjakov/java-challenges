package binarytree;

public class BinaryTreeTraverse {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);
        System.out.print("inOrderTraverse: ");
        inOrderTraverse(root);
        System.out.println();
        System.out.print("preOrderTraverse: ");
        preOrderTraverse(root);
        System.out.println();
        System.out.print("postOrderTraverse: ");
        postOrderTraverse(root);
    }

    public static void inOrderTraverse(TreeNode<Integer> node) {
        if (node == null) return;
        inOrderTraverse(node.left());
        visit(node);
        inOrderTraverse(node.right());
    }

    public static void preOrderTraverse(TreeNode<Integer> node) {
        if (node == null) return;
        visit(node);
        preOrderTraverse(node.left());
        preOrderTraverse(node.right());
    }

    public static void postOrderTraverse(TreeNode<Integer> node) {
        if (node == null) return;
        postOrderTraverse(node.left());
        postOrderTraverse(node.right());
        visit(node);
    }

    public static void visit(TreeNode<Integer> node) {
        System.out.print(node.data() + " ");
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
