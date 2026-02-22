import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceStreamApi {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        ExecutorService executorService = Executors.newFixedThreadPool(numbers.size());
        List<Future<Long>> futures = new ArrayList<>();
        for (Integer number : numbers) {
            futures.add(executorService.submit(() -> {
                        long fact = 1;
                        for (int i = 1; i <= number; i++) {
                            fact *= i;
                        }
                        return fact;
                    }
            ));
        }
        for (Future<Long> future : futures) {
            System.out.println(future.get());
        }
//        long sum = 0L;
//        for (Future<Long> future : futures) {
//            long longValue = future.get();
//            sum += longValue;
//        }

        long sum = futures.stream() // niye Integer də sum metodu olmaz da birdə long a çevirməli oluruq?
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .mapToLong(Long::longValue)
                .sum();
        executorService.shutdown();

        System.out.println("Sum = " + sum);

    }
}
