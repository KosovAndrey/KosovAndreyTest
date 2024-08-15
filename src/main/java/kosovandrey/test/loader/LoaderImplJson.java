package kosovandrey.test.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kosovandrey.test.model.Item;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoaderImplJson implements ILoader {
    @Override
    public List<Item> read(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        String body = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        List<Item> items = mapper.readValue(body, new TypeReference<ArrayList<Item>>() {
        });
        return items;
    }
}
