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
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

                ExecutorService executor = Executors.newFixedThreadPool(3);  // Создаем пул потоков

                Future<DuplicateGroupTypeResult> duplicatesFuture = executor.submit(() -> findDuplicates(items));
                Future<MaxMinWeightResult> maxMinWeightFuture = executor.submit(() -> findMaxMinWeight(items));
                Future<List<SumWeightGroupResult>> sumWeightGroupFuture = executor.submit(() -> findSumWeightByGroup(items));

                DuplicateGroupTypeResult duplicateGroupTypeResult = duplicatesFuture.get();
                MaxMinWeightResult maxMinWeightResult = maxMinWeightFuture.get();
                List<SumWeightGroupResult> sumWeightGroupResults = sumWeightGroupFuture.get();

                executor.shutdown();

                Result result = new Result(duplicateGroupTypeResult, maxMinWeightResult, sumWeightGroupResults);

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
        ConcurrentMap<String, ConcurrentMap<String, List<Item>>> groupedItems = items.parallelStream()
                .collect(Collectors.groupingByConcurrent(Item::getGroup,
                        Collectors.groupingByConcurrent(Item::getType)));

        List<Duplicate> duplicates = groupedItems.entrySet().parallelStream()
                .flatMap(groupEntry -> groupEntry.getValue().entrySet().parallelStream()
                        .filter(typeEntry -> typeEntry.getValue().size() > 1)
                        .map(typeEntry -> new Duplicate(groupEntry.getKey(), typeEntry.getKey(), typeEntry.getValue())))
                .collect(Collectors.toList());

        return new DuplicateGroupTypeResult(duplicates);
    }

    private static MaxMinWeightResult findMaxMinWeight(List<Item> items) {
        long max = items.parallelStream().mapToLong(Item::getWeight).max().orElse(Long.MIN_VALUE);
        long min = items.parallelStream().mapToLong(Item::getWeight).min().orElse(Long.MAX_VALUE);

        return new MaxMinWeightResult(max, min);
    }

    private static List<SumWeightGroupResult> findSumWeightByGroup(List<Item> items) {
        Map<String, Long> groupWeights = items.parallelStream()
                .collect(Collectors.groupingByConcurrent(Item::getGroup,
                        Collectors.summingLong(Item::getWeight)));

        return groupWeights.entrySet().parallelStream()
                .map(entry -> new SumWeightGroupResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}