package kosovandrey.test.report;

import kosovandrey.test.model.Duplicate;
import kosovandrey.test.model.Item;
import kosovandrey.test.result.DuplicateGroupTypeResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateGroupTypeReportTest {

    @Test
    void testGetBody() {
        Item item1 = new Item("Group1", "Type1", 123, 50);
        Item item2 = new Item("Group1", "Type1", 124, 55);
        Duplicate duplicate = new Duplicate("Group1", "Type1", Arrays.asList(item1, item2));

        DuplicateGroupTypeResult result = new DuplicateGroupTypeResult(Arrays.asList(duplicate));
        DuplicateGroupTypeReport report = new DuplicateGroupTypeReport(result);

        List<String> expectedBody = Arrays.asList(
                "Duplicates by group: Group1 and type Type1\n",
                "Item: group: Group1, type: Type1, number: 123, weight: 50\n",
                "Item: group: Group1, type: Type1, number: 124, weight: 55\n"
        );

        assertEquals(expectedBody, report.getBody());
    }
}