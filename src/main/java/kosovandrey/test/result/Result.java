package kosovandrey.test.result;

import java.util.Objects;

public class Result {
    private DuplicateGroupTypeResult duplicateGroupTypeResult;
    private MaxMinWeightResult maxMinWeightResult;
    private SumWeightGroupResult sumWeightGroupResult;

    public Result(DuplicateGroupTypeResult duplicateGroupTypeResult, MaxMinWeightResult maxMinWeightResult, SumWeightGroupResult sumWeightGroupResult) {
        this.duplicateGroupTypeResult = duplicateGroupTypeResult;
        this.maxMinWeightResult = maxMinWeightResult;
        this.sumWeightGroupResult = sumWeightGroupResult;
    }

    public DuplicateGroupTypeResult getDuplicateGroupTypeResult() { return this.duplicateGroupTypeResult; }

    public MaxMinWeightResult getMaxMinWeightResult() { return this.maxMinWeightResult; }

    public SumWeightGroupResult getSumWeightGroupResult() { return this.sumWeightGroupResult; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Result that = (Result) obj;
        return Objects.equals(duplicateGroupTypeResult, that.duplicateGroupTypeResult) && Objects.equals(maxMinWeightResult, that.maxMinWeightResult) && Objects.equals(sumWeightGroupResult, that.sumWeightGroupResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duplicateGroupTypeResult, maxMinWeightResult, sumWeightGroupResult);
    }
}
