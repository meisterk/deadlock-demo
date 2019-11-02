public class FirtsBThenA implements Runnable {
    private Object lockA;
    private Object lockB;

    public FirtsBThenA(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockB) {
            System.out.println("B-A: Took lockB.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B-A: Waitng for lockA.");
            synchronized (lockA) {
                System.out.println("B-A: Took lockA.");
            }
        }
    }
}
