package kosovandrey.test.result;

import kosovandrey.test.model.Duplicate;
import kosovandrey.test.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateGroupTypeResultTest {

    private DuplicateGroupTypeResult result1;
    private DuplicateGroupTypeResult result2;
    private DuplicateGroupTypeResult result3;

    @BeforeEach
    void setUp() {
        Item item1 = new Item("group1", "type1", 1, 100);
        Item item2 = new Item("group1", "type1", 2, 200);
        Item item3 = new Item("group2", "type2", 3, 300);

        Duplicate duplicate1 = new Duplicate("group1", "type1", Arrays.asList(item1, item2));
        Duplicate duplicate2 = new Duplicate("group2", "type2", Arrays.asList(item3));

        result1 = new DuplicateGroupTypeResult(Arrays.asList(duplicate1, duplicate2));
        result2 = new DuplicateGroupTypeResult(Arrays.asList(duplicate1, duplicate2));
        result3 = new DuplicateGroupTypeResult(new ArrayList<>());
    }

    @Test
    void testGetDuplicates() {
        List<Duplicate> duplicates = result1.getDuplicates();
        assertEquals(2, duplicates.size());
        assertEquals("group1", duplicates.get(0).getGroup());
        assertEquals("type1", duplicates.get(0).getType());
        assertEquals(2, duplicates.get(0).getCount());
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
}