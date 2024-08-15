package kosovandrey.test.result;

import kosovandrey.test.model.Duplicate;

import java.util.List;
import java.util.Objects;

public class DuplicateGroupTypeResult {
    private List<Duplicate> duplicates;

    public DuplicateGroupTypeResult(List<Duplicate> duplicates) { this.duplicates = duplicates; }

    public List<Duplicate> getDuplicates() { return duplicates; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DuplicateGroupTypeResult that = (DuplicateGroupTypeResult) obj;
        return Objects.equals(duplicates, that.duplicates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duplicates);
    }
}
