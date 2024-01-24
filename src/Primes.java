public class Primes {
    static boolean isPrime(int n){

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }

    static long[] primeLoop(int start, int end){
        long [] array = new long[2];
        int counter = 0;
        long sum = 0;
        int index = 0;
        for(int i = start; i <= end; i++){
            if(isPrime(i)){
                counter++;
                sum += i;
                if(end == 100000000){
                    Main.arrayPrimes[index] = i;
                    index++;
                    if(index >= 10)
                        index = 0;
                }
            }

        }
        array[0] = counter;
        array[1] = sum;

        return array;
    }
}
