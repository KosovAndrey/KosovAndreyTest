package kosovandrey.test.report;

import kosovandrey.test.model.Duplicate;
import kosovandrey.test.model.Item;
import kosovandrey.test.result.DuplicateGroupTypeResult;

import java.util.ArrayList;
import java.util.List;

public class DuplicateGroupTypeReport implements IReport {
    private final DuplicateGroupTypeResult duplicateGroupTypeResult;

    public DuplicateGroupTypeReport(DuplicateGroupTypeResult duplicateGroupTypeResult) {
        this.duplicateGroupTypeResult = duplicateGroupTypeResult;
    }

    @Override
    public List<String> getBody() {
        List<String> body = new ArrayList<>();
        for (Duplicate duplicate : duplicateGroupTypeResult.getDuplicates()) {
            body.add(String.format("Duplicates by group: %s and type %s\n", duplicate.getGroup(), duplicate.getType()));
            for (Item item : duplicate.getItems()) {
                body.add(String.format("Item: group: %s, type: %s, number: %s, weight: %s\n", item.getGroup(), item.getType(), item.getNumber(), item.getWeight()));
            }
        }
        return body;
    }
}
