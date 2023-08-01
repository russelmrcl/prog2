package b06a4;

import b02a3.Schlange;
import b03a2.SchlangeMitEVL;
import b05a2.Folge;
import b05a3.FolgeMitRing;

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
        return root == null;
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

    public TreeElement remove(Integer i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (!contains(i)) {
            throw new IllegalArgumentException();
        }
        return remove(root, i);
    }

    private TreeElement remove(TreeElement current, int data) {

        //Going through the search tree
        if (data < current.data) {
            current.left = remove(current.left, data);
        } else if (data > current.data) {
            current.right = remove(current.right, data);
        } else {
            // 1st case: node without successor
            if (current.left == null && current.right == null) {
                // Node has no children, so it can be safely removed
                return null;
            }
            // 2nd case: node with one successor
            else if (current.left == null) {
                // Node has only a right child, so the right child replaces the current node
                return current.right;
            } else if (current.right == null) {
                // Node has only a left child, so the left child replaces the current node
                return current.left;
            }
            // 3rd case node with two successors
            else {
                // Find the maximum value in the right subtree (successor)
                TreeElement successor = findMax(current.left);
                // Replace the data of the current node with the successor data
                current.data = successor.data;
                // Remove the successor from the right subtree
                current.left = remove(current.left, successor.data);
            }
        }
        /*The method concludes by returning "current" to preserve
        any changes made to the current tree node.*/
        return current;
    }

    public Folge<Integer> preorder() {
        Folge<Integer> result = new FolgeMitRing<>(size());
        preorder(root, result);
        return result;
    }

    private void preorder(TreeElement current, Folge<Integer> result) {

        if (current == null) {
            return;
        }

        result.insert(current.data);
        preorder(current.left, result);
        preorder(current.right, result);
    }

    public Folge<Integer> inorder() {
        Folge<Integer> result = new FolgeMitRing<>(size());
        inorder(root, result);
        return result;
    }

    private void inorder(TreeElement current, Folge<Integer> result) {

        if (current == null) {
            return;
        }

        inorder(current.left, result);
        result.insert(current.data);
        inorder(current.right, result);
    }

    public Folge<Integer> postorder() {
        Folge<Integer> result = new FolgeMitRing<>(size());
        postorder(root, result);
        return result;
    }

    private void postorder(TreeElement current, Folge<Integer> result) {

        if (current == null) {
            return;
        }

        postorder(current.left, result);
        postorder(current.right, result);
        result.insert(current.data);
    }

    public Folge<Integer> breitensuche() {
        Folge<Integer> result = new FolgeMitRing<>(size());
        Schlange<TreeElement> queue = new SchlangeMitEVL<>();

        if (root != null) {
            queue.insert(root);
        }

        while (!queue.isEmpty()) {
            TreeElement current = queue.remove();
            result.insert(current.data);

            if (current.left != null) {
                queue.insert(current.left);
            }
            if (current.right != null) {
                queue.insert(current.right);
            }
        }
        return result;
    }


    public boolean contains(Integer i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return contains(root, i);
        }
    }

    private boolean contains(TreeElement current, Integer data) {

        if (current == null) {
            return false;
        }

        if (current.data == data) {
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
        } else if (leftStr.isEmpty()) {
            return "(" + current.data + rightStr + ")";
        } else if (rightStr.isEmpty()) {
            return "(" + leftStr + current.data + ")";
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

    private TreeElement findMax(TreeElement current) {
        if (current.right == null) {
            return current;
        }
        return findMax(current.right);
    }
}
