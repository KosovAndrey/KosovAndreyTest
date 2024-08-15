package kosovandrey.test.report;

import kosovandrey.test.model.Duplicate;
import kosovandrey.test.model.Item;
import kosovandrey.test.result.DuplicateGroupTypeResult;
import kosovandrey.test.result.MaxMinWeightResult;
import kosovandrey.test.result.Result;
import kosovandrey.test.result.SumWeightGroupResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportTest {

    @Test
    public void testReportGeneration() {
        List<Item> items = List.of(
                new Item("grp1", "type1", 1, 100),
                new Item("grp1", "type1", 2, 150),
                new Item("grp2", "type2", 3, 200)
        );

        List<Item> duplicateItems = List.of(
                new Item("grp1", "type1", 1, 100),
                new Item("grp1", "type1", 2, 150)
        );

        DuplicateGroupTypeResult duplicateResult = new DuplicateGroupTypeResult(
                List.of(new Duplicate("grp1", "type1", duplicateItems))
        );

        MaxMinWeightResult maxMinWeightResult = new MaxMinWeightResult(200L, 100L);

        SumWeightGroupResult sumWeightGroupResult = new SumWeightGroupResult("grp1", 250L);

        Result result = new Result(duplicateResult, maxMinWeightResult, List.of(sumWeightGroupResult));

        Report report = new Report(result);
        List<String> reportOutput = report.getReport();

        reportOutput.forEach(System.out::println);

        try {
            assertTrue(reportOutput.stream().anyMatch(line -> line.contains("Duplicates by group: grp1 and type type1")));
            assertTrue(reportOutput.stream().anyMatch(line -> line.contains("Item: group: grp1, type: type1, number: 1, weight: 100")));
            assertTrue(reportOutput.stream().anyMatch(line -> line.contains("Max and min weights:")));
            assertTrue(reportOutput.stream().anyMatch(line -> line.contains("max: 200, min: 100")));
            assertTrue(reportOutput.stream().anyMatch(line -> line.contains("Sum of weights for group grp1: 250")));
        } catch (AssertionError e) {
            System.out.println("Report does not meet expectations:");
            reportOutput.forEach(System.out::println);
            throw e;
        }
    }
}