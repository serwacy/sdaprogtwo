package pl.sdacademy.prog.threads;

import java.util.Optional;

public class ThreadA implements Runnable {
    private String name;

    public ThreadA(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
//            callItADayIfMamusiaIsCalling().orElseThrow();
            System.out.println(name + " is waking up");
            Thread.sleep(2000);
//            callItADayIfMamusiaIsCalling().orElseThrow();
            System.out.println(name + " is eating breakfast");
            Thread.sleep(5000);
//            callItADayIfMamusiaIsCalling().orElseThrow();
            System.out.println(name + " is coming back from school");
            Thread.sleep(1000);
//            callItADayIfMamusiaIsCalling().orElseThrow();
            System.out.println(name + " is eating dinner");
            Thread.sleep(2000);
//            callItADayIfMamusiaIsCalling().orElseThrow();
            System.out.println(name + " is doing homework");
        } catch (final InterruptedException ignored) {
            System.out.println("Mamusia is calling. I'm done, fool.");
        }
    }
    private Optional<Boolean> callItADayIfMamusiaIsCalling(){
        if(Thread.currentThread().isInterrupted()){
            System.out.println("Mamusia is calling. I'm done, fool.");
            return Optional.empty();
        }
        return Optional.of(true);
    }
}
