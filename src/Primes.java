public class Primes {
    static boolean isPrime(int n){

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }

    static int primeLoop(int start, int end){
        int counter = 0;

        for(int i = start; i <= end; i++){
            if(isPrime(i))
                counter++;
        }
        return counter;
    }
}
