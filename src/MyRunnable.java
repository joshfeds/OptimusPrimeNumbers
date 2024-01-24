public class MyRunnable implements Runnable {
    private int start;
    private int end;
    public MyRunnable(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run() {

        long []solutions = Primes.primeLoop(start, end);
        Main.updateCount(solutions);
    }
}
