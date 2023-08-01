package b06a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {

    IntSuchbaum baum;

    @BeforeEach
    void setUp() {
        baum = new IntSuchbaum();
        baum.insert(3);
        baum.insert(2);
        baum.insert(5);
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
    }

    @Test
    void preorderTest() {
        assertEquals("[3, 2, 1, 5, 4, 7]", baum.preorder().toString());
    }

    @Test
    void inorderTest() {
        assertEquals("[1, 2, 3, 4, 5, 7]", baum.inorder().toString());
    }

    @Test
    void postorderTest() {
        assertEquals("[1, 2, 4, 7, 5, 3]", baum.postorder().toString());
    }

    @Test
    void breitensucheTest() {
        assertEquals("[3, 2, 5, 1, 4, 7]", baum.breitensuche().toString());
    }
}