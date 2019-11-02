public class Main{
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread thread1 = new Thread(new FirstAThenB(lockA, lockB));
        Thread thread2 = new Thread(new FirtsBThenA(lockA, lockB));
        thread1.start();
        thread2.start();
    }
}