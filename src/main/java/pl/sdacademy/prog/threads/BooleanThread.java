package pl.sdacademy.prog.threads;

public class BooleanThread implements Runnable{
    private PackedBool packedBool;

    public BooleanThread(final PackedBool packedBool) {
        this.packedBool = packedBool;
    }

    @Override
    public void run() {
        for (int idx = 0; idx < 1000; idx++) {
            packedBool.stateChanger();
        }
    }
}
