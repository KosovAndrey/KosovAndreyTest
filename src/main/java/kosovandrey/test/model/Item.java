package kosovandrey.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private final String group;
    private final String type;
    private final long number;
    private final long weight;

    public Item(@JsonProperty("grp") String group, @JsonProperty("type") String type, @JsonProperty("num") long number, @JsonProperty("weight") long weight)
    {
        this.group = group;
        this.type = type;
        this.number = number;
        this.weight = weight;
    }

    public String getGroup() { return this.group; }

    public String getType() { return this.type; }

    public long getNumber() { return this.number; }

    public long getWeight() { return this.weight; }
}
