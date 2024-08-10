import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testEqualChars() {
        OffByN offByN = new OffByN(5);
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('c', 'h'));
        assertFalse(offByN.equalChars('f', 'h'));
        assertFalse(offByN.equalChars('z', 'y'));
    }
}
