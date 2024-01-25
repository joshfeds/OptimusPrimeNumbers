import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    private static int totalCount = 0;
    private static long sumPrimes = 0;
    public static int [] arrayPrimes;

    public Main(){
        arrayPrimes = new int[10];
    }
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        int numThreads = 8;
        long startTime = System.nanoTime();
        Thread[] threads = new Thread[8];
        Main arr = new Main();
        int totalRangeStart = 2;
        int totalRangeEnd = 100000000;
        int rangeDivided = (totalRangeEnd - totalRangeStart + 1) / numThreads;

        for(int i = 0; i < numThreads; i++){
            int start = totalRangeStart + i * rangeDivided;
            int end;
            if(i == numThreads - 1)
                end = totalRangeEnd;
            else
                end = start + rangeDivided - 1;

            MyRunnable myRunnable = new MyRunnable(start, end);
            threads[i] = new Thread(myRunnable);
            threads[i].start();
        }

        for(int i = 0; i < numThreads; i++){
            threads[i].join();
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedSeconds = (double) elapsedTime / 1_000_000_000.0;
        Arrays.sort(arrayPrimes);

        PrintWriter writer = new PrintWriter("primes.txt");
        writer.println("Elapsed Time: " + elapsedSeconds + " seconds");
        writer.println(totalCount);
        writer.println(sumPrimes);
        writer.println(Arrays.toString(arrayPrimes));
        writer.close();
    }

    public static void updateCount(long[] sol){
        totalCount += (int) sol[0];
        sumPrimes += sol[1];
    }
}

