public class FirstAThenB implements Runnable {
    private Object lockA;
    private Object lockB;

    public FirstAThenB(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("A-B: Took lockA.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A-B: Waitng for lockA.");
            synchronized (lockB) {
                System.out.println("A-B: Took lockB.");
            }
        }
    }
}
