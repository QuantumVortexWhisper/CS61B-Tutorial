import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('h', 'g'));
        assertFalse(offByOne.equalChars('z', 'p'));
        assertTrue(offByOne.equalChars('&', '%'));

        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('b', 'B'));
        assertFalse(offByOne.equalChars('C', 'c'));
        assertFalse(offByOne.equalChars('D', 'd'));
    }
}
