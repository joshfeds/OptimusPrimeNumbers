Analysis of Program

When determining how to split up the distribution for each thread, my first solution was to simply take indexes 2-9 and add each of them by 8 until they reach 100 million. However, upon further testing, I noticed that half of the threads were finishing almost instantly, while the other would take about 45 seconds to complete. This was happening because I forgot to account for the fact that all even numbers after 2 are not prime, meaning threads that began with even indexes would finish much quicker since there was nothing to check. The reason for this is that adding two even numbers will always result in another even number. To rectify this, I elected to give each thread an even distribution of the numbers, meaning each thread checked approximately 125000 numbers. By doing this, all threads would have prime numbers to check and roughly take the same amount of time. This change led to the program’s runtime reducing to approximately 13 seconds. By reaching each index once from 2 to 100 million, this function ran in O(n).


For my isPrime function, I created a for loop that goes from 2 to the square root of a given input. It is impossible to find any new integer factors greater than the square root of a given input, as any larger integers are already paired with their smaller counterparts. Let “x” be the input and “i” be a number from 2 to sqrt(x). I check if x mod i == 0. If true, I return false, as it means that the number is not prime since it has other factors aside from itself and 1. If I can get through the entire list of 2 -> sqrt x, then it means that the number is prime. At this step, I also add the prime number to my sum of all prime numbers so far. Thus, the runtime of this function was O (√n). If I were to improve the runtime of the program further, I would implement sieve of Eratosthenes, an algorithm for finding prime numbers within a given range that runs in O(n * log (log n)).

To check the 10 largest numbers in the primes, I created an if statement for the thread that checks the last 8th of the list. I added each prime number to an array of 10. Once it filled up, each index would get removed and replaced with the current prime number. Effectively, this was removing the smallest number from the list. Once it was done checking for primes, I used Arrays.sort to arrange the remaining numbers from smallest to largest. 