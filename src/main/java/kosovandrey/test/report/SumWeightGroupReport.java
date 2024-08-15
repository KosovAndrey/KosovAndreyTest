package kosovandrey.test.report;

import kosovandrey.test.result.SumWeightGroupResult;

import java.util.List;

public class SumWeightGroupReport implements IReport {
    private final SumWeightGroupResult sumWeightGroupResult;

    public SumWeightGroupReport(SumWeightGroupResult sumWeightGroupResult) { this.sumWeightGroupResult = sumWeightGroupResult; }

    @Override
    public List<String> getBody() {
        String body = String.format("Sum of weights for group %s: %s\n", sumWeightGroupResult.getGroup(), sumWeightGroupResult.getSumWeight());
        return List.of(body);
    }
}
