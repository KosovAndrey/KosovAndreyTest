package kosovandrey.test.result;

import java.util.Objects;

public class MaxMinWeightResult {
    private long max = 0L;
    private long min = 0L;

    public MaxMinWeightResult() {
    }

    public MaxMinWeightResult(Long max, Long min) {
        this();
        this.max = max;
        this.min = min;
    }

    public Long getMax() { return this.max; }

    public Long getMin() { return this.min; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MaxMinWeightResult that = (MaxMinWeightResult) obj;
        return Objects.equals(max, that.max) && Objects.equals(min, that.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }
}
