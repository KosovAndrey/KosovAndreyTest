package kosovandrey.test.report;

import kosovandrey.test.result.MaxMinWeightResult;

import java.util.ArrayList;
import java.util.List;

public class MaxMinWeightReport implements IReport {
    private final MaxMinWeightResult maxMinWeightResult;

    public MaxMinWeightReport(MaxMinWeightResult maxMinWeightResult) {
        this.maxMinWeightResult = maxMinWeightResult;
    }

    @Override
    public List<String> getBody() {
        List<String> body = new ArrayList<>();
        body.add("Max and min weights:\n");
        body.add(String.format("max: %s, min: %s\n", maxMinWeightResult.getMax(), maxMinWeightResult.getMin()));
        return body;
    }
}
