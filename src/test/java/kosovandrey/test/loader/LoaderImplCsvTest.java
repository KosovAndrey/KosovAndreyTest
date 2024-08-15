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

public class LoaderImplCsvTest {

    @Test
    public void testReadCsv() throws Exception {
        LoaderImplCsv loader = new LoaderImplCsv();
        String path = createTestCsvFile();

        List<Item> items = loader.read(path);

        assertNotNull(items);
        assertEquals(2, items.size());
        assertEquals("grp1", items.get(0).getGroup());
        assertEquals("type1", items.get(0).getType());
        assertEquals(111, items.get(0).getWeight());
    }

    private String createTestCsvFile() throws Exception {
        Path tempFile = Files.createTempFile("test-data", ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("group,type,number,weight\n");
            writer.write("grp1,type1,1,111\n");
            writer.write("grp2,type2,2,222\n");
        }
        return tempFile.toString();
    }
}
