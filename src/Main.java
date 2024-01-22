import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static boolean isPrime(int n){
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int counter = 0;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        for(int i = 2; i < 100000000; i++){
            if(isPrime(i))
                counter++;
        }
        long endTime = System.nanoTime();
        long elapsedTime =(endTime - startTime) / 1000000000;
        System.out.println("There are "+ counter + " prime numbers");
        System.out.println("Function took "+ elapsedTime + " seconds");

    }
}
