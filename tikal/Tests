package tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    private code.Game _g;

    @Before
    public void startUp() {
        _g = new code.Game();
    }

    @Test
    public void testAddExplorer() {
        int[] x = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] i = _g.placeExplorer(0);
        assertArrayEquals(i, x);
    }

    @Test
    public void testAddPyramid() {
        int[] x = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] i = _g.placePyramid(0);
        assertArrayEquals(i, x);
    }
    
    @Test
    public void testSwitchPlayer() {
    //test that ending turn actually changes player
    }
    
    @Test
    public void testScoring(){
    //test that when the game ends, scoring happens correctly
        int [] p1e = { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int [] p2e = { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int [] ppp = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int expected = 1;
        int actual = _g.scoreP1(p1e, p2e, ppp);
        assertTrue("",expected==actual);

    }
    @Test
    public void testScoring2(){
    int [] p1e = { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int [] p2e = { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int [] ppp = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int expected = 12;
    int actual = _g.scoreP2(p1e, p2e, ppp);
    assertTrue("",expected==actual);
    }
}
