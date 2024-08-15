package kosovandrey.test.loader;

import kosovandrey.test.model.Item;

import java.io.IOException;
import java.util.List;

public interface ILoader {
    List<Item> read(String path) throws IOException;
}
