package kosovandrey.test.report;

import kosovandrey.test.result.MaxMinWeightResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxMinWeightReportTest {

    @Test
    void testGetBody() {
        MaxMinWeightResult result = new MaxMinWeightResult(100L, 10L);
        MaxMinWeightReport report = new MaxMinWeightReport(result);

        List<String> expectedBody = Arrays.asList(
                "Max and min weights:\n",
                "max: 100, min: 10\n"
        );

        assertEquals(expectedBody, report.getBody());
    }
}