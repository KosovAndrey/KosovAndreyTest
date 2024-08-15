package kosovandrey.test.result;

import java.util.Objects;

public class SumWeightGroupResult {
    private String group = "";
    private Long sumWeight = 0L;

    public SumWeightGroupResult() {}

    public SumWeightGroupResult(String group, Long sumWeight) {
        this();
        this.group = group;
        this.sumWeight = sumWeight;
    }

    public String getGroup() { return this.group; }

    public Long getSumWeight() { return this.sumWeight; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SumWeightGroupResult that = (SumWeightGroupResult) obj;
        return Objects.equals(group, that.group) && Objects.equals(sumWeight, that.sumWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, sumWeight);
    }
}
