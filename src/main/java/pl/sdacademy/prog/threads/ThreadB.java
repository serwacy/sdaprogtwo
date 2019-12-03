package pl.sdacademy.prog.threads;

public class ThreadB implements Runnable {
    private String name;

    public ThreadB(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(name + " is eating breakfast");
            Thread.sleep(4000);
            System.out.println(name + " is eating dinner");
            Thread.sleep(2500);
            System.out.println(name + " is eating dessert");
            Thread.sleep(2000);
            System.out.println(name + " is watching TV");
            Thread.sleep(2000);
            System.out.println(name + " is drinking beer");
        } catch (final InterruptedException ignored) { }
    }
}
