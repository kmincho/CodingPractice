package com.kmcho.com.linkedin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class TwoSumTest {
    @Test
    public void test() {
        TwoSum twoSum = new TwoSum();
        twoSum.store(1);
        twoSum.store(-2);
        twoSum.store(3);
        twoSum.store(6);

        assertEquals(twoSum.test(4), true);
        assertEquals(twoSum.test(-1), true);
        assertEquals(twoSum.test(9), true);
        assertEquals(twoSum.test(10), false);
        assertEquals(twoSum.test(5), false);
        assertEquals(twoSum.test(0), false);
    }
}