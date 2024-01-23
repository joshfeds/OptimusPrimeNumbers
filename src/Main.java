

public class Main {
    private static int totalCount = 0;
    public static void main(String[] args) throws InterruptedException {
        int[][] array = {
                {2, 12500001},
                {12500002, 25000000},
                {25000001 ,37499999},
                {37500000, 49999999},
                {50000000, 62499999},
                {62500000, 74999999},
                {75000000, 87499999},
                {87500000, 100000000}
        };
        int numThreads = 8;
        long startTime = System.nanoTime();
        Thread[] threads = new Thread[8];
        for(int i = 0; i < numThreads; i++){
            MyRunnable myRunnable = new MyRunnable(array[i][0], array[i][1]);
            threads[i] = new Thread(myRunnable);
            threads[i].start();
        }

        for(int i = 0; i < numThreads; i++){
            threads[i].join();
        }
        long endTime = System.nanoTime();
        //System.out.println(counter);
        long elapsedTime = endTime - startTime;
        double elapsedSeconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println("Elapsed Time: " + elapsedSeconds + " seconds");
        System.out.println(totalCount);
    }

    public static void updateCount(int count){
        totalCount += count;
    }
}

class MyRunnable implements Runnable {
    private int start;
    private int end;
    public MyRunnable(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run() {

        int count = Primes.primeLoop(start, end);
        Main.updateCount(count);
    }
}