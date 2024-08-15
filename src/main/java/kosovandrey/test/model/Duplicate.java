package kosovandrey.test.model;

import java.util.ArrayList;
import java.util.List;

public class Duplicate {
    private String group;
    private String type;
    private List<Item> items = new ArrayList<>();

    public Duplicate(String group, String type, List<Item> items) {
        this.group = group;
        this.type = type;
        this.items = items;
    }

    public String getGroup() { return this.group; }

    public String getType() { return this.type; }

    public List<Item> getItems() { return this.items; }

    public int getCount() { return this.items.size(); }

}