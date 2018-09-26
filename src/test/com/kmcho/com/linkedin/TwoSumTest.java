package com.kmcho.com.linkedin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        assertTrue(twoSum.test(4));
        assertTrue(twoSum.test(-1));
        assertTrue(twoSum.test(9));
        assertFalse(twoSum.test(10));
        assertFalse(twoSum.test(5));
        assertFalse(twoSum.test(0));
    }
}