package kosovandrey.test.loader;

import kosovandrey.test.model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoaderImplCsv implements ILoader {
    private final String COMMA_DELIMITER = ",";

    @Override
    public List<Item> read(String path) throws IOException {
        List<List<String>> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(COMMA_DELIMITER);
            list.add(Arrays.asList(values));
        }
        list.remove(0); //удаление заголовка
        List<Item> items = new ArrayList<>();
        for (List<String> row : list) {
            Item item = new Item(
                    row.get(0),
                    row.get(1),
                    Long.parseLong(row.get(2)),
                    Long.parseLong(row.get(3))
            );
            items.add(item);
        }
        return items;
    }
}
