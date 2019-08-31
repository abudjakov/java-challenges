package binarytree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);

        System.out.println("lca of 3 and 8: " + lca(root, 3, 8)); // 7
        System.out.println("lca of 6 and 8: " + lca(root, 6, 8)); // 6
        System.out.println("lca of 1 and 8: " + lca(root, 1, 8)); // 6
        System.out.println("lca of 7 and 10: " + lca(root, 7, 10)); // 7
        System.out.println("lca of 1 and 4: " + lca(root, 1, 4)); // 2
        System.out.println("lca of 11 and 10: " + lca(root, 11, 10)); // null

    }

    public static Integer lca(TreeNode<Integer> root, Integer a, Integer b) {
        if (root == null) return null;
        if (root.data().equals(a) || root.data().equals(b)) return root.data();

        Integer left = lca(root.left(), a, b);
        Integer right = lca(root.right(), a, b);

        if (left == null) return right;
        if (right == null) return left;

        return root.data();
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
