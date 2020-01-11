package pl.sdacademy.prog.threads;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
//        final Thread thrA = new Thread(new ThreadA("Ala"));
//        final Thread thrB = new Thread(new ThreadB("Janusz"));
//
//        thrA.start();
//        thrB.start();
//
//        Thread.sleep(3000);
//        thrA.interrupt();
//        thrB.interrupt();
//
//        thrA.join();
//        thrB.join();
//        ---------------------------------------------------
        PackedInt number = new PackedInt(new AtomicInteger(0));
        final Thread thrA = new Thread(new IntegerThread(number));
        final Thread thrB = new Thread(new IntegerThread(number));

        thrA.start();
        Thread.sleep(500);
        thrB.start();

        thrA.join();
        thrB.join();
        System.out.println(number.getValue());
//        ---------------------------------------------------
//        PackedBool bool = new PackedBool();
//        final List<Thread> threads = Stream.generate(() -> new Thread(new BooleanThread(bool)))
//                .limit(4).collect(Collectors.toList());
//        threads.forEach(Thread::start);
//        threads.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(bool.isValue());
    }
}
