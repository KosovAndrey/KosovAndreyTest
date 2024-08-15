package kosovandrey.test;

import kosovandrey.test.loader.Loader;
import kosovandrey.test.model.Duplicate;
import kosovandrey.test.model.Item;
import kosovandrey.test.report.Report;
import kosovandrey.test.result.DuplicateGroupTypeResult;
import kosovandrey.test.result.MaxMinWeightResult;
import kosovandrey.test.result.Result;
import kosovandrey.test.result.SumWeightGroupResult;

import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter path of file (csv or json). Or type \"exit\" to exit.");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                exit(0);
            }

            Loader loader = new Loader();
            try {
                List<Item> items = loader.read(input);

                DuplicateGroupTypeResult duplicateGroupTypeResult = findDuplicates(items);
                MaxMinWeightResult maxMinWeightResult = findMaxMinWeight(items);
                SumWeightGroupResult sumWeightGroupResult = findSumWeightByGroup(items);

                Result result = new Result(duplicateGroupTypeResult, maxMinWeightResult, sumWeightGroupResult);

                Report report = new Report(result);
                List<String> reportBody = report.getReport();

                for (String line : reportBody) {
                    System.out.println(line);
                }

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static DuplicateGroupTypeResult findDuplicates(List<Item> items) {
        Map<String, Map<String, List<Item>>> groupedItems = new HashMap<>();

        for (Item item : items) {
            groupedItems
                    .computeIfAbsent(item.getGroup(), k -> new HashMap<>())
                    .computeIfAbsent(item.getType(), k -> new ArrayList<>())
                    .add(item);
        }

        List<Duplicate> duplicates = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<Item>>> groupEntry : groupedItems.entrySet()) {
            for (Map.Entry<String, List<Item>> typeEntry : groupEntry.getValue().entrySet()) {
                if (typeEntry.getValue().size() > 1) {
                    duplicates.add(new Duplicate(groupEntry.getKey(), typeEntry.getKey(), typeEntry.getValue()));
                }
            }
        }
        return new DuplicateGroupTypeResult(duplicates);
    }

    private static MaxMinWeightResult findMaxMinWeight(List<Item> items) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (Item item : items) {
            if (item.getWeight() > max) {
                max = item.getWeight();
            }
            if (item.getWeight() < min) {
                min = item.getWeight();
            }
        }
        return new MaxMinWeightResult(max, min);
    }

    private static SumWeightGroupResult findSumWeightByGroup(List<Item> items) {
        Map<String, Long> groupWeights = new HashMap<>();

        for (Item item : items) {
            groupWeights.put(item.getGroup(), groupWeights.getOrDefault(item.getGroup(), 0L) + item.getWeight());
        }

        String maxGroup = Collections.max(groupWeights.entrySet(), Map.Entry.comparingByValue()).getKey();
        Long maxWeight = groupWeights.get(maxGroup);

        return new SumWeightGroupResult(maxGroup, maxWeight);
    }
}