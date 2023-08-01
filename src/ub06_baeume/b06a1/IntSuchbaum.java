package b06a1;

import java.util.NoSuchElementException;

public class IntSuchbaum {

    private TreeElement root;

    public IntSuchbaum() {
        root = null;
    }

    private class TreeElement {

        Integer data;
        TreeElement left;
        TreeElement right;

        TreeElement(Integer data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(Integer i) {

        if (isEmpty()) {
            root = new TreeElement(i);
        } else {
            insert(root, i);
        }
    }

    private void insert(TreeElement current, Integer data) {

        if (data < current.data) {
            if (current.left == null) {
                current.left = new TreeElement(data);
            } else {
                insert(current.left, data);
            }
        }
        if (data > current.data) {
            if (current.right == null) {
                current.right = new TreeElement(data);
            } else {
                insert(current.right, data);
            }
        }

    }

    public boolean contains(Integer i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return contains(root, i);
    }

    private boolean contains(TreeElement current, Integer data) {

        if (current == null) {
            return false;
        }

        if (data == current.data) {
            return true;
        } else if (data < current.data) {
            return contains(current.left, data);
        } else {
            return contains(current.right, data);
        }
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeElement current) {

        if (current == null) {
            return "";
        }

        String leftStr = toString(current.left);
        String rightStr = toString(current.right);

        if (leftStr.isEmpty() && rightStr.isEmpty()) {
            return "(" + current.data + ")";
        } else if (rightStr.isEmpty()) {
            return "(" + leftStr + current.data + ")";
        } else if (leftStr.isEmpty()) {
            return "(" + current.data + rightStr + ")";
        } else {
            return "(" + leftStr + current.data + rightStr + ")";
        }
    }

    public int hoehe() {
        return hoehe(root);
    }

    private int hoehe(TreeElement current) {

        if (current == null) {
            return 0;
        }

        int leftHoehe = hoehe(current.left);
        int rightHoehe = hoehe(current.right);

        return Math.max(leftHoehe, rightHoehe) + 1;

    }

    public int size() {
        return size(root);
    }

    private int size(TreeElement current) {

        if (current == null) {
            return 0;
        }

        int leftSize = size(current.left);
        int rightSize = size(current.right);

        return leftSize + rightSize + 1;

    }

}
