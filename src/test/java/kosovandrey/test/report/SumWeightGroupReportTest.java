package kosovandrey.test.report;

import kosovandrey.test.result.SumWeightGroupResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumWeightGroupReportTest {

    @Test
    void testGetBody() {
        SumWeightGroupResult result = new SumWeightGroupResult("Group1", 150L);
        SumWeightGroupReport report = new SumWeightGroupReport(result);

        List<String> expectedBody = List.of(
                "Sum of weights for group Group1: 150\n"
        );

        assertEquals(expectedBody, report.getBody());
    }
}