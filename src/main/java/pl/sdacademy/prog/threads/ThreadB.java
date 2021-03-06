package pl.sdacademy.prog.threads;

import java.util.Optional;

public class ThreadB implements Runnable {
    private String name;

    public ThreadB(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
//            if(isMamusiaCalling()) return;
            System.out.println(name + " is eating breakfast");
            Thread.sleep(4000);
//            if(isMamusiaCalling()) return;
            System.out.println(name + " is eating dinner");
            Thread.sleep(2500);
//            if(isMamusiaCalling()) return;
            System.out.println(name + " is eating dessert");
            Thread.sleep(2000);
//            if(isMamusiaCalling()) return;
            System.out.println(name + " is watching TV");
            Thread.sleep(2000);
//            if(isMamusiaCalling()) return;
            System.out.println(name + " is drinking beer");
        } catch (final InterruptedException ignored) {
            System.out.println("Mamusia is calling. I'm done, fool.");
        }
    }
    private boolean isMamusiaCalling(){
        final boolean isInterrupted = Thread.currentThread().isInterrupted();
        if(isInterrupted){
            System.out.println("Mamusia is calling. I'm done, fool.");
        }
        return isInterrupted;
    }
}
