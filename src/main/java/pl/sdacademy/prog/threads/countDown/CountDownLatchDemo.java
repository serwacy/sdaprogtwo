package pl.sdacademy.prog.threads.countDown;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final List<Thread> threads = Stream.generate(() -> new Thread(new CountDownThread(atomicInteger, countDownLatch)))
                .limit(5).collect(Collectors.toList());
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        threads.forEach(executorService::execute);
        executorService.shutdown();
//        threads.forEach(Thread::start);
//        threads.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException exp) {
//                exp.printStackTrace();
//            }
//        });
    }
}
