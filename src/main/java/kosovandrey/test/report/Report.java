package kosovandrey.test.report;

import kosovandrey.test.result.Result;

import java.util.ArrayList;
import java.util.List;

public class Report {
    Result result;

    public Report(Result result) { this.result = result; }

    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.addAll(new DuplicateGroupTypeReport(result.getDuplicateGroupTypeResult()).getBody());
        report.addAll(new MaxMinWeightReport(result.getMaxMinWeightResult()).getBody());
        report.addAll(new SumWeightGroupReport(result.getSumWeightGroupResult()).getBody());
        return report;
    }
}
