package kosovandrey.test.loader;

import kosovandrey.test.model.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderTest {

    @Test
    public void testReadCsv() throws Exception {
        Loader loader = new Loader();
        String path = "src/test/resources/test-data.csv";
        List<Item> items = loader.read(path);

        assertNotNull(items);
        assertEquals(2, items.size());
        assertEquals("grp1", items.get(0).getGroup());
        assertEquals(111, items.get(0).getWeight());
    }

    @Test
    public void testUnsupportedFileExtension() {
        Loader loader = new Loader();
        String path = "src/test/resources/test-data.txt";

        Exception exception = assertThrows(Exception.class, () -> {
            loader.read(path);
        });

        assertEquals("File extension is not supported.", exception.getMessage());
    }

    @Test
    public void testFileNotFound() {
        Loader loader = new Loader();
        String path = "nonexistent-file.csv";

        Exception exception = assertThrows(Exception.class, () -> {
            loader.read(path);
        });
        assertTrue(exception.getMessage().contains("File not found"));
    }
}
