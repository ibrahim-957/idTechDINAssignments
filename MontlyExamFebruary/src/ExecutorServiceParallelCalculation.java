import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ExecutorServiceParallelCalculation {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> (Callable<Integer>) () -> i * i)
                .toList();

        List<Future<Integer>> news = executorService.invokeAll(tasks);
        for (Future<Integer> future : news) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
