package pl.sdacademy.prog.threads;

import pl.sdacademy.prog.stra.CountryCurrencyData;

import java.util.Random;

public class IntegerThread implements Runnable{
    private PackedInt number;
    private static ThreadLocal<CountryCurrencyData> countryCurrencyDataThreadLocal = new ThreadLocal<>();

    public IntegerThread(final PackedInt number) {
        this.number = number;
    }

    @Override
    public void run() {
//        final CountryCurrencyData countryCurrencyData = countryCurrencyDataThreadLocal.get();
//        System.out.println(countryCurrencyData);
//        countryCurrencyDataThreadLocal.set(CountryCurrencyData.builder()
//            .amount(new Random().nextDouble())
//            .build());
//        System.out.println(countryCurrencyDataThreadLocal.get());

        for (int idx = 0; idx < 10000; idx++) {
            number.increment();
//            try {
//                Thread.sleep(10L);
//            }
//            catch (InterruptedException exp) {
//                exp.printStackTrace();
//            }
        }
    }
}
