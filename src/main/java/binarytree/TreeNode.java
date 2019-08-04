package binarytree;

public class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode data(T value) {
        this.data = value;
        return this;
    }

    public TreeNode left(TreeNode<T> left) {
        this.left = left;
        return this;
    }

    public TreeNode right(TreeNode<T> right) {
        this.right = right;
        return this;
    }

    public T data() {
        return data;
    }

    public TreeNode<T> left() {
        return left;
    }

    public TreeNode<T> right() {
        return right;
    }


}
