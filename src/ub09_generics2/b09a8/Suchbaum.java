package b09a8;

import b02a3.Schlange;
import b03a2.SchlangeMitEVL;
import b05a2.Folge;
import b05a3.FolgeMitRing;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Suchbaum<T extends Comparable<T>> {

    private TreeElement root;
    private Comparator<T> comp;

    public Suchbaum() {
        root = null;
        comp = null;
    }

    public Suchbaum(Comparator<T> comp) {
        root = null;
        this.comp = comp;
    }

    private class TreeElement {

        T data;
        TreeElement left;
        TreeElement right;

        TreeElement(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(T o1, T o2) {
        if (comp != null) {
            return comp.compare(o1, o2);
        } else {
            //T Object must be implements the Comparable Interface
            Comparable<T> naturalOrder = o1;
            return naturalOrder.compareTo(o2);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T i) {
        if (isEmpty()) {
            root = new TreeElement(i);
        } else {
            insert(root, i);
        }
    }

    private void insert(TreeElement current, T data) {

        if (compare(data, current.data) < 0) {
            if (current.left == null) {
                current.left = new TreeElement(data);
            } else {
                insert(current.left, data);
            }
        }

        if (compare(data, current.data) > 0) {
            if (current.right == null) {
                current.right = new TreeElement(data);
            } else {
                insert(current.right, data);
            }
        }
    }

    public TreeElement remove(T i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (!contains(i)) {
            throw new IllegalArgumentException();
        }
        return remove(root, i);
    }

    private TreeElement remove(TreeElement current, T data) {

        if (compare(data, current.data) < 0) {
            current.left = remove(current.left, data);
        } else if (compare(data, current.data) > 0) {
            current.right = remove(current.right, data);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            else {
                TreeElement successor = findMax(current.left);
                current.data = successor.data;
                current.left = remove(current.left, successor.data);
            }
        }
        return current;
    }

    public Folge<T> preorder() {
        Folge<T> result = new FolgeMitRing<>(size());
        preorder(root, result);
        return result;
    }

    private void preorder(TreeElement current, Folge<T> result) {
        if (current == null) {
            return;
        }

        result.insert(current.data);
        preorder(current.left, result);
        preorder(current.right, result);
    }

    public Folge<T> inorder() {
        Folge<T> result = new FolgeMitRing<>(size());
        inorder(root, result);
        return result;
    }

    private void inorder(TreeElement current, Folge<T> result) {

        if (current == null) {
            return;
        }

        inorder(current.left, result);
        result.insert(current.data);
        inorder(current.right, result);
    }

    public Folge<T> postorder() {
        Folge<T> result = new FolgeMitRing<>(size());
        postorder(root, result);
        return result;
    }

    private void postorder(TreeElement current, Folge<T> result) {

        if (current == null) {
            return;
        }

        postorder(current.left, result);
        postorder(current.right, result);
        result.insert(current.data);
    }

    public Folge<T> breitensuche() {
        Folge<T> result = new FolgeMitRing<>(size());
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


    public boolean contains(T i) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return contains(root, i);
        }
    }

    private boolean contains(TreeElement current, T data) {

        if (current == null) {
            return false;
        }

        if (current.data == data) {
            return true;
        } else if (compare(data, current.data) < 0) {
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
