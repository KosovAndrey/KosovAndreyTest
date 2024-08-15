package kosovandrey.test.result;

import java.util.List;
import java.util.Objects;

public class Result {
    private DuplicateGroupTypeResult duplicateGroupTypeResult;
    private MaxMinWeightResult maxMinWeightResult;
    private List<SumWeightGroupResult> sumWeightGroupResults; // Изменение здесь

    public Result(DuplicateGroupTypeResult duplicateGroupTypeResult, MaxMinWeightResult maxMinWeightResult, List<SumWeightGroupResult> sumWeightGroupResults) {
        this.duplicateGroupTypeResult = duplicateGroupTypeResult;
        this.maxMinWeightResult = maxMinWeightResult;
        this.sumWeightGroupResults = sumWeightGroupResults;
    }

    public DuplicateGroupTypeResult getDuplicateGroupTypeResult() { return this.duplicateGroupTypeResult; }

    public MaxMinWeightResult getMaxMinWeightResult() { return this.maxMinWeightResult; }

    public List<SumWeightGroupResult> getSumWeightGroupResults() { return this.sumWeightGroupResults; } // Изменение здесь

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Result that = (Result) obj;
        return Objects.equals(duplicateGroupTypeResult, that.duplicateGroupTypeResult) &&
                Objects.equals(maxMinWeightResult, that.maxMinWeightResult) &&
                Objects.equals(sumWeightGroupResults, that.sumWeightGroupResults); // Изменение здесь
    }

    @Override
    public int hashCode() {
        return Objects.hash(duplicateGroupTypeResult, maxMinWeightResult, sumWeightGroupResults); // Изменение здесь
    }
}