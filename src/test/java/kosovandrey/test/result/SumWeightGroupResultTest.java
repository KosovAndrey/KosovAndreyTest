package kosovandrey.test.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumWeightGroupResultTest {

    private SumWeightGroupResult result1;
    private SumWeightGroupResult result2;
    private SumWeightGroupResult result3;

    @BeforeEach
    void setUp() {
        result1 = new SumWeightGroupResult("group1", 150L);
        result2 = new SumWeightGroupResult("group1", 150L);
        result3 = new SumWeightGroupResult("group2", 200L);
    }

    @Test
    void testGetGroup() {
        assertEquals("group1", result1.getGroup());
        assertEquals("group2", result3.getGroup());
    }

    @Test
    void testGetSumWeight() {
        assertEquals(150L, result1.getSumWeight());
        assertEquals(200L, result3.getSumWeight());
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
        SumWeightGroupResult defaultResult = new SumWeightGroupResult();
        assertEquals("", defaultResult.getGroup());
        assertEquals(0L, defaultResult.getSumWeight());
    }
}