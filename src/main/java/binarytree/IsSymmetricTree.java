package binarytree;

public class IsSymmetricTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = test();
        System.out.println("Original:");
        BTreePrinter.print(root);

        System.out.println("Is Symmetric: " + solution(root)); // true

    }

    public static boolean solution(TreeNode<Integer> root) {
        if (root == null) return true;
        return check(root.left(), root.right());
    }

    public static boolean check(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null & right != null) {
            return left.data().equals(right.data()) &&
                    check(left.left(), right.right()) &&
                    check(left.right(), right.left());
        }

        return false;
    }


    private static TreeNode<Integer> test() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(7);
        TreeNode<Integer> n21 = new TreeNode<>(3);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n31 = new TreeNode<>(6);
        TreeNode<Integer> n33 = new TreeNode<>(3);

        root.left(n11);
        root.right(n12);

        n11.left(n21);
        n11.right(n22);

        n12.left(n31);
        n12.right(n33);


        return root;
    }
}
