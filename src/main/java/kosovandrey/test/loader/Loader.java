package kosovandrey.test.loader;

import kosovandrey.test.model.Item;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader {
    private final String JSON = "json";
    private final String CSV = "csv";

    private Map<String, ILoader> mapLoader = new HashMap<>();

    public Loader() {
        mapLoader.put(JSON, new LoaderImplJson());
        mapLoader.put(CSV, new LoaderImplCsv());
    }

    public List<Item> read(String path) throws Exception {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            throw new Exception(String.format("File not found %s", path));
        }
        String extension = FilenameUtils.getExtension(path);
        if (mapLoader.containsKey(extension)) {
            return mapLoader.get(extension).read(path);
        }
        throw new Exception("File extension is not supported.");
    }
}
