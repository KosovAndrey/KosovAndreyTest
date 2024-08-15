package kosovandrey.test.result;

import java.util.Objects;

public class SumWeightGroupResult {
    private String group;
    private long sumWeight;

    public SumWeightGroupResult() {
        this.group = "";
        this.sumWeight = 0L;
    }

    public SumWeightGroupResult(String group, long sumWeight) {
        this.group = group;
        this.sumWeight = sumWeight;
    }

    public String getGroup() {
        return group;
    }

    public long getSumWeight() {
        return sumWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumWeightGroupResult that = (SumWeightGroupResult) o;
        return sumWeight == that.sumWeight && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, sumWeight);
    }
}