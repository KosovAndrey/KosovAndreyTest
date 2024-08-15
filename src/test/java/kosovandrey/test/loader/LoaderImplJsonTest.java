package kosovandrey.test.loader;

import kosovandrey.test.model.Item;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoaderImplJsonTest {

    @Test
    public void testReadJson() throws Exception {
        LoaderImplJson loader = new LoaderImplJson();
        String path = createTestJsonFile();

        List<Item> items = loader.read(path);

        assertNotNull(items);
        assertEquals(2, items.size());
        assertEquals("grp1", items.get(0).getGroup());
        assertEquals("type1", items.get(0).getType());
        assertEquals(111, items.get(0).getWeight());
    }

    private String createTestJsonFile() throws Exception {
        Path tempFile = Files.createTempFile("test-data", ".json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("[{\"group\":\"grp1\",\"type\":\"type1\",\"number\":1,\"weight\":111},");
            writer.write("{\"group\":\"grp2\",\"type\":\"type2\",\"number\":2,\"weight\":222}]");
        }
        return tempFile.toString();
    }
}
