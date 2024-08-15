package kosovandrey.test.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxMinWeightResultTest {

    private MaxMinWeightResult result1;
    private MaxMinWeightResult result2;
    private MaxMinWeightResult result3;

    @BeforeEach
    void setUp() {
        result1 = new MaxMinWeightResult(100L, 50L);
        result2 = new MaxMinWeightResult(100L, 50L);
        result3 = new MaxMinWeightResult(200L, 10L);
    }

    @Test
    void testGetMax() {
        assertEquals(100L, result1.getMax());
        assertEquals(200L, result3.getMax());
    }

    @Test
    void testGetMin() {
        assertEquals(50L, result1.getMin());
        assertEquals(10L, result3.getMin());
    }

    @Test
    void testEquals() {
        assertEquals(result1, result2);
        assertNotEquals(result1, result3);
    }

    @Test
    void testHashCode() {
        assertEquals(result1.hashCode(), result2.hashCode());
        assertNotEquals(result1.hashCode(), result3.hashCode());
    }

    @Test
    void testNotEqualsDifferentClass() {
        assertNotEquals(result1, "someString");
    }

    @Test
    void testEqualsSameInstance() {
        assertEquals(result1, result1);
    }

    @Test
    void testDefaultConstructor() {
        MaxMinWeightResult defaultResult = new MaxMinWeightResult();
        assertEquals(0L, defaultResult.getMax());
        assertEquals(0L, defaultResult.getMin());
    }
}